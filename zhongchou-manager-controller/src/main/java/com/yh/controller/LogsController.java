package com.yh.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.dubbo.common.json.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yh.pojo.Logs;
import com.yh.pojo.LogsExample;
import com.yh.pojo.LogsExample.Criteria;
import com.yh.pojo.User;
import com.yh.pojo.zhongchouResult;
import com.yh.service.LogsService;

/**
 * 用户日志
 * 
 * @author 陈家亮
 * 
 */
@Controller
public class LogsController {

	@Autowired
	private LogsService logsService;
	

	// 用户日志列表
	@RequestMapping("/logsList")
	public String logsList(HttpServletRequest req) {
		//设置分页
		String count = req.getParameter("count");
		String pages = req.getParameter("pages");
		int page = 1;
		if(pages==null ){
			pages = "1";
			page = Integer.parseInt(pages);
		}else{
			page = Integer.parseInt(pages);
		}
		int coun = 5;
		if(count == null ){
			count="5";
			 coun = Integer.parseInt(count);
		}else{
			coun = Integer.parseInt(count);
		}

		PageHelper.startPage(page,coun);
		
		String logContent = req.getParameter("logContent");
		String logUsId = req.getParameter("logUsId");
		
		if(logUsId!=null){
			int usId = Integer.parseInt(logUsId);
			/*Logs logs = new Logs();
			logs.setLogContent(logContent);
			logs.setLogUsId(usId);*/
			System.out.println(usId+"?111111111111111111");
			List<Logs> lists = logsService.selectLogsByUid(usId);
			PageInfo<Logs> info = new PageInfo<>(lists);
			req.setAttribute("pb", info);
			req.setAttribute("list",lists);
			
		}else{
		List<Logs> list = logsService.selectLogsAll();
		PageInfo<Logs> info = new PageInfo<>(list);
		req.setAttribute("pb", info);
		req.setAttribute("list", list);

		}
		
		
		return "logsList";

	}

	// 添加
	@RequestMapping("/goLogsAdd")
	public String goLogsAdd(Logs logs) {
		int addLogs = logsService.addLogs(logs);
		if (addLogs != 1) {
			return "error";
		}
		return "success";

	}

	// 详情
	@RequestMapping("/goLogsUpdate")
	public String goLogsUpdate(HttpServletRequest request, Integer id) {
		Logs logs = logsService.selectLogsById(id);
		User user = logsService.selectUserById(id);
		request.setAttribute("logs", logs);
		request.setAttribute("user", user);
		return "goLogsUpdate";

	}

	@RequestMapping("/logsUpdate")
	public String logsUpdate(Logs logs) {
		int updateLogs = logsService.updateLogs(logs);
		if (updateLogs == 1) {
			return "success";
		}
		return "error";

	}

	// 删除
	@RequestMapping(value="/logsDelete", produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public String logsDelete(HttpServletRequest req) {
		String id = req.getParameter("id");
		zhongchouResult delteteLogs = logsService.delteteLogs(Integer.parseInt(id));
		String json = "";
		try {
			json = JSON.json(delteteLogs);
		} catch (IOException e) {
		
		}
		return json;
	}
	
	
	


}
