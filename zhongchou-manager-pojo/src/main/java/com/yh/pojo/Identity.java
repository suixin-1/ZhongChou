package com.yh.pojo;

import java.io.Serializable;

public class Identity implements Serializable{
    private Integer usIdentityId;

    private Integer usId;

    private String usIdentityImage1;

    private String usIdentityImage2;

    public Integer getUsIdentityId() {
        return usIdentityId;
    }

    public void setUsIdentityId(Integer usIdentityId) {
        this.usIdentityId = usIdentityId;
    }

    public Integer getUsId() {
        return usId;
    }

    public void setUsId(Integer usId) {
        this.usId = usId;
    }

    public String getUsIdentityImage1() {
        return usIdentityImage1;
    }

    public void setUsIdentityImage1(String usIdentityImage1) {
        this.usIdentityImage1 = usIdentityImage1 == null ? null : usIdentityImage1.trim();
    }

    public String getUsIdentityImage2() {
        return usIdentityImage2;
    }

    public void setUsIdentityImage2(String usIdentityImage2) {
        this.usIdentityImage2 = usIdentityImage2 == null ? null : usIdentityImage2.trim();
    }
}