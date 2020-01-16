package com.yh.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yh.mapper.ProjectsMapper;
import com.yh.mapper.Selectbytypemapper;
import com.yh.pojo.Projects;
import com.yh.pojo.ProjectsExample;
import com.yh.pojo.ProjectsExample.Criteria;
import com.yh.service.GyzcService;

@Service
public class GyzcServiceImpl implements GyzcService {
	@Autowired
	private ProjectsMapper projectsMapper;
	@Autowired
	private Selectbytypemapper selectbytypedao;

	/**
	 * 根据公益类型状态查找公益名字
	 */
	@Override
	public List<Projects> selectbypstypename(Integer psPstId) {
		Projects selectByPrimaryKey = projectsMapper
				.selectByPrimaryKey(psPstId);
		return (List<Projects>) selectByPrimaryKey;
	}

	@Override
	public List<Projects> selectByPstId(int psPstId) {
		ProjectsExample example = new ProjectsExample();
		Criteria criteria = example.createCriteria();
		criteria.andPsPstIdEqualTo(psPstId);
		List<Projects> selectByPstId = projectsMapper.selectByExample(example);

		System.out.println(selectByPstId+ "````````````````````````````````````````````");
		return selectByPstId;
	}

}
