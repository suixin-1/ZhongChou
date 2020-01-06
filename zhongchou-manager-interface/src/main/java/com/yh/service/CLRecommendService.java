package com.yh.service;

import java.util.List;

import com.yh.pojo.CLAddrecommend;
import com.yh.pojo.CLRecommend;
/**
 * 项目推荐  接口
 * @author Administrator
 *
 */

public interface CLRecommendService {
	/**
	 * 项目推荐 查找全部
	 * @return
	 */
	List<CLRecommend> selectRecommend();
	/**
	 * 项目推荐添加  查找全部所有项目  
	 * @return
	 */
	
	List<CLAddrecommend> selectAddRecommend();
	/**
	 * 
	 * 项目推荐 删除方法
	 * @param pstId
	 * @return
	 */
	
	 int deleteByPrimaryKey(Integer pstId);
	 /**
	  * 项目推荐 添加方法  根据项目ID添加
	  * @param recommend
	  * @return
	  */
	 
	 int insert(CLRecommend recommend); 
}
