package com.yh.pojo;

import java.io.Serializable;

public class User implements Serializable{
    private Integer usId;

    private String usEmail;

    private String usName;

    private String usPassword;

    private Double usMoney;

    private String usIdcard;

    private String usPhone;

    private String usAddress;

    private Integer usRole;

    private String usSex;

    private String usCode;

    public Integer getUsId() {
        return usId;
    }

    public void setUsId(Integer usId) {
        this.usId = usId;
    }

    public String getUsEmail() {
        return usEmail;
    }

    public void setUsEmail(String usEmail) {
        this.usEmail = usEmail == null ? null : usEmail.trim();
    }

    public String getUsName() {
        return usName;
    }

    public void setUsName(String usName) {
        this.usName = usName == null ? null : usName.trim();
    }

    public String getUsPassword() {
        return usPassword;
    }

    public void setUsPassword(String usPassword) {
        this.usPassword = usPassword == null ? null : usPassword.trim();
    }

    public Double getUsMoney() {
        return usMoney;
    }

    public void setUsMoney(Double usMoney) {
        this.usMoney = usMoney;
    }

    public String getUsIdcard() {
        return usIdcard;
    }

    public void setUsIdcard(String usIdcard) {
        this.usIdcard = usIdcard == null ? null : usIdcard.trim();
    }

    public String getUsPhone() {
        return usPhone;
    }

    public void setUsPhone(String usPhone) {
        this.usPhone = usPhone == null ? null : usPhone.trim();
    }

    public String getUsAddress() {
        return usAddress;
    }

    public void setUsAddress(String usAddress) {
        this.usAddress = usAddress == null ? null : usAddress.trim();
    }

    public Integer getUsRole() {
        return usRole;
    }

    public void setUsRole(Integer usRole) {
        this.usRole = usRole;
    }

    public String getUsSex() {
        return usSex;
    }

    public void setUsSex(String usSex) {
        this.usSex = usSex == null ? null : usSex.trim();
    }

    public String getUsCode() {
        return usCode;
    }

    public void setUsCode(String usCode) {
        this.usCode = usCode == null ? null : usCode.trim();
    }
}