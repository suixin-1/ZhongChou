package com.yh.mapper;

import java.util.List;

import com.yh.pojo.Projects;

public interface Selectbytypemapper {

	/**
	 * 根基公益类型状态查找
	 * @param pat_type
	 * @return
	 */
	Integer selectBytypeName(int pat_type);
	// select  ps_name  from projects where ps_pst_id=1
	
	/**
	 * 根据公益类型id查找公益类型
	 */
	List<Projects> selectByPstId(int psPstId);
}
