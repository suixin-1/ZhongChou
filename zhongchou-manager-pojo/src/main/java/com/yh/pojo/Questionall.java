package com.yh.pojo;

import java.io.Serializable;

public class Questionall implements Serializable{
    private Integer questionid;

    private String questionname;

    public Integer getQuestionid() {
        return questionid;
    }

    public void setQuestionid(Integer questionid) {
        this.questionid = questionid;
    }

    public String getQuestionname() {
        return questionname;
    }

    public void setQuestionname(String questionname) {
        this.questionname = questionname == null ? null : questionname.trim();
    }
}