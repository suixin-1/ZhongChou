package com.yh.service.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yh.mapper.UserMapper;
import com.yh.pojo.User;
import com.yh.pojo.UserExample;
import com.yh.service.user.UserMoneyService;

@Service
public class UserMoneyServiceImpl implements UserMoneyService {

	@Autowired
	private UserMapper usermapper;
/**
 * 查看用户资金
 */
	public User selectusermoney(int usId) {
		UserExample example = new UserExample();
		System.out.println(example);
		User selectByPrimaryKey = usermapper.selectByPrimaryKey(usId);
		System.out.println(selectByPrimaryKey);
		return selectByPrimaryKey;
	}

}
