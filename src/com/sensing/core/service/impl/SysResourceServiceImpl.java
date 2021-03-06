package com.sensing.core.service.impl;

import java.util.*;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import com.sensing.core.utils.StringUtils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.sensing.core.bean.SysResource;
import com.sensing.core.cacahes.CacheManagerImpl;
import com.sensing.core.dao.ISysResourceDAO;
import com.sensing.core.service.ISysResourceService;
import com.sensing.core.utils.Exception.BussinessException;
import com.sensing.core.utils.Pager;

import org.springframework.util.CollectionUtils;

/**
 * @author wenbo
 */
@Service
public class SysResourceServiceImpl implements ISysResourceService {


    private static final Log log = LogFactory.getLog(ISysResourceService.class);

    @Resource
    public ISysResourceDAO sysResourceDAO;

    public SysResourceServiceImpl() {
        super();
    }

    
    /**
     * 查询操作日志的二级联通的选项
     * @return
     * @throws Exception
     * @author mingxingyu
     * @date   2019年4月11日 上午11:46:16
     */
    public Pager queryOpeLog() throws Exception{
    	try {
    		Pager pager = new Pager();
    		List<SysResource> list = sysResourceDAO.queryOpeLogList();
    		
    		List<SysResource> resultList = new ArrayList<SysResource>();
    		//list不为空的情况下，整理一个二级关联的列表
    		if ( list != null && list.size() > 0  ) {
				for ( int i = 0; i < list.size() ; i++ ) {
					SysResource sr = null;
					SysResource sysResource = list.get(i);
					String[] titleArrs = sysResource.getTitle().split("-");
					
					boolean existTitleFlag = false;
					for (int j = 0; j < resultList.size(); j++) {
						if(resultList.get(j).getTitle().equals(titleArrs[0])){
							sr = resultList.get(j);
							existTitleFlag = true;
							break;
						}
					}
					if ( !existTitleFlag ) {
						sr = new SysResource();
						sr.setTitle(titleArrs[0]);
						sr.setProjectType(sysResource.getProjectType());
						sr.setChildResoList(new ArrayList<SysResource>());
						
						resultList.add(sr);
					}
					
					SysResource srTemp = new SysResource();
					srTemp.setTitle(titleArrs[1]);
					srTemp.setProjectType(sysResource.getProjectType());
					sr.getChildResoList().add(srTemp);
				}
			}
    		
    		int totalCount = sysResourceDAO.queryOpeLogCount();
    		pager.setTotalCount(totalCount);
    		pager.setResultList(resultList);
    		return pager;
		} catch (Exception e) {
			log.error("查询操作日志的二级联通的选项,发生异常:"+e.getMessage());
			e.printStackTrace();
		}
    	return null;
    }
    
    @Override
    public SysResource saveNewSysResource(SysResource sysResource) throws Exception {
        try {
            sysResourceDAO.saveSysResource(sysResource);
        } catch (Exception e) {
            log.error(e);
            throw new BussinessException(e);
        }
        return sysResource;
    }

    @Override
    public SysResource updateSysResource(SysResource sysResource) throws Exception {
        sysResourceDAO.updateSysResource(sysResource);
        return sysResource;
    }

    @Override
    public SysResource findSysResourceById(Integer id) throws Exception {
        try {
            return sysResourceDAO.getSysResource(id);
        } catch (Exception e) {
            log.error(e);
            throw new BussinessException(e);
        }
    }

    @Override
    public void removeSysResource(Integer id) throws Exception {
        try {
            sysResourceDAO.removeSysResource(id);
        } catch (Exception e) {
            log.error(e);
            throw new BussinessException(e);
        }
    }

    @Override
    public Pager queryPage(Pager pager) throws Exception {
        try {
            List<SysResource> list = sysResourceDAO.queryList(pager);
            int totalCount = sysResourceDAO.selectCount(pager);
            pager.setTotalCount(totalCount);
            pager.setResultList(list);
        } catch (Exception e) {
            log.error(e);
            throw new BussinessException(e);
        }
        return pager;
    }

    /**
     * 根据用户名查询所属资源信息
     */
    public List<SysResource> queryResourceByUserName(String userName) throws Exception {
        return sysResourceDAO.selectResourceByUserName(userName);
    }

    /**
     * 排序问题，代码中排序
     *
     * @param uuid
     * @return
     */
    @Override
    public List<SysResource> getSysResoByUuid(String uuid) {
        if (StringUtils.isEmptyOrNull(uuid)) {
            return null;
        }
        // 2018/9/5  一个用户会对应多个角色，多个角色的时候取合集
        List<Integer> roleIds = sysResourceDAO.getRoleByUuId(uuid);
        List<SysResource> list = sysResourceDAO.getSysResoByRoleIds(roleIds, 0);

        /***  一级分类   *****/
        List<SysResource> first = list.stream().filter(a -> a.getParentId().intValue() == 0).collect(Collectors.toList());
        for (SysResource firstReso : first) {
            /***  二级分类   *****/
            List<SysResource> second = list.stream().filter(a -> firstReso.getId().intValue() == a.getParentId().intValue()).collect(Collectors.toList());
            for (SysResource secondReso : second) {
                /***  三级分类   *****/
                List<SysResource> third = list.stream().filter(a -> secondReso.getId().intValue() == a.getParentId().intValue()).collect(Collectors.toList());
                for (SysResource thirdReso : third) {
                    /***  四级分类   *****/
                    List<SysResource> four = list.stream().filter(a -> thirdReso.getId().intValue() == a.getParentId().intValue()).collect(Collectors.toList());
                    four.sort(Comparator.comparing(SysResource::getOrde));
                    thirdReso.setChildResoList(four);
                }
                third.sort(Comparator.comparing(SysResource::getOrde));
                secondReso.setChildResoList(third);
            }
            second.sort(Comparator.comparing(SysResource::getOrde));
            firstReso.setChildResoList(second);
        }
        first.sort(Comparator.comparing(SysResource::getOrde));
        return first;
    }


    @Override
    public List<String> getSysResoSearchCode(String uuid) {
//        List<SysResource> list = getSysReso(uuid);

        List<Integer> roleIds = sysResourceDAO.getRoleByUuId(uuid);
        if (CollectionUtils.isEmpty(roleIds)) {
            return new ArrayList<>();
        }
        List<SysResource> list = sysResourceDAO.getSysResoByRoleIds(roleIds, 0);
        List<String> serchCodeList = list.stream().map(a -> a.getSearchCode()).collect(Collectors.toList());
        return serchCodeList;
    }

    private List<SysResource> getSysReso(String uuid) {
        // 2018/9/5  一个用户会对应多个角色，多个角色的时候取合集
        List<Integer> roleIds = sysResourceDAO.getRoleByUuId(uuid);
        if (CollectionUtils.isEmpty(roleIds)) {
            return new ArrayList<>();
        }
        List<SysResource> list = sysResourceDAO.getSysResoByRoleIds(roleIds, null);
        return list;
    }


    @Override
    public void queryResource() throws Exception {
        List<SysResource> getRes = sysResourceDAO.queryResourceByMethod();
        if (CollectionUtils.isEmpty(getRes)) {
        	log.error("系统初始化加载系统资源信息，发生错误，未查询到资源数据。");
            return;
        }
        for (SysResource sysR : getRes) {
            CacheManagerImpl.putCache(sysR.getParentId() + "", sysR.getTitle());
        }
    }

}