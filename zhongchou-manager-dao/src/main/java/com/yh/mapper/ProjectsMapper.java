package com.yh.mapper;

import com.yh.pojo.Comment;
import com.yh.pojo.Projects;
import com.yh.pojo.ProjectsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProjectsMapper {
    int countByExample(ProjectsExample example);

    int deleteByExample(ProjectsExample example);

    int deleteByPrimaryKey(Integer psId);

    int insert(Projects record);

    int insertSelective(Projects record);

    List<Projects> selectByExample(ProjectsExample example);

    Projects selectByPrimaryKey(Integer psId);

    int updateByExampleSelective(@Param("record") Projects record, @Param("example") ProjectsExample example);

    int updateByExample(@Param("record") Projects record, @Param("example") ProjectsExample example);

    int updateByPrimaryKeySelective(Projects record);

    int updateByPrimaryKey(Projects record);
    
    //老吴添加
    List<Comment> selectComment(int id);
}