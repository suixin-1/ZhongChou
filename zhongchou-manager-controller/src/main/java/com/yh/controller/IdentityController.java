package com.yh.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.common.json.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yh.pojo.Identity;
import com.yh.pojo.User;
import com.yh.pojo.zhongchouResult;
import com.yh.service.LogsService;
import com.yh.service.identity.IdentityService;


/**
 * 实名审核
 * 
 * @author 陈家亮
 *
 */
@Controller
public class IdentityController {

	@Autowired
	private IdentityService identityService;

	@Autowired
	private LogsService logsService;

	// 实名审核
	@RequestMapping("/IdentityList")
	public String logsList(HttpServletRequest req) {
		// 设置分页
		String count = req.getParameter("count");
		String pages = req.getParameter("pages");
		int page = 1;
		if (pages == null) {
			pages = "1";
			page = Integer.parseInt(pages);
		} else {
			page = Integer.parseInt(pages);
		}
		int coun = 5;
		if (count == null) {
			count = "5";
			coun = Integer.parseInt(count);
		} else {
			coun = Integer.parseInt(count);
		}

		PageHelper.startPage(page, coun);

		/*
		 * String usId = req.getParameter("usId"); String usIdentityImage1 =
		 * req.getParameter("usIdentityImage1"); String usIdentityImage2 =
		 * req.getParameter("usIdentityImage2");
		 */

		/*
		 * if(logUsId!=null){ int usId = Integer.parseInt(logUsId); Logs logs =
		 * new Logs(); logs.setLogContent(logContent); logs.setLogUsId(usId);
		 * System.out.println(usId+"?111111111111111111"); List<Logs> lists =
		 * logsService.selectLogsByUid(usId); PageInfo<Logs> info = new
		 * PageInfo<>(lists); req.setAttribute("pb", info);
		 * req.setAttribute("list",lists);
		 * 
		 * }else{
		 */
		List<Identity> list = identityService.selectAllIdentity();
		PageInfo<Identity> info = new PageInfo<>(list);
		req.setAttribute("pb", info);
		req.setAttribute("list", list);

		return "IdentityList";

	}

	// 实名审核详情
	@RequestMapping("/identityDetails")
	public String IdentityDetails(HttpServletRequest request, Integer id) {
		Identity identity = identityService.selectByUsId(id);
		//System.out.println(identity+"-------------------------------------");
		User user = logsService.selectUserById(id);
		request.setAttribute("identity",identity);
		request.setAttribute("user", user);
		return "identityDetails";

	}

	// 审核通过
	@RequestMapping("/updateUser")
	public String updateById(HttpServletRequest res, int id) {
		
		identityService.updateUser(id);
		identityService.deleteIdentitys(id);
		
		return "IdentityList";

	}

	// 删除（审核不通过直接删除该数据）
	@RequestMapping(value = "/IdentityDelete", produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public String logsDelete(HttpServletRequest req) {
		String id = req.getParameter("id");
		zhongchouResult delteteIdentity = identityService.delteteIdentity(Integer.parseInt(id));
		String json = "";
		try {
			json = JSON.json(delteteIdentity);
		} catch (IOException e) {

		}
		return json;
	}

}
