package com.yh.pojo;

import java.io.Serializable;
import java.util.Date;

public class Projectstype implements Serializable{
    private Integer pstId;

    private String pstName;

    private String pstDesc;

    private Date pstStardate;

    private Integer pstType;

    public Integer getPstId() {
        return pstId;
    }

    public void setPstId(Integer pstId) {
        this.pstId = pstId;
    }

    public String getPstName() {
        return pstName;
    }

    public void setPstName(String pstName) {
        this.pstName = pstName == null ? null : pstName.trim();
    }

    public String getPstDesc() {
        return pstDesc;
    }

    public void setPstDesc(String pstDesc) {
        this.pstDesc = pstDesc == null ? null : pstDesc.trim();
    }

    public Date getPstStardate() {
        return pstStardate;
    }

    public void setPstStardate(Date pstStardate) {
        this.pstStardate = pstStardate;
    }

    public Integer getPstType() {
        return pstType;
    }

    public void setPstType(Integer pstType) {
        this.pstType = pstType;
    }
}