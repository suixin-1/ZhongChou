package com.yh.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yh.mapper.ClCommentMapper;
import com.yh.pojo.ClComment;
import com.yh.service.CommentsService;
/**
 * 
 * @author Administrator
 *项目评论实现
 */
@Service
public class CommentsServiceimpl implements CommentsService{
	@Autowired
	private ClCommentMapper clCommentMapper;
	@Override
	public List<ClComment> selectComment() {
		List<ClComment> selectComment = clCommentMapper.selectComment();
		return selectComment;
	}
	@Override
	public List<ClComment> selectCommentxq(int cmPsId) {
		List<ClComment> selectCommentxq = clCommentMapper.selectCommentxq(cmPsId);
		return selectCommentxq;
	}
	@Override
	public boolean delcomment(int cmId) {
		boolean delcomment = clCommentMapper.delcomment(cmId);
		return delcomment;
	}
	

}
