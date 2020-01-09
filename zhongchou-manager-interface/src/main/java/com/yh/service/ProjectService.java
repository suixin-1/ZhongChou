package com.yh.service;

import java.util.List;

import com.yh.pojo.Comment;
import com.yh.pojo.Condition;
import com.yh.pojo.ProA;
import com.yh.pojo.ProjectA;
import com.yh.pojo.Projects;
import com.yh.pojo.Projectstype;
import com.yh.pojo.User;

public interface ProjectService {
	List<ProjectA> selectAll();
	List<ProjectA> selectByKey(Condition c);
	List<Projects> selectProjectsAll();
	User selectById(int id);
	Projects findById(int id);
	ProA selectByPstId(int id);
	Projectstype selectByUsId( int id);
	int updateById(int id);
	int updateByPsId(int id);
	List<Comment> selectComment(int id);
}
