package com.yh.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.common.json.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yh.pojo.ProjectA;
import com.yh.pojo.Projects;
import com.yh.pojo.Projectstype;
import com.yh.pojo.zhongchouResult;
import com.yh.service.ClassifyService;
import com.yh.service.GyzcService;
import com.yh.service.ProjectService;
import com.yh.service.SelectProjectsByPsIdService;

@Controller
public class ProjectsController {
	
	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private ClassifyService classifyService ;
	
	@Autowired
	private SelectProjectsByPsIdService SpbService;
	
	@Autowired
	private GyzcService gyzcService;
	
	
	@RequestMapping("gyzc-list")
	public String index(){
		
		return "gyzc-list";
	}
	
	//查询所有项目信息
	@RequestMapping(value="/GyzcList", produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public String GyzcList(){
		//PageHelper.startPage(page, limit);
		List<Projects> list = projectService.selectProjectsAll();
		//new PageInfo<>(list);
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
	
	/**
	 * 获取公益类型全部数据
	 * 
	 * @return
	 */
	@RequestMapping(value = "/Gyzc", produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public String Gyzc() {
		List<Projectstype> list = classifyService.selectClassify();
		zhongchouResult result = zhongchouResult.ok(200, "成功", list);
		String json = "";

		try {
			json = JSON.json(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return json;
	}
	
	//根据项目类型ID查询项目
	@RequestMapping(value = "/GyzcByPsId", produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public String GyzcByPsId(Integer id) {
		Projects list = SpbService.selectByPstId(id);
		zhongchouResult result = zhongchouResult.ok(200, "成功", list);
		String json = "";

		try {
			json = JSON.json(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return json;
	}
	
	
	/**
	 * 根据公益类型id查找公益类型名字
	 */
	@RequestMapping(value = "/GyzcTypebyid", produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public String GyzcTypebyid(HttpServletRequest request,Integer id) throws Exception {
		System.out.println(id);
	/*	List<Projects> selectByPstId = gyzcService.selectByPstId(psPstId);*/
        List<Projects> selectByPstId = gyzcService.selectByPstId(id);
		String pspstid = request.getPathTranslated();
		
		System.out.println(selectByPstId+"~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		zhongchouResult result = zhongchouResult.ok(200, "成功", selectByPstId);
		System.out.println(result+"------------------------------------------------------------------------");
		String json = "";
		try {
			json = JSON.json(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return json;

	}

}
