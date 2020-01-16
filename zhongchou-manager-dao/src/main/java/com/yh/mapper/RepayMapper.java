package com.yh.mapper;

import com.yh.pojo.Repay;
import com.yh.pojo.RepayExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RepayMapper {
    int countByExample(RepayExample example);

    int deleteByExample(RepayExample example);

    int deleteByPrimaryKey(Integer ryId);

    int insert(Repay record);

    int insertSelective(Repay record);

    List<Repay> selectByExample(RepayExample example);

    Repay selectByPrimaryKey(Integer ryId);

    int updateByExampleSelective(@Param("record") Repay record, @Param("example") RepayExample example);

    int updateByExample(@Param("record") Repay record, @Param("example") RepayExample example);

    int updateByPrimaryKeySelective(Repay record);

    int updateByPrimaryKey(Repay record);
}