package com.yh.pojo;

public class Service {
    private Integer serId;

    private String serName;

    public Integer getSerId() {
        return serId;
    }

    public void setSerId(Integer serId) {
        this.serId = serId;
    }

    public String getSerName() {
        return serName;
    }

    public void setSerName(String serName) {
        this.serName = serName == null ? null : serName.trim();
    }
}