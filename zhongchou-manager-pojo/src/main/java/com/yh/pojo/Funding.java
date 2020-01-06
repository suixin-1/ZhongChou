package com.yh.pojo;

import java.io.Serializable;
import java.util.Date;

public class Funding implements Serializable{
    private Integer fdId;

    private Integer fdUsId;

    private Integer fdPsId;

    private Double fdMoney;

    private Date fdTime;

    public Integer getFdId() {
        return fdId;
    }

    public void setFdId(Integer fdId) {
        this.fdId = fdId;
    }

    public Integer getFdUsId() {
        return fdUsId;
    }

    public void setFdUsId(Integer fdUsId) {
        this.fdUsId = fdUsId;
    }

    public Integer getFdPsId() {
        return fdPsId;
    }

    public void setFdPsId(Integer fdPsId) {
        this.fdPsId = fdPsId;
    }

    public Double getFdMoney() {
        return fdMoney;
    }

    public void setFdMoney(Double fdMoney) {
        this.fdMoney = fdMoney;
    }

    public Date getFdTime() {
        return fdTime;
    }

    public void setFdTime(Date fdTime) {
        this.fdTime = fdTime;
    }

	@Override
	public String toString() {
		return "Funding [fdId=" + fdId + ", fdUsId=" + fdUsId + ", fdPsId=" + fdPsId + ", fdMoney=" + fdMoney
				+ ", fdTime=" + fdTime + "]";
	}
    
    
}