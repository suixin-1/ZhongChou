package com.yh.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.common.json.JSON;
import com.yh.pojo.zhongchouResult;
import com.yh.service.AdminloginService;
/**
 * 跳转到登录功能页面
 * @author zhangdi
 *
 */
@Controller
public class AdminLoginController {
	
	@Autowired
	private AdminloginService adminloginService;
	
	@RequestMapping("/tologin")
	public String tologin(){	
		return "login";
	}
	

	
/**
 * 	登录方法
 * @return
 */
	@RequestMapping("/admin/login")
	public String login( String username,String password, Model model){	
		model.addAttribute("inpage", "inde.jsp");
		model.addAttribute("adminName", username);
		zhongchouResult findAdmin = adminloginService.findAdmin(username, password);	
		Integer status = findAdmin.getStatus();
		if(status==200){
			model.addAttribute("admin", findAdmin);
			return "index";
		}
		
		return "admin_login_error";	
	}
	
	/**
	 * 判断添加的管理员name是否相同
	 */
	@RequestMapping(value="/admin/verifyUsername", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String verifyUsername(HttpServletRequest req){
		String parameter = req.getParameter("verifyUsername");
		System.out.println(parameter);
		zhongchouResult result = adminloginService.findAdmin(parameter);
		System.out.println(result);
		try {
			String json = JSON.json(result);
			return json;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
		
	}

}
