package com.yh.service;

import java.util.List;

import com.yh.pojo.Projectstype;
import com.yh.pojo.ProjectstypeExample;
import com.yh.pojo.zhongchouResult;
/**
 * 
 * @author Administrator
 *项目分类接口
 */
public interface ClassifyService {


	
	/**
	 * 查询全部方法
	 * @return
	 */
	
	
public List<Projectstype> selectClassify();
/**
 * 
 * @param record
 * @return
 * 项目分类 修改方法
 */
public boolean updateClassify(Projectstype record);
/**
 * 
 * @param pstId
 * @return
 * 项目分类   根据ID删除方法
 */
public boolean delClassify(int pstId);
/**
 * 项目分类 添加方法 根据对象添加
 * @param record
 * @return
 */
public zhongchouResult addClassify(Projectstype record);
/**
 * 项目分类  查看详情方法
 * @param id
 * @return
 */
public Projectstype selectByClssietyID(int id);
}
