package com.yh.service.user;

import com.yh.pojo.User;

/**
 * 用户资金
 * @author 杨三岁
 *
 */
public interface UserMoneyService {
/**
 * 查看用户资金
 * @param usId
 * @return
 */
	User selectusermoney(int usId);
	
}
