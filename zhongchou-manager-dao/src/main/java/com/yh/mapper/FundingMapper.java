package com.yh.mapper;

import com.yh.pojo.Funding;
import com.yh.pojo.FundingExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FundingMapper {
    int countByExample(FundingExample example);

    int deleteByExample(FundingExample example);

    int deleteByPrimaryKey(Integer fdId);

    int insert(Funding record);

    int insertSelective(Funding record);

    List<Funding> selectByExample(FundingExample example);

    Funding selectByPrimaryKey(Integer fdId);

    int updateByExampleSelective(@Param("record") Funding record, @Param("example") FundingExample example);

    int updateByExample(@Param("record") Funding record, @Param("example") FundingExample example);

    int updateByPrimaryKeySelective(Funding record);

    int updateByPrimaryKey(Funding record);
}