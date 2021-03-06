package com.sensing.core.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.sensing.core.bean.SysParam;
import com.sensing.core.bean.SysTypecode;
import com.sensing.core.service.ISysTypecodeService;
import com.sensing.core.service.ISysParamService;
import com.sensing.core.utils.BaseController;
import com.sensing.core.utils.Constants;
import com.sensing.core.utils.RemoteShellExecutor;
import com.sensing.core.utils.ResponseBean;
import com.sensing.core.utils.props.PropUtils;
import com.sensing.core.utils.results.ResultUtils;

@Controller
@RequestMapping("/timeInit")
public class TimeInitController extends BaseController{
	private static final Log log = LogFactory.getLog(TimeInitController.class);
	@Autowired
	ISysParamService timeInitService;
	@Autowired
	public ISysTypecodeService sysTypeCodeService;
	@ResponseBody
    @RequestMapping("/initByHand")
    public ResponseBean initByHand(@RequestBody JSONObject p) {
		 ResponseBean result = new ResponseBean();
		 String date=p.getString("date");
		 String time=p.getString("time");
		 String zone=p.getString("zone");
		 String cmd = "";
		 try {
			 //远程命令执行
			 RemoteShellExecutor executor = new RemoteShellExecutor(
					 PropUtils.getString("remote.shell.ip1"),
					 PropUtils.getInt("remote.shell.port1"),
					 PropUtils.getString("remote.shell.username1"),
					 PropUtils.getString("remote.shell.password1"),
					 "utf-8"
					 );
			 
			 cmd="sed -i '/ntpdate/d' /var/spool/cron/root";//去除掉原来的定时任务设置
			 executor.exec(cmd);
			 cmd="timedatectl set-ntp no";
			 executor.exec(cmd);
			 cmd = "timedatectl set-timezone \""+zone+"\"";
			 executor.exec(cmd);

			 cmd = "timedatectl set-time \""+date+" "+time+"\"";
			 executor.exec(cmd);
			 saveTime(p);
			 result = ResultUtils.success();
		 } catch (IOException e) {
			 result.setError(-1);
			 result.setMessage(e.getMessage());
			 log.error(e);
		 } catch (Exception e) {
			 result.setError(-1);
			 result.setMessage(e.getMessage());
			 log.error(e);
		}
		 return result;
	}
	@ResponseBody
    @RequestMapping("/initByNTP")
    public ResponseBean initByNTP(@RequestBody JSONObject p) {
		ResponseBean result = new ResponseBean();
		String zone=p.getString("zone");
		String ip=p.getString("ip");
		//String port=p.getString("port");
		String rate=p.getString("rate");
		String cmd = "";
		String cmdResult = "";
		 
		//远程命令执行
		RemoteShellExecutor executor = new RemoteShellExecutor(
				PropUtils.getString("remote.shell.ip1"),
				PropUtils.getInt("remote.shell.port1"),
				PropUtils.getString("remote.shell.username1"),
				PropUtils.getString("remote.shell.password1"),
				"utf-8"
				);
		try {
			cmd = "timedatectl set-timezone \""+zone+"\"";
			executor.exec(cmd);

			//ntpd服务起来的时候，端口被占用报错，ntpdate[27578]: the NTP socket is in use, exiting，停止服务service ntpd stop
			//-u 它不再使用默认的端口，而是使用了一个别的端口，所以避免了端口冲突。
			cmd="ntpdate -u "+ip;
			cmdResult = executor.exec(cmd);
			if ( StringUtils.isEmpty(cmdResult) || !cmdResult.contains("offset") ) {
				result = ResultUtils.error(-1,"时间同步失败，请检查ntp服务");
				return result;
			}
			
	    	cmd="sed -i '/ntpdate/d' /var/spool/cron/root";//去除掉原来的定时任务设置
	    	executor.exec(cmd);
			cmd="echo \"00 */"+rate+" * * * root /usr/sbin/ntpdate "+ip+"\" >>/var/spool/cron/root";//新增定时任务
			executor.exec(cmd);
			saveTime(p);
			result = ResultUtils.success();
		} catch (Exception e) {
			result.setError(-1);
			result.setMessage(e.getMessage());
			log.error(e);
		}
		 return result;
	}
	@ResponseBody
    @RequestMapping("/queryTimeSyn")
    public ResponseBean queryTimeSyn() {
		ResponseBean result = new ResponseBean();
		try {
			List<SysParam> paramList = timeInitService.queryTimeSyn(Constants.SYS_TIMESYN);
			Map<String,Object> resultMap = new HashMap<String, Object>();
			if ( paramList != null && paramList.size() > 0 ) {
				for (int i = 0; i < paramList.size() ; i++) {
					SysParam sysParam = paramList.get(i);
					resultMap.put(sysParam.getParam(),sysParam.getValue());
				}
			}
			result.setError(0);
			result.setMessage("successful");
			result.getMap().put("result", resultMap);
		} catch (Exception e) {
			result.setError(-1);
		    result.setMessage(e.getMessage());
		    log.error(e);
		}
		return result;
	}
	@ResponseBody
    @RequestMapping("/queryTimeZones")
    public ResponseBean queryTimeZones() {
		ResponseBean result = new ResponseBean();
		try {
			List<SysTypecode>SysTypecode=sysTypeCodeService
					.querySysTypeCodeByTypeCodeAndItemId(Constants.SYS_TYPECODE_TIMEZONES, null);
			result.setError(0);
			result.setMessage("successful");
			result.getMap().put("dates", SysTypecode);
		} catch (Exception e) {
			result.setError(-1);
			result.setMessage(e.getMessage());
			log.error(e);
		}
		return result;
	}
    private  void saveTime(@RequestBody JSONObject p) throws Exception {
    	String zone=p.getString("zone");
    	String ip=p.getString("ip");
    	String port=p.getString("port");
    	String rate=p.getString("rate");
		List<SysParam> params=new ArrayList<SysParam>();
		if ( StringUtils.isNotEmpty(ip) ) {
			params.add(setparam("type","1"));
		}else{
			params.add(setparam("type","2"));
		}
		params.add(setparam("time_zone", zone));
		params.add(setparam("ip", ip));
		params.add(setparam("port", port));
		params.add(setparam("rate", rate));
		timeInitService.updateParam(params);
	}
	private SysParam setparam(String key,String value)
	{
		SysParam param=new SysParam();
		param.setParam(key);
		param.setTypeCode(Constants.SYS_TIMESYN);
		param.setValue(value);
		return param;
	}
}
