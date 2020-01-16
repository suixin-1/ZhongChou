package com.yh.pojo;

public class Comments {
    private Integer cmId;

    private Integer cmUsId;

    private Integer cmPsId;

    private String cmContent;

    public Integer getCmId() {
        return cmId;
    }

    public void setCmId(Integer cmId) {
        this.cmId = cmId;
    }

    public Integer getCmUsId() {
        return cmUsId;
    }

    public void setCmUsId(Integer cmUsId) {
        this.cmUsId = cmUsId;
    }

    public Integer getCmPsId() {
        return cmPsId;
    }

    public void setCmPsId(Integer cmPsId) {
        this.cmPsId = cmPsId;
    }

    public String getCmContent() {
        return cmContent;
    }

    public void setCmContent(String cmContent) {
        this.cmContent = cmContent == null ? null : cmContent.trim();
    }
}