package com.yh.mapper;

import java.util.List;

import com.yh.pojo.CLAddrecommend;
import com.yh.pojo.CLRecommend;
/**
 * 
 * @author Administrator
 *项目推荐Mapper
 */
import com.yh.pojo.Projectstype;
public interface CLRecommendMapper {

	List<CLRecommend> selectRecommend();	
	List<CLAddrecommend> selectAddRecommend();//添加中的查找
	 int deleteByPrimaryKey(Integer pstId);
	 int insert(CLRecommend recommend); 
}
