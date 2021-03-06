package com.sensing.core.controller;

import javax.annotation.Resource;

import com.sensing.core.bean.*;
import com.sensing.core.service.ISysResourceService;
import com.sensing.core.utils.StringUtils;
import com.sensing.core.utils.ValidationUtils;
import com.sensing.core.utils.results.ResultUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.sensing.core.service.ISysRoleService;
import com.sensing.core.utils.BaseController;
import com.sensing.core.utils.Pager;
import com.sensing.core.utils.ResponseBean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 系统角色管理
 * ************************************************ start *******************************************
 * 2018-12-20
 * 默认权限如下
 * 超级管理员：
 * 1）全部权限
 * 管理员：
 * 1）布控（仅审批权限）、资源管理（全部）、系统管理（全部）
 * *
 * *
 * 2019-01-28
 * 用户列表，超级管理员看到的是所有的列表
 * 角色列表，超级管理员能看到所有的列表
 *
 * 用户列表，非超级管理员看到的是当前用户自己创建的
 * 角色列表，非超级管理员能看的是，当前列表除了超级管理员之外的所有用户（对接人：2019-01-28，李艺哲）
 * ************************************************  end  ************************************************
 */


@Controller
@RequestMapping("/sysRole")
@SuppressWarnings("all")
public class SysRoleController extends BaseController {

    private static final Log log = LogFactory.getLog(SysRoleController.class);

    @Resource
    public ISysRoleService sysRoleService;

    /**
     * 查询角色列表
     *
     * @param req
     * @return
     */
    @ResponseBody
    @RequestMapping("/query")
    public ResponseBean query(@RequestBody SysRoleReq req) {
        req.setUuid(getUser().getUuid());
        Pager pager = sysRoleService.queryPage(req);
        ResponseBean result;
        if (pager == null) {
            result = new ResponseBean(100, "fail", null);
        } else {
            Map map = new HashMap();
            map.put("pager", pager);
            result = new ResponseBean(0, "success", map);
        }
        return result;
    }

    /**
     * 更新操作
     *
     * @param req
     * @return
     */
    @ResponseBody
    @RequestMapping("/update")
    public ResponseBean update(@RequestBody SysRoleSaveReq req) {
        ResponseBean result = new ResponseBean();
        if (req == null && req.getRoleId() == null) {
            return ResultUtils.REQUIRED_EMPTY_ERROR();
        }
        return sysRoleService.updateSysRole(req);
    }

    /**
     * 编辑的时候获取拥有的资源
     *
     * @param req
     * @return
     */
    @ResponseBody
    @RequestMapping("/getsysresoonedit")
    public ResponseBean getSysResOnEdit(@RequestBody SysResoEdidReq req) {
        if (req == null || req.getRoleId() == null) {
            return ResultUtils.REQUIRED_EMPTY_ERROR();
        }
        req.setUserUuid(getUser().getUuid());
        List<SysResource> resp = sysRoleService.getSysResOnEdit(req);
        Map map = new HashMap();
        map.put("resultList", resp);
        ResponseBean success = ResultUtils.success(map);
        return success;
    }

    /**
     * 角色新建保存
     */
    @ResponseBody
    @RequestMapping("/save")
    public ResponseBean save(@RequestBody SysRoleSaveReq req) {
    	ResponseBean result = new ResponseBean();
    	String validateInfo = validateData(req, 1);
    	if (validateInfo != null) {
			return ResultUtils.error(result, 1000, validateInfo);
		}
        req.setUserUUid(getUser().getUuid());
        int code = sysRoleService.saveNewSysRole(req);
        result.setError(code > 0 ? 0 : -1);
        result.setMessage(code > 0 ? "successful" : "fail");
        return result;
    }

	private String validateData(SysRoleSaveReq req, int i) {
		 if (req == null || StringUtils.isEmptyOrNull(req.getRoleName()) || CollectionUtils.isEmpty(req.getSysResourceIds())) {
	            return  "参数不全";
	        }
		 if(!ValidationUtils.checkStrLengthLess(req.getRoleName(), 16)) {
			 return "角色名称限16个字符";
		 }
		 List<SysRole> list = sysRoleService.getSysRoleByName(req.getRoleName());
	     if(list != null && list.size() >0) {
	        return "角色名称已存在";
	     }
		return null;
	}

}
