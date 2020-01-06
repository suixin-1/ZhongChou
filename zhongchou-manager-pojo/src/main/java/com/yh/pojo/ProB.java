package com.yh.pojo;

public class ProB {
    private Integer proBId;

    private Integer proBUsId;

    private String proBFile;

    private String proBGoal;

    private String proBAddress;

    private String proBMoney;

    private Integer proBDatenum;

    public Integer getProBId() {
        return proBId;
    }

    public void setProBId(Integer proBId) {
        this.proBId = proBId;
    }

    public Integer getProBUsId() {
        return proBUsId;
    }

    public void setProBUsId(Integer proBUsId) {
        this.proBUsId = proBUsId;
    }

    public String getProBFile() {
        return proBFile;
    }

    public void setProBFile(String proBFile) {
        this.proBFile = proBFile == null ? null : proBFile.trim();
    }

    public String getProBGoal() {
        return proBGoal;
    }

    public void setProBGoal(String proBGoal) {
        this.proBGoal = proBGoal == null ? null : proBGoal.trim();
    }

    public String getProBAddress() {
        return proBAddress;
    }

    public void setProBAddress(String proBAddress) {
        this.proBAddress = proBAddress == null ? null : proBAddress.trim();
    }

    public String getProBMoney() {
        return proBMoney;
    }

    public void setProBMoney(String proBMoney) {
        this.proBMoney = proBMoney == null ? null : proBMoney.trim();
    }

    public Integer getProBDatenum() {
        return proBDatenum;
    }

    public void setProBDatenum(Integer proBDatenum) {
        this.proBDatenum = proBDatenum;
    }
}