package com.kkk.entity;

import java.util.Date;

public class Reply {
    private Integer id;

    private String userid;

    private Integer questionid;

    private String repcontent;

    private Date repdatetime;

    private String state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public Integer getQuestionid() {
        return questionid;
    }

    public void setQuestionid(Integer questionid) {
        this.questionid = questionid;
    }

    public String getRepcontent() {
        return repcontent;
    }

    public void setRepcontent(String repcontent) {
        this.repcontent = repcontent == null ? null : repcontent.trim();
    }

    public Date getRepdatetime() {
        return repdatetime;
    }

    public void setRepdatetime(Date repdatetime) {
        this.repdatetime = repdatetime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }
}