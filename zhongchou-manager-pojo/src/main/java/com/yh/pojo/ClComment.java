package com.yh.pojo;

import java.io.Serializable;
/**
 * 自己弄得评论表pojo
 * @author Administrator
 *
 */
public class ClComment implements Serializable {
	private Integer cmId;//评论id
	private Integer cmUsId;//姓名id
	private Integer cmPsId;//项目id
	private String cmContent;//评论内容
	private String usname;//用户姓名
	private String psName;//项目名字
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
		this.cmContent = cmContent;
	}
	public String getUsname() {
		return usname;
	}
	public void setUsname(String usname) {
		this.usname = usname;
	}
	public String getPsName() {
		return psName;
	}
	public void setPsName(String psName) {
		this.psName = psName;
	}
	@Override
	public String toString() {
		return "ClComment [cmId=" + cmId + ", cmUsId=" + cmUsId + ", cmPsId=" + cmPsId + ", cmContent=" + cmContent
				+ ", usname=" + usname + ", psName=" + psName + "]";
	}
	
	
}
