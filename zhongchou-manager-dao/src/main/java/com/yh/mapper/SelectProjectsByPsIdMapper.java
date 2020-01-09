package com.yh.mapper;

import com.yh.pojo.Projects;

public interface SelectProjectsByPsIdMapper {

	//根据公益类型ID查询项目
	Projects selectByPstId(Integer psPstId);
}
