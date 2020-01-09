package com.yh.web.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.dubbo.common.json.JSON;
import com.yh.pojo.Questionall;
import com.yh.pojo.zhongchouResult;
import com.yh.service.questionall.QuestionallService;

@Controller
public class IndexController {
	
	@Autowired
	private QuestionallService questionallService;
	
	
	@RequestMapping("/")
	public String index(){
		return "index";
	}
	
	@RequestMapping(value="/questionall", produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public String questionall(){
		List<Questionall> list = questionallService.selectQuestionallAll();
		zhongchouResult result = zhongchouResult.ok(200, "成功", list);
		
		System.out.println(result);
		
		
		String json="";
		try {
			json = JSON.json(result);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return json;
	}
}
