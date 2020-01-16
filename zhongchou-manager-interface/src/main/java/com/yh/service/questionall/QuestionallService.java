package com.yh.service.questionall;

import java.util.List;

import com.yh.pojo.Questionall;
import com.yh.pojo.Questionother;
import com.yh.pojo.zhongchouResult;

public interface QuestionallService {
	
	List<Questionall> selectQuestionallAll();

	zhongchouResult addQuestionall(String questionname);

	List<Questionother> selectQuestionother(int parseInt);

	Questionother ToupdateQuestionother(int parseInt);

	zhongchouResult updateQuestionother(String questionothername, String questionanswer,int questionotherid);

	zhongchouResult addQuestionother(String questionothername, String questionanswer, int parseInt);

	zhongchouResult deleteQuestionotherById(int parseInt);
}
