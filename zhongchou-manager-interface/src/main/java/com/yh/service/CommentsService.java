package com.yh.service;

import java.util.List;

import com.yh.pojo.ClComment;

/**
 * 
 * @author Administrator
 *项目评论接口
 */
public interface CommentsService {
	/**
	 * 
	 * 项目评论 查找方法
	 * @return
	 */
	List<ClComment> selectComment();
	/**
	 * 
	 * 项目评论 查看详情方法
	 * @return
	 */
	List<ClComment> selectCommentxq(int cmPsId);
	/**
	 * 
	 * 项目评论 删除评论内容方法
	 * @return
	 */
	 boolean delcomment(int cmId);
}
