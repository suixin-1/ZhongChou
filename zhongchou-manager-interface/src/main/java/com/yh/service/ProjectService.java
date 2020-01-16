package com.yh.service;

import java.util.List;

import com.yh.pojo.Comment;
import com.yh.pojo.Condition;
import com.yh.pojo.ProA;
import com.yh.pojo.ProjectA;
import com.yh.pojo.Projects;
import com.yh.pojo.Projectstype;
import com.yh.pojo.Repay;
import com.yh.pojo.User;
import com.yh.pojo.zhongchouResult;

public interface ProjectService {
	
	List<ProjectA> selectAll();
	List<Projects> selectProjectsAll();
	List<ProjectA> selectByKey(Condition c);
	User selectById(int id);
	Projects findById(int id);
	ProA selectByPstId(int id);
	Projectstype selectByUsId( int id);
	int updateById(int id);
	int updateByPsId(int id);
	List<Comment> selectComment(int id);
	//查询待审核项目
	List<ProjectA> selectByKeyByPsType();
	
	/**
	 * 根据用户id查询项目
	 */
	zhongchouResult selectByUserId(Integer usId);
	/**
	 * 插入项目信息
	 * @param projects
	 * @return 返回插入的主键
	 */
	Integer insertProjects(Projects projects);
	/**
	 * 插入项目回报表
	 * @param repay
	 * @return
	 */
	Integer insertRepay(Repay repay);
}
