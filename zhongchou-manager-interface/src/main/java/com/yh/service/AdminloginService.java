package com.yh.service;


import com.yh.pojo.zhongchouResult;
/**
 * 查找管理员账号密码方法接口
 * @author zhangdi
 *
 */
public interface AdminloginService {
	//根据样式查询账号密码
	zhongchouResult findAdmin(String adminName,String adminPassword);
	
	//根据用户名查询
	zhongchouResult findAdmin(String adminName);
}
