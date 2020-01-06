package com.yh.pojo;

import java.util.Date;

public class Logs {
    private Integer logId;

    private Integer logUsId;

    private String logContent;

    private Date logDate;

    public Integer getLogId() {
        return logId;
    }

    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    public Integer getLogUsId() {
        return logUsId;
    }

    public void setLogUsId(Integer logUsId) {
        this.logUsId = logUsId;
    }

    public String getLogContent() {
        return logContent;
    }

    public void setLogContent(String logContent) {
        this.logContent = logContent == null ? null : logContent.trim();
    }

    public Date getLogDate() {
        return logDate;
    }

    public void setLogDate(Date logDate) {
        this.logDate = logDate;
    }
}