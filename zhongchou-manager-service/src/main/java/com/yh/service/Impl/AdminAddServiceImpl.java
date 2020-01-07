package com.yh.service.Impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yh.mapper.AdminMapper;
import com.yh.pojo.Admin;
import com.yh.service.AdminAddService;
/**
 * 添加管理员方法实现类
 * @author zhangdi
 *
 */
@Service
public class AdminAddServiceImpl implements AdminAddService {


	@Autowired
	private AdminMapper adminMapper;
	
	@Override
	public int addAdmin(Admin admin) {
		
		System.out.println(admin);
		return adminMapper.insertSelective(admin);
	
	}





	

}
