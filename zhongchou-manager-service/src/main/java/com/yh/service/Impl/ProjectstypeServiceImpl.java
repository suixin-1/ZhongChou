package com.yh.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yh.mapper.ProjectstypeMapper;
import com.yh.pojo.Projectstype;
import com.yh.pojo.ProjectstypeExample;
import com.yh.pojo.ProjectstypeExample.Criteria;
import com.yh.service.ProjectstypeService;
@Service
public class ProjectstypeServiceImpl implements ProjectstypeService{
	
	@Autowired
	private ProjectstypeMapper projectstypeMapper;
	
	@Override
	public List<Projectstype> selectProjectstypeAll() {
		ProjectstypeExample example = new ProjectstypeExample();
		Criteria criteria = example.createCriteria();
		criteria.andPstTypeEqualTo(0);
		return projectstypeMapper.selectByExample(example);
	}
	
}
