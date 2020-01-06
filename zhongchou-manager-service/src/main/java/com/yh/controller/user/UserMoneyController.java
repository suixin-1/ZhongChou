package com.yh.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
	@RequestMapping("/usermoney")
	public String usermoney(){
		return "usermoney";
	}
@RequestMapping("/selectusermoney")
public String selectusermoney(int usId){
	
	return "selectusermoney";
}

	
}
