package com.yh.service;

import java.util.List;

import com.yh.pojo.Projects;

public interface GyzcService {

	/**
	 * 
	 * 根据公益类型状态查找公益名字
	 */
	List<Projects> selectbypstypename(Integer psPstId);
	/**
	 * 根据公益类型id查找公益类型
	 */
	List<Projects> selectByPstId(int psPstId);
}
