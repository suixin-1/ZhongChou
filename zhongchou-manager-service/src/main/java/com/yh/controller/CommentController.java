package com.yh.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yh.pojo.ClComment;
import com.yh.pojo.Projectstype;
import com.yh.service.CommentsService;
/**
 * 项目评论 Controller
 * @author Administrator
 *
 */
@Controller
public class CommentController {
	@Autowired
private CommentsService CommentsService;
	@RequestMapping("/comment")
	public String  selectComment(HttpServletRequest request){

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
		
		
		List<ClComment> selectComment = CommentsService.selectComment();
		 PageInfo<ClComment> pageInfo = new PageInfo<ClComment>(selectComment);
		request.setAttribute("comments",selectComment);
		 request.setAttribute("pb", pageInfo);
		return "comment";
	}
	@RequestMapping("/commentxq")
	public String  selectCommentxq(HttpServletRequest request){	
		int cmPsId = Integer.parseInt(request.getParameter("cmPsId"));
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
		
		
		List<ClComment> selectCommentxq = CommentsService.selectCommentxq(cmPsId);
		 PageInfo<ClComment> pageInfo = new PageInfo<ClComment>(selectCommentxq);
		request.setAttribute("commentsxq",selectCommentxq);
		 request.setAttribute("pb", pageInfo);
		 request.setAttribute("cmPsId", cmPsId);
		return "commentxq";
	
}
	@RequestMapping("/delcomment")
	public String delclassify(int cmId,HttpServletRequest request){
		boolean delClassify = CommentsService.delcomment(cmId);
		String selectComment = selectComment(request);
		return selectComment;
	}
}