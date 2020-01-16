package com.yh.pojo;

public class ProA {
    private Integer proAId;

    private Integer proAUsId;

    private String proACustName;

    private String proACustPhone;

    private Integer proAPstId;

    private String proACustAddress;

    public Integer getProAId() {
        return proAId;
    }

    public void setProAId(Integer proAId) {
        this.proAId = proAId;
    }

    public Integer getProAUsId() {
        return proAUsId;
    }

    public void setProAUsId(Integer proAUsId) {
        this.proAUsId = proAUsId;
    }

    public String getProACustName() {
        return proACustName;
    }

    public void setProACustName(String proACustName) {
        this.proACustName = proACustName == null ? null : proACustName.trim();
    }

    public String getProACustPhone() {
        return proACustPhone;
    }

    public void setProACustPhone(String proACustPhone) {
        this.proACustPhone = proACustPhone == null ? null : proACustPhone.trim();
    }

    public Integer getProAPstId() {
        return proAPstId;
    }

    public void setProAPstId(Integer proAPstId) {
        this.proAPstId = proAPstId;
    }

    public String getProACustAddress() {
        return proACustAddress;
    }

    public void setProACustAddress(String proACustAddress) {
        this.proACustAddress = proACustAddress == null ? null : proACustAddress.trim();
    }
}