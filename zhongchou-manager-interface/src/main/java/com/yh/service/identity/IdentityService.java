package com.yh.service.identity;

import java.util.List;

import com.yh.pojo.Identity;
import com.yh.pojo.IdentityExample;
import com.yh.pojo.zhongchouResult;

public interface IdentityService {
	/**
	 * 根据 用户id 查询 身份证表
	 */
	Identity selectByUsId(Integer usId);
	
	/**
	 * 插入数据 Identity
	 * @param example
	 * @return
	 */
	Integer insertIdentityAll(Identity identity);
	
	//实名审核列表
		List<Identity> selectAllIdentity();
		
		//审核不通过
		//删除
		zhongchouResult delteteIdentity(Integer usIdentityId);
		
		//根据用户ID查询实名审核信息
		Identity selectByUsId(int usId);
		
		//根据id查询审核信息
		Identity selectIdentityById(Integer usIdentityId);
		int updateUser(int usId);
		
		
		//根据用户ID删除一条信息
		int deleteIdentitys(int usId);
}
