package com.yh.controller.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yh.pojo.Questionall;
import com.yh.pojo.User;
import com.yh.service.user.UserMoneyService;

/**
 * 资金管理
 * @author 杨三岁
 *
 */
/**
 * 跳转到用户资金页面
 * @author 杨三岁
 *
 */
@Controller
public class UserMoneyController {
	
	@Autowired
	private UserMoneyService userMoneyService;
	
	@RequestMapping("/usermoney")
	public String usermoney(HttpServletRequest res){
		
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
		
		List<User> list = userMoneyService.selectusermoney();
		PageInfo<User> pageInfo = new PageInfo<User>(list);
		
		res.setAttribute("list", list);
		res.setAttribute("pb", pageInfo);
		
		return "usermoney";
	}
@RequestMapping("/selectusermoney")
public String selectusermoney(int usId){
	
	return "selectusermoney";
}

	
}
