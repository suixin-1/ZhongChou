package com.yh.pojo;

import java.io.Serializable;
import java.util.Date;

public class Questionother implements Serializable{
    private Integer questionotherid;

    private Integer questionid;

    private String questionothername;

    private String questionanswer;

    private Date questiondate;

    public Integer getQuestionotherid() {
        return questionotherid;
    }

    public void setQuestionotherid(Integer questionotherid) {
        this.questionotherid = questionotherid;
    }

    public Integer getQuestionid() {
        return questionid;
    }

    public void setQuestionid(Integer questionid) {
        this.questionid = questionid;
    }

    public String getQuestionothername() {
        return questionothername;
    }

    public void setQuestionothername(String questionothername) {
        this.questionothername = questionothername == null ? null : questionothername.trim();
    }

    public String getQuestionanswer() {
        return questionanswer;
    }

    public void setQuestionanswer(String questionanswer) {
        this.questionanswer = questionanswer == null ? null : questionanswer.trim();
    }

    public Date getQuestiondate() {
        return questiondate;
    }

    public void setQuestiondate(Date questiondate) {
        this.questiondate = questiondate;
    }
}