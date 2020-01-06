package com.yh.controller.user;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yh.pojo.User;
import com.yh.service.user.UserService;
import com.yh.service.user.UserManagerService;

@Controller
public class UserManageController {
	
	@Autowired
	private UserManagerService UserManagerService;
	@Autowired
	private UserService userService;
	/**
	 * 跳转管理用户页面
	 * @param <T>
	 * @param model
	 * @return
	 */
	@RequestMapping("/usermanage")
	public <T> String usermanager(HttpServletRequest req){
	/*	userService.getUser(10, 10);*/
		
	
	
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
			PageHelper.startPage(page,coun);
			List<User> list = userService.getUser();
			PageInfo<User> info = new PageInfo<>(list);
			req.setAttribute("pb", info);
			req.setAttribute("list", list);
			return "usermanage";
	}
	/**
	 * 跳转添加页面
	 */
	@RequestMapping("/Toadduser")
	public String addcontroller(){
		
		return "adduser";
	}
	
	
	
	/**
	 * 添加 用户
	 * @param user
	 * @return
	 */
	@RequestMapping("/adduser")
	public String adduser(HttpServletRequest request){

		String usEmail = request.getParameter("u_usEmail");
		String usName = request.getParameter("u_usName");
		String usPassword = request.getParameter("u_usPassword");
		String usMoney = request.getParameter("u_usMoney");
		Double money=Double.parseDouble(usMoney);
		String usIdcard = request.getParameter("u_usIdcardusIdcard");
		String usPhone = request.getParameter("u_usPhone");
		String usAddress = request.getParameter("u_usAddress");
		String usRole = request.getParameter("u_usRole");
		int r=Integer.parseInt(usRole);
		String usSex = request.getParameter("u_ussex");
		String usCode = request.getParameter("u_usCode");
		
	
		
		User user1=new User();
		user1.setUsEmail(usEmail);
		user1.setUsName(usName);
		user1.setUsPassword(usPassword);
		user1.setUsMoney(money);
		user1.setUsIdcard(usIdcard);
		user1.setUsPhone(usPhone);
		user1.setUsAddress(usAddress);
		user1.setUsRole(r);
		user1.setUsSex(usSex);
		user1.setUsCode(usCode);
		request.getAttribute("usermanage");
		
		
		
		String pkValue;
	    String str = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
	  
	    int rannum = (int) (new Random().nextDouble() * (999 - 100 + 1)) + 100;// 获取3位随机数
	    // pkValue= UUID.randomUUID().toString().replace("-","");
	    String substring = str.substring(14);
	    System.out.println(substring+"````````````````````````");
	    pkValue= substring+rannum;
	    
	    user1.setUsCode(pkValue);
	    
		userService.InsterUser(user1);
		
		return"success";
		
	}
	/**
	 * 删除用户
	 */
	@RequestMapping("/delectuser")
	public String delectuser(Integer id){
		Integer delectuser = userService.delectuser(id);
		if(delectuser!=1){
			return "error";	
		}
		return"success";
	}
	
	/**
	 * 查看用户信息
	 */
	@RequestMapping("/updatauser")
	public String selectuser(HttpServletRequest request, Integer id){
	    User selectuser = userService.selectuser(id);
	    request.setAttribute("usermanage", selectuser);
		return "updatauser";
	}
/**
	 * 跳转到修改页面
	 *//*
	@RequestMapping("/")
	public String userupdata(){
		return "updatauser";
	}*/
	

	
	
	/**
	 * 修改用户信息
	 * @param id
	 * @return
	 */
	@RequestMapping("/updatauser2")
	public String updatauser(HttpServletRequest request){
		
		String usEmail = request.getParameter("u_usEmail");
		String usName = request.getParameter("u_usName");
		String usPassword = request.getParameter("u_usPassword");
		String usMoney = request.getParameter("u_usMoney");
		Double money=Double.parseDouble(usMoney);
		String usIdcard = request.getParameter("u_usIdcardusIdcard");
		String usPhone = request.getParameter("u_usPhone");
		String usAddress = request.getParameter("u_usAddress");
		String usRole = request.getParameter("u_usRole");
		int r=Integer.parseInt(usRole);
		String usSex = request.getParameter("u_ussex");
		
	
	
		
		User user1=new User();
		user1.setUsEmail(usEmail);
		user1.setUsName(usName);
		user1.setUsPassword(usPassword);
		user1.setUsMoney(money);
		user1.setUsIdcard(usIdcard);
		user1.setUsPhone(usPhone);
		user1.setUsAddress(usAddress);
		user1.setUsRole(r);
		user1.setUsSex(usSex);
	
		Integer updatauser = userService.updatauser(user1);
		request.setAttribute("usermanage", updatauser);
		return "updatauser2";
	}
	

}
