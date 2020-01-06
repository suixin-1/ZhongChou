package com.yh.mapper;

import com.yh.pojo.ProA;
import com.yh.pojo.ProAExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProAMapper {
    int countByExample(ProAExample example);

    int deleteByExample(ProAExample example);

    int deleteByPrimaryKey(Integer proAId);

    int insert(ProA record);

    int insertSelective(ProA record);

    List<ProA> selectByExample(ProAExample example);

    ProA selectByPrimaryKey(Integer proAId);

    int updateByExampleSelective(@Param("record") ProA record, @Param("example") ProAExample example);

    int updateByExample(@Param("record") ProA record, @Param("example") ProAExample example);

    int updateByPrimaryKeySelective(ProA record);

    int updateByPrimaryKey(ProA record);
}