package com.sensing.core.service;

import com.sensing.core.bean.*;
import com.sensing.core.utils.Pager;
import com.sensing.core.utils.ResponseBean;

import java.util.List;
import java.util.Map;

/**
 * @author wenbo
 */
public interface ITaskService {

    public TaskRequest saveNewTask(TaskRequest task);

    public TaskRequest updateTask(TaskRequest task);

    public Task updateState(Task task);

    public abstract Task findTaskById(java.lang.String uuid);

    public abstract void removeTask(java.lang.String uuid);

    public List<TaskChannel> getTaskChannelByChannelIds(List<String> list);

    public Pager query(Pager pager);

    public Pager queryListByName(Pager pager);

    public TaskResp info(String uuid);

    public List<Task> getUpdateStateTask(List<Integer> list);

    public int getrunningtaskCount(RunningTaskCountReq req);

    ResponseBean stoptaskByUuId(StopTaskReq req);

    ResponseBean startTaskByUuId(StopTaskReq req);

    List<Task> getTaskByName(String name, Integer type);

    Map getAnalyTimeByUuid(String taskUuid);

	public Map<String, Object> getTaskCount();
	
	/**
	 * 离线视频任务处理完成之后，抓拍通知修改库状态
	 * @param deviceUuid 通道的uuid 
	 * @param status 抓拍完成情况的状态值
	 * @return
	 * @author mingxingyu
	 * @date   2019年3月14日 下午1:46:02
	 */
	public ReturnMsg callStaticVideo(String deviceUuid,Integer status);
	
	/**
	 * 历史视频通道处理完毕的回调处理
	 * @param deviceId	通道的uuid
	 * @param taskId	任务的uuid
	 * @param status	回调状态码
	 * @return
	 * @author mingxingyu
	 * @date   2019年6月11日 下午4:52:19
	 */
	public ResponseBean callRecordVideo(String deviceId,String taskId,Integer status);
}