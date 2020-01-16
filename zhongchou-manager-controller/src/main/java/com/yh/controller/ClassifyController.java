package com.yh.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.common.json.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mysql.fabric.xmlrpc.base.Data;
import com.yh.pojo.Projectstype;
import com.yh.pojo.ProjectstypeExample;
import com.yh.pojo.zhongchouResult;
import com.yh.pojo.ProjectstypeExample.Criteria;
import com.yh.service.ClassifyService;

/**
 * 
 * @author Administrator
 *    项目分类
 */
@Controller
public class ClassifyController {
	@Autowired
	private ClassifyService ClassifyServiceImpl;
	
	@RequestMapping("/save")
	public String saveclassify(HttpServletRequest request,String p_id,String p_name,HttpServletRequest req){
		int pstId=Integer.parseInt(request.getParameter("p_id"));	
		String parameter = req.getParameter("p_name");
	
		String pstDesc = request.getParameter("p_des");
		String pstType2 = request.getParameter("p_status");
		/*if(pstType2.equals("可用")){
			pstType2="0";
		}else {
			pstType2="1";
		}*/
		int pstType=Integer.parseInt(pstType2);
		Projectstype record=new Projectstype();
		record.setPstId(pstId);
		record.setPstDesc(pstDesc);
		record.setPstType(pstType);
		boolean updateClassify = ClassifyServiceImpl.updateClassify(record);

		String classify = classify(request);
		return classify;
	}
	@RequestMapping("/classify")
	public String classify(HttpServletRequest request){
		

		String count = request.getParameter("count");
		String pages = request.getParameter("pages");
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
		

		List<Projectstype> selectClassify = ClassifyServiceImpl.selectClassify();
		 PageInfo<Projectstype> pageInfo = new PageInfo<Projectstype>(selectClassify);
		request.setAttribute("Projectstype", selectClassify);
		 request.setAttribute("pb", pageInfo);
		return "all_classity";
	}
	@RequestMapping("/delbyId")
	public String delclassify(int pstId,HttpServletRequest request){
		boolean delClassify = ClassifyServiceImpl.delClassify(pstId);
		
		String classify = classify(request);
		return classify;
	}
	
	@RequestMapping("/motaikuang")
	public String motaikuang(HttpServletRequest request){
		String parameter = request.getParameter("id");
		int id = Integer.parseInt(parameter);
		Projectstype projectstype = ClassifyServiceImpl.selectByClssietyID(id);
		request.setAttribute("projectstype", projectstype);
		return "motaikuang";
	}
	
	@RequestMapping("add_classity")
	public String addgoto(){
		return "add_classity";
	}
	
	@RequestMapping(value="/add", produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public String addclassify(HttpServletRequest request,Projectstype record){
			System.out.println("--------------");
			Date d=new Date();
			record.setPstStardate(d);
			record.setPstType(0);
			try {
				request.setCharacterEncoding("UTF-8");
				
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			zhongchouResult addQuestionall = ClassifyServiceImpl.addClassify(record);
			String json = "";
			try {
				json = JSON.json(addQuestionall);
			} catch (IOException e) {
			
			}
			return json;

		}
}
