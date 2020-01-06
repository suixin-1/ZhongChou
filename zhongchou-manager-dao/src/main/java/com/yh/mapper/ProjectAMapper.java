package com.yh.mapper;

import java.util.List;

import com.yh.pojo.Comment;
import com.yh.pojo.Condition;
import com.yh.pojo.ProA;
import com.yh.pojo.ProjectA;
import com.yh.pojo.Projects;
import com.yh.pojo.Projectstype;
import com.yh.pojo.User;

public interface ProjectAMapper {
    List<ProjectA> selectAll();

    List<ProjectA> selectByKey(Condition c);
	
		int updateById(int id);
		int updateByPsId(int id);
		List<Comment> selectComment(int id);
}
