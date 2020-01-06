package com.yh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yh.pojo.CLAddrecommend;
import com.yh.pojo.CLRecommend;
/**
 * 
 * @author Administrator
 *项目推荐Mapper
 */

public interface CLRecommendMapper {

	List<CLRecommend> selectRecommend();	
	List<CLAddrecommend> selectAddRecommend();//添加中的查找
	 int deleteByPrimaryKey(Integer pstId);
	 int insert(CLRecommend recommend); 
		List<CLRecommend> selectaddRecommend(@Param("r_ps_id")int r_ps_id);
	 
}
