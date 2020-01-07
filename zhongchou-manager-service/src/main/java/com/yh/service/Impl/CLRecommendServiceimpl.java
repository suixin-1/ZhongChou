package com.yh.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yh.mapper.CLRecommendMapper;
import com.yh.pojo.CLAddrecommend;
import com.yh.pojo.CLRecommend;
import com.yh.pojo.Projectstype;
import com.yh.pojo.ProjectstypeExample;
import com.yh.pojo.zhongchouResult;
import com.yh.pojo.ProjectstypeExample.Criteria;
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
	public zhongchouResult insert(CLRecommend recommend) {
		int r_ps_id = recommend.getR_ps_id();
		List<CLRecommend> selectaddRecommend = cLRecommendMapper.selectaddRecommend(r_ps_id);
		if(selectaddRecommend.isEmpty()){
			int i = cLRecommendMapper.insert(recommend);
			if(i>0){
				return zhongchouResult.build(200, "添加分类成功");
			}
			return zhongchouResult.build(500, "添加分类失败");		
		}
		return zhongchouResult.build(500, "添加分类失败,name已有");
}
}