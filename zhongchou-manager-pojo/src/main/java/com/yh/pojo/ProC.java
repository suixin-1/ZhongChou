package com.yh.pojo;

public class ProC {
    private Integer proCId;

    private Integer proUsId;

    private String proCVedio;

    private String proCStory;

    private String proCSupport;

    private String proCRepay;

    private String proCAboutme;

    public Integer getProCId() {
        return proCId;
    }

    public void setProCId(Integer proCId) {
        this.proCId = proCId;
    }

    public Integer getProUsId() {
        return proUsId;
    }

    public void setProUsId(Integer proUsId) {
        this.proUsId = proUsId;
    }

    public String getProCVedio() {
        return proCVedio;
    }

    public void setProCVedio(String proCVedio) {
        this.proCVedio = proCVedio == null ? null : proCVedio.trim();
    }

    public String getProCStory() {
        return proCStory;
    }

    public void setProCStory(String proCStory) {
        this.proCStory = proCStory == null ? null : proCStory.trim();
    }

    public String getProCSupport() {
        return proCSupport;
    }

    public void setProCSupport(String proCSupport) {
        this.proCSupport = proCSupport == null ? null : proCSupport.trim();
    }

    public String getProCRepay() {
        return proCRepay;
    }

    public void setProCRepay(String proCRepay) {
        this.proCRepay = proCRepay == null ? null : proCRepay.trim();
    }

    public String getProCAboutme() {
        return proCAboutme;
    }

    public void setProCAboutme(String proCAboutme) {
        this.proCAboutme = proCAboutme == null ? null : proCAboutme.trim();
    }
}