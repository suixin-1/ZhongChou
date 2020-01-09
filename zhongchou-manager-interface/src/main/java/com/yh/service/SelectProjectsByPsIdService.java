package com.yh.service;

import com.yh.pojo.Projects;

public interface SelectProjectsByPsIdService {
	
	//根据公益类型ID查询项目
	Projects selectByPstId(Integer psPstId);

}
