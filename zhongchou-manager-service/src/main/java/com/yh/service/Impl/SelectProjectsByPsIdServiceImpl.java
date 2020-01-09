package com.yh.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yh.mapper.SelectProjectsByPsIdMapper;
import com.yh.pojo.Projects;
import com.yh.service.SelectProjectsByPsIdService;

/**
 * 根据公益类型ID查询项目
 * @author 陈家亮
 *
 */


@Service
public class SelectProjectsByPsIdServiceImpl implements SelectProjectsByPsIdService {

	@Autowired
	private SelectProjectsByPsIdMapper SpbMapper;

	@Override
	public Projects selectByPstId(Integer psPstId) {
		Projects selectByPstId = SpbMapper.selectByPstId(psPstId);
		return selectByPstId;

	}

}
