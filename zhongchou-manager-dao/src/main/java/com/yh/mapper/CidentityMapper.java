package com.yh.mapper;

import com.yh.pojo.Identity;
/**
 * 实名审核拓展接口
 * @author 陈家亮
 *
 */
public interface CidentityMapper {
	
	//根据用户ID修改用户状态
	int updateUser(int usId);
	
	//根据用户ID查询实名信息
	Identity selectByUsId(int usId);
	
	//根据用户ID删除一条信息
	int deleteIdentity(int usId);

}
