package com.yh.service.questionallService.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yh.mapper.QuestionallMapper;
import com.yh.mapper.QuestionotherMapper;
import com.yh.pojo.Questionall;
import com.yh.pojo.QuestionallExample;
import com.yh.pojo.QuestionallExample.Criteria;
import com.yh.pojo.Questionother;
import com.yh.pojo.QuestionotherExample;
import com.yh.pojo.zhongchouResult;
import com.yh.service.questionall.QuestionallService;
@Service
public class QuestionallServiceImpl implements QuestionallService{

	@Autowired
	private QuestionallMapper questionallMapper;
	
	@Autowired
	private QuestionotherMapper questionotherMapper;
	@Override
	public List<Questionall> selectQuestionallAll() {
		QuestionallExample example = new QuestionallExample();	
		return questionallMapper.selectByExample(example);
	}

	@Override
	public zhongchouResult addQuestionall(String questionname) {
		Questionall questionall = new Questionall();
		questionall.setQuestionid(null);
		questionall.setQuestionname(questionname);
		
		//判断添加的name是否已有
		QuestionallExample example = new QuestionallExample();
		Criteria criteria = example.createCriteria();
		criteria.andQuestionnameEqualTo(questionname);
		List<Questionall> selectByExample = questionallMapper.selectByExample(example);
		if(selectByExample.isEmpty()){
			int i = questionallMapper.insert(questionall);
			if(i>0){
				return zhongchouResult.build(200, "添加父问题成功");
			}
			return zhongchouResult.build(500, "添加父问题失败");		
		}
		return zhongchouResult.build(500, "添加父问题失败,name已有");
	}

	
	public List<Questionother> selectQuestionother(int parseInt) {
		QuestionotherExample example = new QuestionotherExample();
		com.yh.pojo.QuestionotherExample.Criteria criteria = example.createCriteria();
		criteria.andQuestionidEqualTo(parseInt);
		
		return questionotherMapper.selectByExample(example);
	}

	@Override
	public Questionother ToupdateQuestionother(int parseInt) {
		
		return questionotherMapper.selectByPrimaryKey(parseInt);
	}

	@Override
	public zhongchouResult updateQuestionother(String questionothername, String questionanswer,int questionotherid) {
		Questionother questionother = new Questionother();
		questionother.setQuestionothername(questionothername);
		questionother.setQuestionanswer(questionanswer);
		
		QuestionotherExample example = new QuestionotherExample();
		com.yh.pojo.QuestionotherExample.Criteria criteria = example.createCriteria();
		criteria.andQuestionotheridEqualTo(questionotherid);
		int i = questionotherMapper.updateByExampleSelective(questionother, example);
		if(i>0){
			return zhongchouResult.build(200, "修改成功");
		}
		return zhongchouResult.build(500, "修改失败");
	}

	@Override
	public zhongchouResult addQuestionother(String questionothername, String questionanswer, int parseInt) {
		Questionother questionother = new Questionother();
		questionother.setQuestionotherid(null);
		questionother.setQuestionid(parseInt);
		
		questionother.setQuestionothername(questionothername);
		questionother.setQuestionanswer(questionanswer);
		questionother.setQuestiondate(new Date());
		int i = questionotherMapper.insert(questionother);
		if(i>0){
			return zhongchouResult.build(200, "添加成功");
		}
		return zhongchouResult.build(500, "添加失败");
	}

}
