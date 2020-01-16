package com.yh.pojo;

import java.io.Serializable;

public class Jurisdiction implements Serializable{
    private Integer juId;

    private Integer juAdId;

    private String juName;

    public Integer getJuId() {
        return juId;
    }

    public void setJuId(Integer juId) {
        this.juId = juId;
    }

    public Integer getJuAdId() {
        return juAdId;
    }

    public void setJuAdId(Integer juAdId) {
        this.juAdId = juAdId;
    }

    public String getJuName() {
        return juName;
    }

    public void setJuName(String juName) {
        this.juName = juName == null ? null : juName.trim();
    }
}