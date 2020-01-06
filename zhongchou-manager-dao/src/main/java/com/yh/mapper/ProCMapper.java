package com.yh.mapper;

import com.yh.pojo.ProC;
import com.yh.pojo.ProCExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProCMapper {
    int countByExample(ProCExample example);

    int deleteByExample(ProCExample example);

    int deleteByPrimaryKey(Integer proCId);

    int insert(ProC record);

    int insertSelective(ProC record);

    List<ProC> selectByExample(ProCExample example);

    ProC selectByPrimaryKey(Integer proCId);

    int updateByExampleSelective(@Param("record") ProC record, @Param("example") ProCExample example);

    int updateByExample(@Param("record") ProC record, @Param("example") ProCExample example);

    int updateByPrimaryKeySelective(ProC record);

    int updateByPrimaryKey(ProC record);
}