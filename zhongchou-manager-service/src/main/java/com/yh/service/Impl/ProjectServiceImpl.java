package com.yh.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yh.mapper.ProAMapper;
import com.yh.mapper.ProjectAMapper;
import com.yh.mapper.ProjectsMapper;
import com.yh.mapper.ProjectstypeMapper;
import com.yh.mapper.UserMapper;
import com.yh.pojo.Comment;
import com.yh.pojo.Condition;
import com.yh.pojo.ProA;
import com.yh.pojo.ProAExample;
import com.yh.pojo.ProjectA;
import com.yh.pojo.Projects;
import com.yh.pojo.ProjectsExample;
import com.yh.pojo.ProjectsExample.Criteria;
import com.yh.pojo.Projectstype;
import com.yh.pojo.ProjectstypeExample;
import com.yh.pojo.User;
import com.yh.pojo.UserExample;
import com.yh.pojo.zhongchouResult;
import com.yh.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService{
@Autowired
private ProjectAMapper projectAMapper;

@Autowired
private ProjectsMapper projectsMapper;
@Autowired
private UserMapper userMapper;
@Autowired
private ProAMapper proAMapper;
@Autowired
private ProjectstypeMapper projectstypeMapper;
@Override
public List<ProjectA> selectAll(){

	return projectAMapper.selectAll();
	
}
@Override
public List<ProjectA> selectByKey(Condition c) {
	return projectAMapper.selectByKey(c);
}
@Override
public User selectById(int id) {
	UserExample example = new UserExample();
	com.yh.pojo.UserExample.Criteria createCriteria = example.createCriteria();
	createCriteria.andUsIdEqualTo(id);
	List<User> list = userMapper.selectByExample(example);
	//如果没有值会报错
	
	return list.get(0);
}
@Override
public Projects findById(int id) {
	ProjectsExample example = new ProjectsExample();
	Criteria criteria = example.createCriteria();
	criteria.andPsUsIdEqualTo(id);
	List<Projects> list = projectsMapper.selectByExample(example);
	return list.get(0);
			//projectAMapper.findById(id);
}
@Override
public ProA selectByPstId(int id) {
	
	ProAExample example = new ProAExample();
	com.yh.pojo.ProAExample.Criteria createCriteria = example.createCriteria();
	createCriteria.andProAUsIdEqualTo(id);
	List<ProA> list = proAMapper.selectByExample(example);
	return list.get(0);
}
@Override
public Projectstype selectByUsId(int id) {
	
	ProjectstypeExample example = new ProjectstypeExample();
	com.yh.pojo.ProjectstypeExample.Criteria createCriteria = example.createCriteria();
	createCriteria.andPstIdEqualTo(id);
	List<Projectstype> list = projectstypeMapper.selectByExample(example);
	return list.get(0);
}
@Override
public int updateById(int id) {
	
	return projectAMapper.updateById(id);
}
@Override
public int updateByPsId(int id) {
	
	return projectAMapper.updateByPsId(id);
}
@Override
public List<Comment> selectComment(int id) {
	
	return projectAMapper.selectComment(id);
}
//查询待审核项目
@Override
public List<ProjectA> selectByKeyByPsType() {
	
	return projectAMapper.selectByKeyByPsType();
}
//根据用户id查询项目
@Override
public zhongchouResult selectByUserId(Integer usId) {
	ProjectsExample example = new ProjectsExample();
	Criteria criteria = example.createCriteria();
	criteria.andPsUsIdEqualTo(usId);
	List<Projects> list = projectsMapper.selectByExample(example);
	if(list.size()<=0){
		return zhongchouResult.build(500, "你还没有发布项目");
	}
	return zhongchouResult.ok(200, "你的发布项目",list);
}

}
