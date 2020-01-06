package com.yh.pojo;

public class Repay {
    private Integer ryId;

    private Integer ryUsId;

    private Integer ryType;

    private Double ryPaymoney;

    private String ryRule;

    private String ryContent;

    private Integer ryNumber;

    private String ryTime;

    private Integer ryPsId;

    private String ryCode;

    public Integer getRyId() {
        return ryId;
    }

    public void setRyId(Integer ryId) {
        this.ryId = ryId;
    }

    public Integer getRyUsId() {
        return ryUsId;
    }

    public void setRyUsId(Integer ryUsId) {
        this.ryUsId = ryUsId;
    }

    public Integer getRyType() {
        return ryType;
    }

    public void setRyType(Integer ryType) {
        this.ryType = ryType;
    }

    public Double getRyPaymoney() {
        return ryPaymoney;
    }

    public void setRyPaymoney(Double ryPaymoney) {
        this.ryPaymoney = ryPaymoney;
    }

    public String getRyRule() {
        return ryRule;
    }

    public void setRyRule(String ryRule) {
        this.ryRule = ryRule == null ? null : ryRule.trim();
    }

    public String getRyContent() {
        return ryContent;
    }

    public void setRyContent(String ryContent) {
        this.ryContent = ryContent == null ? null : ryContent.trim();
    }

    public Integer getRyNumber() {
        return ryNumber;
    }

    public void setRyNumber(Integer ryNumber) {
        this.ryNumber = ryNumber;
    }

    public String getRyTime() {
        return ryTime;
    }

    public void setRyTime(String ryTime) {
        this.ryTime = ryTime == null ? null : ryTime.trim();
    }

    public Integer getRyPsId() {
        return ryPsId;
    }

    public void setRyPsId(Integer ryPsId) {
        this.ryPsId = ryPsId;
    }

    public String getRyCode() {
        return ryCode;
    }

    public void setRyCode(String ryCode) {
        this.ryCode = ryCode == null ? null : ryCode.trim();
    }
}