package com.yh.mapper;

import com.yh.pojo.Questionother;
import com.yh.pojo.QuestionotherExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface QuestionotherMapper {
    int countByExample(QuestionotherExample example);

    int deleteByExample(QuestionotherExample example);

    int deleteByPrimaryKey(Integer questionotherid);

    int insert(Questionother record);

    int insertSelective(Questionother record);

    List<Questionother> selectByExample(QuestionotherExample example);

    Questionother selectByPrimaryKey(Integer questionotherid);

    int updateByExampleSelective(@Param("record") Questionother record, @Param("example") QuestionotherExample example);

    int updateByExample(@Param("record") Questionother record, @Param("example") QuestionotherExample example);

    int updateByPrimaryKeySelective(Questionother record);

    int updateByPrimaryKey(Questionother record);
}