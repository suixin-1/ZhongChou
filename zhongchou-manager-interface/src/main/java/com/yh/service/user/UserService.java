package com.yh.service.user;

import java.util.List;

import com.yh.pojo.User;
import com.yh.pojo.zhongchouResult;

/**
 * 用户
 * @author 杨三岁
 *
 */


public interface UserService {
	/**
	 * 分页展示用户列表数据
	 * @author 杨三岁
	 *
	 */
	
	List<User> getUser();
	
		

	/**
	 * 添加用户
	 * @param user
	 * @return
	 */
	Integer InsterUser(User user);

	/**
	 * 删除用户信息
	 */
	Integer delectuser(Integer usId);
	
	/**
	 * 查看用户信息
	 */
	User selectuser(Integer usId);
	
	/**
	 * 修改用户信息
	 */
	Integer updatauser(User user);



	
	/**
	 * 根据用户名和密码查询
	 */
	zhongchouResult selectUserByNameAndPwd(String username,String password);

}
