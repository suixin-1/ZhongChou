package com.yh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yh.mapper.ProjectstypeMapper;
import com.yh.pojo.Projectstype;
import com.yh.pojo.ProjectstypeExample;
import com.yh.service.ClassifyService;

@Service
public class classityServiceImpl implements ClassifyService{
	
	@Autowired
	private ProjectstypeMapper projectstypeMapper;
	
	@Override
	public List<Projectstype> selectClassify() {
		ProjectstypeExample example=new ProjectstypeExample();
		List<Projectstype> selectByExample = projectstypeMapper.selectByExample(example);
		return selectByExample;
	}
	@Override
	public boolean updateClassify(Projectstype record) {
		int updateByPrimaryKeySelective = projectstypeMapper.updateByPrimaryKeySelective(record);
		if(updateByPrimaryKeySelective==0){
			return false;
		}
		return true;
	}
	@Override
	public boolean delClassify(int pstId) {
		//deleteByPrimaryKey
		int deleteByPrimaryKey = projectstypeMapper.deleteByPrimaryKey(pstId);
		
		if(deleteByPrimaryKey==0){
			return false;
		}
		return true;
	}
	@Override
	public boolean addClassify(Projectstype record) {
		int insert = projectstypeMapper.insert(record);
		if(insert==0){
			return false;
		}
		return true;
	}
	@Override
	public Projectstype selectByClssietyID(int id) {
		return projectstypeMapper.selectByPrimaryKey(id);
	}

}
