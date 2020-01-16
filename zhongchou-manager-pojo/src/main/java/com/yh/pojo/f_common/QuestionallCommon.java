package com.yh.pojo.f_common;

import java.io.Serializable;
import java.util.List;

import com.yh.pojo.Questionother;

public class QuestionallCommon implements Serializable{
	
	private String questionname;
	private List<Questionother> questionotherList;
	public String getQuestionname() {
		return questionname;
	}
	public void setQuestionname(String questionname) {
		this.questionname = questionname;
	}
	public List<Questionother> getQuestionotherList() {
		return questionotherList;
	}
	public void setQuestionotherList(List<Questionother> questionotherList) {
		this.questionotherList = questionotherList;
	}
	@Override
	public String toString() {
		return "QuestionallCommon [questionname=" + questionname + ", questionotherList=" + questionotherList + "]";
	}
	
}
