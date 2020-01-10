package com.yh.web.controller;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
/**
 * 前端首页  controller
 * 
 */
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.common.json.JSON;
import com.yh.pojo.Projects;
import com.yh.pojo.ProjectsExample;
import com.yh.pojo.zhongchouResult;
import com.yh.pojo.ProjectsExample.Criteria;
import com.yh.pojo.CLindex.CLindexRe;
import com.yh.service.CLindex.CLindexReService;

@Controller
public class CLindexReController {
@Autowired 
private CLindexReService cLindexReService;
	
	@RequestMapping(value="/selectCLindexRe", produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public String selectCLindexRe(){
	int	r_ps_id=0;
		List<CLindexRe> selectCLindexRe = cLindexReService.selectCLindexRe(r_ps_id);
		String json="";
	try {
		 json = JSON.json(selectCLindexRe);
	} catch (IOException e) {
		e.printStackTrace();
	}
		return json;
	}
	@RequestMapping(value="/selectCLindexRejj", produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public String selectCLindexRejj(){
		Projects projects = new Projects();
		projects.setPsType(1);
	List<Projects> selectTypeExample = cLindexReService.selectTypeExample(projects);
		String json="";
	try {
		 json = JSON.json(selectTypeExample);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return json;
	}
	
	@RequestMapping(value="/selectCLindexRecg", produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public String selectCLindexRecg(){
	/*	ProjectsExample example=new ProjectsExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andPsTypeEqualTo(3);*/
		Projects projects = new Projects();
		projects.setPsType(3);
		List<Projects> selectByExample = cLindexReService.selectTypeExample(projects);
		String json="";
	try {
		 json = JSON.json(selectByExample);
	} catch (IOException e) {
		e.printStackTrace();
	}
		return json;
	}
	
	@RequestMapping("/togyzc-list")
	public String gyzclist(){
		
		return "gyzc-list";
	
	}
	@RequestMapping("/toindex")
	public String index(){
		
		return "index";
	
	}

	@RequestMapping("/toproduct-detail")
	public String productdetail(int psId,HttpServletRequest request, HttpServletResponse response){
		String psid = request.getParameter("psId");
		System.out.println("???????????????????????"+psid);
/*		
		String cookieName="psid";
		String id=psId+"";
	Cookie cookie = new Cookie(cookieName, id);
	response.addCookie(cookie);
		*/
		return "product-detail";
	}

	
	@RequestMapping(value="/toproduct-detail2", produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public String productdetail2(HttpServletRequest request){
		
		//System.out.println();
		
		/*Projects projects = new Projects();
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			if(cookie.getName().equals("psid")){
				String value = cookie.getValue();
				int id=Integer.parseInt(value);
				projects.setPsId(id);
			}
		}*/
		String string = request.getParameter("psId");
		int id = 0;
		if(string!=null || string!=""){
			id=Integer.parseInt(string);
		}
		
		Projects projects = new Projects();
		System.out.println(id+".0000000000000000000000000");
		
		projects.setPsId(id);
		List<Projects> selectByExample = cLindexReService.selectParticulars(projects);
		System.out.println(selectByExample.size()+"************************-------------------------------------");
		zhongchouResult result = zhongchouResult.ok(200, "成功", selectByExample);
		String json="";
	try {
		 json = JSON.json(result);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return json;
	}
	
	

	
	
	
	
	
	
}
