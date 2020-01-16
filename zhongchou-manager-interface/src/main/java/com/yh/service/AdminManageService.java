package com.yh.service;

import java.util.List;

import com.yh.pojo.Admin;
/**
 * 查找所有管理员账号密码信息
 * @author zhangdi
 *
 */
public interface AdminManageService {
	//管理员账号查询
	List<Admin> findAllAdmin();

}
