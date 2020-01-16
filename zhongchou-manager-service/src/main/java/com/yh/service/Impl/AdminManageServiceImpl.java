package com.yh.service.Impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yh.mapper.AdminMapper;
import com.yh.pojo.Admin;
import com.yh.pojo.AdminExample;
import com.yh.service.AdminManageService;
/**
 * 管理员账号显示方法
 * @author zhangdi
 *
 */
@Service
public class AdminManageServiceImpl implements AdminManageService{

	@Autowired
	private AdminMapper adminMapper;
	
	@Override
	public List<Admin> findAllAdmin() {	
		AdminExample example2 = new AdminExample();
		List<Admin> example = adminMapper.selectByExample(example2);
		return example;	
	}

}
