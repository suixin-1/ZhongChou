package com.yh.mapper;

import com.yh.pojo.ProB;
import com.yh.pojo.ProBExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProBMapper {
    int countByExample(ProBExample example);

    int deleteByExample(ProBExample example);

    int deleteByPrimaryKey(Integer proBId);

    int insert(ProB record);

    int insertSelective(ProB record);

    List<ProB> selectByExample(ProBExample example);

    ProB selectByPrimaryKey(Integer proBId);

    int updateByExampleSelective(@Param("record") ProB record, @Param("example") ProBExample example);

    int updateByExample(@Param("record") ProB record, @Param("example") ProBExample example);

    int updateByPrimaryKeySelective(ProB record);

    int updateByPrimaryKey(ProB record);
}