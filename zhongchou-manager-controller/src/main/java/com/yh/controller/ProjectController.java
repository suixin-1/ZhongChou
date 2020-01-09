package com.yh.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yh.pojo.Comment;
import com.yh.pojo.Condition;
import com.yh.pojo.ProA;
import com.yh.pojo.ProjectA;
import com.yh.pojo.Projects;
import com.yh.pojo.Projectstype;
import com.yh.pojo.User;
import com.yh.service.ProjectService;

@Controller
public class ProjectController {
	@Autowired
	private ProjectService projectServiceImpl;
	@RequestMapping("/selectAll")
	public String selectAll(HttpServletRequest res){
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
		String pstName = res.getParameter("pstName");
		String psName = res.getParameter("psName");
		String psTyp = res.getParameter("psType");
		String usName = res.getParameter("usName");
		Condition c =new Condition();
		c.setPstName(pstName);	
		c.setPsName(psName);
		c.setUsName(usName);
		int psType=0;	
		if(pstName!=null || psName!=null ||usName !=null || psTyp!=null){
			if(psTyp.equals("项目状态")){
				psType=99;
				c.setPsType(99);
			}else if(psTyp.equals("众筹中")){
				psType=2;
				c.setPsType(2);
			}else if(psTyp.equals("众筹失败")){
				psType=4;
				c.setPsType(4);
			}else if(psTyp.equals("众筹成功")){
				psType=3;
				c.setPsType(3);
			}else if(psTyp.equals("待审核")){
				psType=0;
				c.setPsType(0);
				}else if(psTyp.equals("待上架")){
					psType=1;
					c.setPsType(1);
					}else if(psTyp.equals("审核未通过")){
						psType=5;
						c.setPsType(5);
						}
			List<ProjectA> p= projectServiceImpl.selectByKey(c);
			PageInfo<ProjectA> pageInfo = new PageInfo<ProjectA>(p);
			res.setAttribute("pb", pageInfo);
			res.setAttribute("list", p);
		}else{
			
			List<ProjectA> selectAll = projectServiceImpl.selectAll();
			PageInfo<ProjectA> pageInfo = new PageInfo<ProjectA>(selectAll);
			res.setAttribute("pb", pageInfo);
			res.setAttribute("list", selectAll);
		}
		
		return "products";
		
	}
	
	
	@RequestMapping("/selectById")
	public String selectById(HttpServletRequest res){
		String ids  = res.getParameter("id");
		int id=Integer.parseInt(ids);
		
		Projects findById = projectServiceImpl.findById(id);
		
		User selectById = projectServiceImpl.selectById(id);
		
		ProA selectByPstId = projectServiceImpl.selectByPstId(id);
		
		Integer psPstId = findById.getPsPstId();
		Projectstype selectByUsId = projectServiceImpl.selectByUsId(psPstId);
		
		res.setAttribute("fbd", findById);
		res.setAttribute("sbd", selectById);
		res.setAttribute("sbpd", selectByPstId);
		res.setAttribute("sbud", selectByUsId);
		
		return "product-info1";	
	}
	@RequestMapping("/selectType")
	public String selectType(HttpServletRequest res){
		
		System.out.println("ssssssssssssssss");
		
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
		List<ProjectA> selectAll = projectServiceImpl.selectAll();
		//List<ProjectA>  sd = new ArrayList<>();
		/*for (ProjectA projectA : selectAll) {
			if(projectA.getPsType().equals("0")){
				projectA.setPsType("审核中");
				System.out.println("cccc"+projectA);
				sd.add(projectA);
			}
		}*/
		System.out.println("nnnnnnnnnn"+selectAll);
		PageInfo<ProjectA> pageInfo = new PageInfo<ProjectA>(selectAll);
		res.setAttribute("pb", pageInfo);
		res.setAttribute("list", selectAll);
		
		System.out.println("sssssssssss"+selectAll);
		
		return "audit_status";
		
	}
	@RequestMapping("/updateById")
	public String  updateById(HttpServletRequest res){
		String ids  = res.getParameter("id");
		int id=Integer.parseInt(ids);
		int updateById = projectServiceImpl.updateById(id);
		List<ProjectA> selectAll = projectServiceImpl.selectAll();
		List<ProjectA>  sd = new ArrayList<>();
		for (ProjectA projectA : selectAll) {
			if(projectA.getPsType().equals("0")){
				projectA.setPsType("审核中");
				sd.add(projectA);
			}
		}
		res.setAttribute("list", sd);
		return "audit_status";
		
	}
	@RequestMapping("/updateByPsId")
	public String  updateByPsId(HttpServletRequest res){
		String ids  = res.getParameter("id");
		int id=Integer.parseInt(ids);
		int updateById = projectServiceImpl.updateByPsId(id);
		List<ProjectA> selectAll = projectServiceImpl.selectAll();
		List<ProjectA>  sd = new ArrayList<>();
		for (ProjectA projectA : selectAll) {
			if(projectA.getPsType().equals("0")){
				projectA.setPsType("审核中");
				sd.add(projectA);
			}
		}
		res.setAttribute("list", sd);
		return "audit_status";
		
	}
	@RequestMapping("/selectSchedule")
	
	public String selectSchedule(HttpServletRequest res){
		String ids  = res.getParameter("id");
		int id=Integer.parseInt(ids);
		
		Projects findById = projectServiceImpl.findById(id);
					
			res.setAttribute("fbd",findById );

		return "project-schedule";
		
	}
@RequestMapping("/selectMessage")
	
	public String selectMessage(HttpServletRequest res){
	String ids  = res.getParameter("id");
	int id=Integer.parseInt(ids);
	
	Projects findById = projectServiceImpl.findById(id);
	
	User selectById = projectServiceImpl.selectById(id);
	
	ProA selectByPstId = projectServiceImpl.selectByPstId(id);
	
	Integer psPstId = findById.getPsPstId();
	Projectstype selectByUsId = projectServiceImpl.selectByUsId(psPstId);
	
	res.setAttribute("fbd", findById);
	res.setAttribute("sbd", selectById);
	res.setAttribute("sbpd", selectByPstId);
	res.setAttribute("sbud", selectByUsId);
	
	return "project-message";	
}
@RequestMapping("/selectComment")

public String selectComment(HttpServletRequest res){
	
	String ids  = res.getParameter("id");
	int id=Integer.parseInt(ids);
	Projects findById = projectServiceImpl.findById(id);
	List<Comment> c=projectServiceImpl.selectComment(id);
	
	
	res.setAttribute("list", c);
	res.setAttribute("fbd",findById );

return "project-comment";	
}

}

