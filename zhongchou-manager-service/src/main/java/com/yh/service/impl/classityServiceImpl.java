package com.yh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yh.mapper.ProjectstypeMapper;
import com.yh.pojo.Projectstype;
import com.yh.pojo.ProjectstypeExample;
import com.yh.pojo.zhongchouResult;
import com.yh.pojo.ProjectstypeExample.Criteria;
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
	public zhongchouResult addClassify(Projectstype record) {
		String pstName = record.getPstName();
		ProjectstypeExample example = new ProjectstypeExample();
        Criteria createCriteria = example.createCriteria();
		createCriteria.andPstDescEqualTo(pstName);
		List<Projectstype> selectByExample = projectstypeMapper.selectByExample(example);
		if(selectByExample.isEmpty()){
			int i = projectstypeMapper.insert(record);
			if(i>0){
				return zhongchouResult.build(200, "添加分类成功");
			}
			return zhongchouResult.build(500, "添加分类失败");		
		}
		return zhongchouResult.build(500, "添加分类失败,name已有");
	}
	@Override
	public Projectstype selectByClssietyID(int id) {
		return projectstypeMapper.selectByPrimaryKey(id);
	}


}