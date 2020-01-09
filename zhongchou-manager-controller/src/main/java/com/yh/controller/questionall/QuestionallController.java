package com.yh.controller.questionall;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.common.json.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yh.pojo.ProjectA;
import com.yh.pojo.Questionall;
import com.yh.pojo.Questionother;
import com.yh.pojo.zhongchouResult;
import com.yh.service.questionall.QuestionallService;

/**
 * 
 * @author Administrator
 *	问题 controller
 */
@Controller
public class QuestionallController {
	
	@Autowired
	private QuestionallService questionallService;
	
	@RequestMapping("/parentQuestionall")
	public String parentQuestionall(Model model,HttpServletRequest res){
		String count = res.getParameter("count");
		String pages = res.getParameter("pages");
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
		List<Questionall> list = questionallService.selectQuestionallAll();
		PageInfo<Questionall> pageInfo = new PageInfo<Questionall>(list);
		model.addAttribute("list",list);
		model.addAttribute("pb", pageInfo);
		return "issue/parentQuestionall";
	}
	
	
	@RequestMapping("/addproblemQuestionall")
	public String addproblemQuestionall(){
		return "issue/addproblem";
	}
	
	@RequestMapping(value="/addQuestionall", produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public String addQuestionall(HttpServletRequest req){
		try {
			req.setCharacterEncoding("UTF-8");
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String questionname = req.getParameter("questionname");
		System.out.println(questionname+"sssssssssssss");
		zhongchouResult addQuestionall = questionallService.addQuestionall(questionname);
		String json = "";
		try {
			json = JSON.json(addQuestionall);
		} catch (IOException e) {
		
		}
		return json;

	}
	
	@RequestMapping("/ToQuestionother")
	public String ToQuestionother(HttpServletRequest req){
		
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
		
		
		String questionid = req.getParameter("questionid");
		String questionname = req.getParameter("questionname");
		PageHelper.startPage(page,coun);
		List<Questionother> list = questionallService.selectQuestionother(Integer.parseInt(questionid));
		PageInfo<Questionother> pageInfo = new PageInfo<Questionother>(list);
		req.setAttribute("pb", pageInfo);
		req.setAttribute("list", list);
		String string="";
		try {
			string= new String(questionname.getBytes("iso-8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			System.out.println("编码失败");
			e.printStackTrace();
		}
		req.setAttribute("questionname", string);
		return "issue/ZWT";
	}
	
	
	//详情修改子问题
	@RequestMapping("/ToupdateQuestionother")
	public String ToupdateQuestionother(HttpServletRequest req){
		String id = req.getParameter("id");
		String questionname = req.getParameter("questionname");
		Questionother questionother = questionallService.ToupdateQuestionother(Integer.parseInt(id));
		req.setAttribute("questionother", questionother);
		String string="";
		try {
			string= new String(questionname.getBytes("iso-8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			System.out.println("编码失败");
			e.printStackTrace();
		}
		req.setAttribute("questionname", string);
		return "issue/productsWT";
	}
	
	@RequestMapping(value="/updateQuestionother", produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public String updateQuestionother(HttpServletRequest req){
		String questionothername = req.getParameter("questionothername");
		String questionanswer = req.getParameter("questionanswer");
		String questionotherid = req.getParameter("questionotherid");
		System.out.println(questionothername+questionanswer+questionotherid);
		zhongchouResult result = questionallService.updateQuestionother(questionothername,questionanswer,Integer.parseInt(questionotherid));
		String json = "";
		try {
			json = JSON.json(result);
		} catch (IOException e) {
		
		}
		return json;
	}
	
	//到添加子问题页面
	@RequestMapping("/ToaddQuestionother")
	public String ToaddQuestionother(Model model){
		
		List<Questionall> list = questionallService.selectQuestionallAll();
		model.addAttribute("questionall", list);
		return "issue/addProductsWT2";
	}
	
	//添加子问题
	@RequestMapping(value="/addQuestionother", produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public String addQuestionother(HttpServletRequest req){
		String questionothername = req.getParameter("questionothername");
		String questionanswer = req.getParameter("questionanswer");
		String questionall = req.getParameter("questionall");
		zhongchouResult addQuestionother = questionallService.addQuestionother(questionothername,questionanswer,Integer.parseInt(questionall));
		String json = "";
		try {
			json = JSON.json(addQuestionother);
		} catch (IOException e) {
		
		}
		return json;
	}
	
	//删除父问题
	@RequestMapping(value="/DeleteQuestionother", produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public String DeleteQuestionother(HttpServletRequest req){
		String questionid = req.getParameter("questionid");
		zhongchouResult result = questionallService.deleteQuestionotherById(Integer.parseInt(questionid));
		String json = "";
		try {
			json = JSON.json(result);
		} catch (IOException e) {
		
		}
		return json;
	}
}
