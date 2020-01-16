package com.yh.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.common.json.JSON;
import com.yh.mapper.AdminMapper;
import com.yh.mapper.JurisdictionMapper;
import com.yh.pojo.Admin;
import com.yh.pojo.Jurisdiction;
import com.yh.pojo.JurisdictionExample;
import com.yh.pojo.JurisdictionExample.Criteria;
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
	
	@Autowired
	private JurisdictionMapper jurisdictionMapper;
	
	@Autowired
	private AdminMapper adminMapper;
	
	
	@RequestMapping("/tologin")
	public String tologin(){	
		return "login";
	}
	
	/**
	 * 退出
	 */
	@RequestMapping("/login")
	public String login(){
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
			model.addAttribute("inpage", "inde.jsp");
			
			Admin ad = (Admin) findAdmin.getData();
			Integer adminId = ad.getAdminId();
			
			JurisdictionExample example = new JurisdictionExample();
			Criteria criteria = example.createCriteria();
			criteria.andJuAdIdEqualTo(adminId);
			List<Jurisdiction> list = jurisdictionMapper.selectByExample(example);	
			if(list.size()>0){
				model.addAttribute("left",list.get(0).getJuName());
				return "index";
			}
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
	
	/**
	 * 跳转到管理员账号修改界面
	 * @author zhangdi
	 *
	 */
	@RequestMapping("/admin/setting_admin")
	public String toupdateAdmin(HttpServletRequest req){

		return "setting_admin";
	}
	/**
	 * 管理员原密码验证
	 * @author zhangdi
	 *
	 */
	@RequestMapping(value="/verify_admin", produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public String verifyAdmin(HttpServletRequest req){
		String username = req.getParameter("username");
		String pwd = req.getParameter("password");
		zhongchouResult findAdmin = adminloginService.findAdmin(username, pwd);	
		if(findAdmin.getStatus()==200){
			findAdmin.setMsg("密码正确");
		}else{
			findAdmin.setMsg("密码输入不正确");
		}
		String json = "";
		try {
			json = JSON.json(findAdmin);
		} catch (IOException e) {
		
		}
		return json;

	}
	
	
	/**
	 * 管理员密码修改
	 * @author zhangdi
	 *
	 */
	@RequestMapping(value="/setting_admin", produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public String updateAdmin(HttpServletRequest req){
		String uname = req.getParameter("username");
		String pwd = req.getParameter("password");
		System.out.println(uname);
		System.out.println(pwd);
		zhongchouResult result = adminloginService.updateAdminPwdbyNameandPwd(uname, pwd);
		if(result.getStatus()==200){
			result.setMsg("密码修改成功！");
		}else{
			result.setMsg("密码修改失败！");
		}
		String json = "";
		try {
			json = JSON.json(result);
		} catch (IOException e) {
		
		}
		return json;
	}
	
	
	
	/**
	 * 授权
	 */
	@RequestMapping("/toadminJurisdiction")
	public String adminJurisdictions(HttpServletRequest req){
		String adminid = req.getParameter("adminid");
		Admin admin = adminMapper.selectByPrimaryKey(Integer.parseInt(adminid));
		req.setAttribute("admin_ju_name", admin);
		return "adminJurisdiction";
	}
	
	/**
	 * 执行授权
	 */
	@RequestMapping(value="/adminJurisdiction", produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public String adminJurisdiction(HttpServletRequest req){
		String adminid = req.getParameter("adminId");
		String quanxian = req.getParameter("quanxian");
		System.out.println(adminid+quanxian);
		
		Jurisdiction jurisdiction = new Jurisdiction();
		jurisdiction.setJuAdId(Integer.parseInt(adminid));
		
		
		if(quanxian.equals("admin")){
			jurisdiction.setJuName("left.jsp");
		}else if(quanxian.equals("user")){
			jurisdiction.setJuName("leftUser.jsp");
		}
		
		int i = jurisdictionMapper.insert(jurisdiction);
		zhongchouResult result = null;
		if(i>0){
			result = zhongchouResult.ok(200, "授权成功");
		}else{
			result = zhongchouResult.ok(500, "授权失败");
		}
		String json = "";
		try {
			json = JSON.json(result);
		} catch (IOException e) {
		
		}
		return json;
	}
}