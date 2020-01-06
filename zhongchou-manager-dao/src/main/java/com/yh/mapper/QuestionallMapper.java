package com.yh.mapper;

import com.yh.pojo.Questionall;
import com.yh.pojo.QuestionallExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface QuestionallMapper {
    int countByExample(QuestionallExample example);

    int deleteByExample(QuestionallExample example);

    int deleteByPrimaryKey(Integer questionid);

    int insert(Questionall record);

    int insertSelective(Questionall record);

    List<Questionall> selectByExample(QuestionallExample example);

    Questionall selectByPrimaryKey(Integer questionid);

    int updateByExampleSelective(@Param("record") Questionall record, @Param("example") QuestionallExample example);

    int updateByExample(@Param("record") Questionall record, @Param("example") QuestionallExample example);

    int updateByPrimaryKeySelective(Questionall record);

    int updateByPrimaryKey(Questionall record);
}