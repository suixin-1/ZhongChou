package com.yh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yh.mapper.AdminMapper;
import com.yh.pojo.Admin;
import com.yh.pojo.AdminExample;
import com.yh.pojo.AdminExample.Criteria;
import com.yh.pojo.zhongchouResult;
import com.yh.service.AdminloginService;
/**
 * 登录方法实现类
 * @author zhangdi
 *
 */
@Service
public class AdminLoginServiceImpl implements AdminloginService {

	@Autowired
	private AdminMapper adminMapper;
	
	@Override
	public zhongchouResult findAdmin(String u_adminName, String u_adminPassword) {
		AdminExample example = new AdminExample();
		Criteria criteria = example.createCriteria();
		criteria.andAdminNameEqualTo(u_adminName);
		criteria.andAdminPasswordEqualTo(u_adminPassword);
		List<Admin> list = adminMapper.selectByExample(example);
		if(list.isEmpty()){
			return zhongchouResult.build(500, "账号密码输入有误");
		}

		return zhongchouResult.ok(200, list.get(0));
	}

	@Override
	public zhongchouResult findAdmin(String adminName) {
		//
		AdminExample example = new AdminExample();
		Criteria criteria = example.createCriteria();
		criteria.andAdminNameEqualTo(adminName);
		List<Admin> list = adminMapper.selectByExample(example);
		if(list.isEmpty()){
			return zhongchouResult.build(200, "用户名可以用");
		}

		return zhongchouResult.build(500,"用户名不可用！");
	}



}
