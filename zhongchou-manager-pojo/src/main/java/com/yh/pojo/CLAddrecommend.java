package com.yh.pojo;

import java.io.Serializable;

/**
 * 添加项目推荐  pojo
 * 
 * @author Administrator
 *
 */

public class CLAddrecommend implements Serializable{

private int	ps_id;//项目ID
private String	ps_name;//项目名称
private int	pst_id;//项目类型ID
private String	pst_name;//项目类型名称
public int getPs_id() {
	return ps_id;
}
public void setPs_id(int ps_id) {
	this.ps_id = ps_id;
}
public String getPs_name() {
	return ps_name;
}
public void setPs_name(String ps_name) {
	this.ps_name = ps_name;
}
public int getPst_id() {
	return pst_id;
}
public void setPst_id(int pst_id) {
	this.pst_id = pst_id;
}
public String getPst_name() {
	return pst_name;
}
public void setPst_name(String pst_name) {
	this.pst_name = pst_name;
}
@Override
public String toString() {
	return "CLAddrecommend [ps_id=" + ps_id + ", ps_name=" + ps_name + ", pst_id=" + pst_id + ", pst_name=" + pst_name
			+ "]";
}
	
	
}
