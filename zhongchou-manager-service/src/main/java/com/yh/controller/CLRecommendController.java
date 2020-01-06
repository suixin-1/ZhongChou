package com.yh.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yh.pojo.CLAddrecommend;
import com.yh.pojo.CLRecommend;
import com.yh.pojo.ClComment;
import com.yh.service.CLRecommendService;
/**
 * 项目推荐 Controller
 * @author Administrator
 *
 */

@Controller
public class CLRecommendController {

	@Autowired
	private CLRecommendService CLR;
	 
	
	@RequestMapping("/recommend")
	public String selectRecommend(HttpServletRequest request){
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
		
		
		List<CLRecommend> selectRecommend = CLR.selectRecommend();
		 PageInfo<CLRecommend> pageInfo = new PageInfo<CLRecommend>(selectRecommend);
		request.setAttribute("CLRe", selectRecommend);
		request.setAttribute("pb", pageInfo);
		return "recommend";
	}
	
	
	@RequestMapping("/delRecommend")
	public String delRecommend(int r_id,HttpServletRequest request){
		int deleteByPrimaryKey = CLR.deleteByPrimaryKey(r_id);
		String selectRecommend = selectRecommend(request);
		return selectRecommend;
	}
	
	@RequestMapping("/Addrecommend")
	public String selectAddRecommend(HttpServletRequest request){
		
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
		
		List<CLAddrecommend> selectAddRecommend = CLR.selectAddRecommend();
		 PageInfo<CLAddrecommend> pageInfo = new PageInfo<CLAddrecommend>(selectAddRecommend);
		request.setAttribute("AddCLRe", selectAddRecommend);
		request.setAttribute("pb", pageInfo);
		return "Addrecommend";
	}
	
	@RequestMapping("/CLAddRecommend")
	public String AddRecommend(HttpServletRequest request){
	int ps_id =Integer.parseInt(request.getParameter("ps_id")); 
	int pst_id =Integer.parseInt( request.getParameter("pst_id"));
	CLRecommend recommend=new CLRecommend();
	recommend.setR_ps_id(ps_id);
	recommend.setR_pst_id(pst_id);;
	int insert = CLR.insert(recommend);
	
		return selectAddRecommend(request);
	}
	
}
