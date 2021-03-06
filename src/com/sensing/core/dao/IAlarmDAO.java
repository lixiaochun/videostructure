package com.sensing.core.dao;

import java.util.List;
import java.util.Map;

import com.sensing.core.bean.job.resp.JobAlarmCount;
import org.apache.ibatis.annotations.Param;

import com.sensing.core.bean.Alarm;
import com.sensing.core.bean.alarm.req.AlarmReq;
import com.sensing.core.bean.alarm.resp.AlarmDetailResp;
import com.sensing.core.bean.alarm.resp.AlarmResp;
import com.sensing.core.bean.alarm.resp.CapImgResp;
import com.sensing.core.utils.Pager;

/**
 * @author mingxingyu
 */
public interface IAlarmDAO {

	/**
	 * 统计告警数量 单日告警的数量和未审核的告警数量
	 * 
	 * @param params
	 * @return
	 * @throws Exception
	 * @author mingxingyu
	 * @date 2018年12月10日 下午6:28:25
	 */
	public Map<String, Object> queryAlarmStatistics(Map<String, Object> params) throws Exception;

	/**
	 * 首页的最新四条告警信息查询
	 * 
	 * @return
	 * @author mingxingyu
	 * @date 2018年12月7日 下午4:31:07
	 */
	public List<Map<String, Object>> queryAlarmHomePage(@Param("userUuid") String userUuid,
			@Param("state") Integer state, @Param("pageRows") Integer pageRows) throws Exception;

	public int saveAlarm(Alarm alarm) throws Exception;

	public Alarm getAlarm(java.lang.String uuid);

	public int removeAlarm(java.lang.String uuid) throws Exception;

	public int updateAlarm(Alarm alarm);

	public List<AlarmResp> queryList(AlarmReq pager);

	public int selectCount(Pager pager);

	public AlarmDetailResp queryByUuid(@Param("uuid") String uuid);

	public List<CapImgResp> queryImgByUuid(@Param("uuid") String uuid);

	public List<JobAlarmCount> getAlarmCountByJobsUuId(@Param("jobsUuids") List<String> jobsUuids);

	public List<AlarmResp> queryAlarmData(AlarmReq pager);

	public List<String> queryCapUuids(AlarmReq alarmReq);

	public String nextUuid(AlarmReq pager);

	public String prevUuid(AlarmReq pager);

	public List<AlarmResp> queryByAlarmId(AlarmReq pager) throws Exception;

	public int queryByAlarmIdCount(Pager pager) throws Exception;

	public int queryAlarmCount(Map<String, Object> map) throws Exception;
}
