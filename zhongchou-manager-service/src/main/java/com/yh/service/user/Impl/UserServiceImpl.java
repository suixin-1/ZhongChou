package com.yh.service.user.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yh.mapper.UserMapper;
import com.yh.pojo.User;
import com.yh.pojo.UserExample;
import com.yh.pojo.UserExample.Criteria;
import com.yh.pojo.zhongchouResult;
import com.yh.service.user.UserService;

import qiniu.happydns.Record;

@Service
public class UserServiceImpl implements UserService {
	/**
	 * 添加用户
	 */

	@Autowired
	private UserMapper usermapper;
	

	@Override
	public Integer InsterUser(User user) {
	    int insert = usermapper.insert(user);
		return insert;
	}

	/**
	 * 获取用户列表信息
	 */
	@Override
	public List<User> getUser() {
		// 执行查询
		UserExample example = new UserExample();
		List<User> selectByExample = usermapper.selectByExample(example);
		
		return selectByExample;
	}

	
	/**
	 * 
	 * 查看用户信息
	 */
	@Override
	public User selectuser(Integer usId) {
		
		 User selectByPrimaryKey = usermapper.selectByPrimaryKey(usId);
		 
		
		return selectByPrimaryKey;
	}

	/*
	 * 修改用户信息
	 */
	@Override
	public Integer updatauser(User user) {
		//修改方法需要改
		//UserExample example = new UserExample();
		//Criteria criteria = example.createCriteria();
		//criteria.andUsIdEqualTo(user.getUsId());
		//int updateByPrimaryKeySelective = usermapper.updateByExampleSelective(user, example);
		//int updateByPrimaryKeySelective = usermapper.updateByPrimaryKey(user);
	/*	UserExample example = new UserExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andUsIdcardEqualTo(usId+"");*/
		//int updateByExample = usermapper.updateByExample(user,example);
		
		int byPrimaryKeySelective = usermapper.updateByPrimaryKeySelective(user);
		return byPrimaryKeySelective;
	}
	
	//根据用户名和密码查询
	@Override
	public zhongchouResult selectUserByNameAndPwd(String username,String password) {
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUsEmailEqualTo(username);
		criteria.andUsPasswordEqualTo(password);
		List<User> list = usermapper.selectByExample(example);
		if(list.isEmpty()){
			return zhongchouResult.ok(500, "登录失败", list);
		}
		return zhongchouResult.ok(200, "登录成功", list);
	}
	
	//根据邮箱查询密码
	@Override
	public zhongchouResult selectUserByEmail(String usEmail) {
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUsEmailEqualTo(usEmail);
		List<User> list = usermapper.selectByExample(example);
		if(list.isEmpty()){
			return zhongchouResult.build(500, "没有此账号");
		}	
		return zhongchouResult.ok(200, "查询成功", list.get(0));
	}




}
