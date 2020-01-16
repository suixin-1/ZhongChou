package com.yh.mapper;

import com.yh.pojo.Letter;
import com.yh.pojo.LetterExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LetterMapper {
    int countByExample(LetterExample example);

    int deleteByExample(LetterExample example);

    int deleteByPrimaryKey(Integer leId);

    int insert(Letter record);

    int insertSelective(Letter record);

    List<Letter> selectByExample(LetterExample example);

    Letter selectByPrimaryKey(Integer leId);

    int updateByExampleSelective(@Param("record") Letter record, @Param("example") LetterExample example);

    int updateByExample(@Param("record") Letter record, @Param("example") LetterExample example);

    int updateByPrimaryKeySelective(Letter record);

    int updateByPrimaryKey(Letter record);
}