package com.yh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yh.mapper.CLRecommendMapper;
import com.yh.pojo.CLAddrecommend;
import com.yh.pojo.CLRecommend;
import com.yh.service.CLRecommendService;
/**
 * 
 * @author Administrator
 *项目推荐表实现
 */
@Service
public class CLRecommendServiceimpl implements CLRecommendService{
	@Autowired
	private CLRecommendMapper cLRecommendMapper;
	@Override
	public List<CLRecommend> selectRecommend() {
		
		return cLRecommendMapper.selectRecommend();
	}
	@Override
	public int deleteByPrimaryKey(Integer pstId) {
		int deleteByPrimaryKey = cLRecommendMapper.deleteByPrimaryKey(pstId);
		return deleteByPrimaryKey;
	}
	@Override
	public List<CLAddrecommend> selectAddRecommend() {
	
		return  cLRecommendMapper.selectAddRecommend();
	}
	@Override
	public int insert(CLRecommend recommend) {
		int insert = cLRecommendMapper.insert(recommend);
		return insert;
	}

	

}
