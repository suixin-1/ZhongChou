package com.yh.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.dubbo.common.json.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yh.pojo.ProjectA;
import com.yh.pojo.Projects;
import com.yh.pojo.Questionall;
import com.yh.pojo.User;
import com.yh.pojo.zhongchouResult;
import com.yh.service.ProjectService;
import com.yh.service.questionall.QuestionallService;

@Controller
public class IndexController {
	
	@Autowired
	private QuestionallService questionallService;
	
	@Autowired
	private ProjectService projectService;
	
	@RequestMapping("/")
	public String index(){

		return "index";
	}
	
	@RequestMapping(value="/questionall", produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public String questionall(HttpServletRequest req){
		List<Questionall> list = questionallService.selectQuestionallAll();
		zhongchouResult result = zhongchouResult.ok(200, "成功", list);
		String json="";
		try {
			json = JSON.json(result);
		} catch (IOException e1) {
			
			e1.printStackTrace();
		}
		return json;
	}
	//跳转到众筹资讯页面
	@RequestMapping("/ly-list")
	public String toLylist(){
		return "ly-list";
	}
	
	//众筹资讯查询方法
	@RequestMapping(value="/information", produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public String information( ){
		List<Projects> list = projectService.selectProjectsAll();
		zhongchouResult result = zhongchouResult.ok(200, "成功" ,list);	
		String json="";
		try {
			json = JSON.json(result);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return json;
	}
}
