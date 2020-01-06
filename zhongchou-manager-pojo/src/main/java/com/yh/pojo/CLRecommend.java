package com.yh.pojo;

import java.io.Serializable;
/**
 * 
 * @author Administrator
 *项目推荐表 pojo
 */
public class CLRecommend implements Serializable{

	
	
private int	r_id;//推荐表id',
private int r_ps_id;//项目表id',
private int r_pst_id;//项目类型表id',
 private String ps_name;//项目表题
 private String pst_name;//项目类型
public int getR_id() {
	return r_id;
}
public void setR_id(int r_id) {
	this.r_id = r_id;
}
public int getR_ps_id() {
	return r_ps_id;
}
public void setR_ps_id(int r_ps_id) {
	this.r_ps_id = r_ps_id;
}
public int getR_pst_id() {
	return r_pst_id;
}
public void setR_pst_id(int r_pst_id) {
	this.r_pst_id = r_pst_id;
}
public String getPs_name() {
	return ps_name;
}
public void setPs_name(String ps_name) {
	this.ps_name = ps_name;
}
public String getPst_name() {
	return pst_name;
}
public void setPst_name(String pst_name) {
	this.pst_name = pst_name;
}
@Override
public String toString() {
	return "CLRecommend [r_id=" + r_id + ", r_ps_id=" + r_ps_id + ", r_pst_id=" + r_pst_id + ", ps_name=" + ps_name
			+ ", pst_name=" + pst_name + "]";
}


	
	
}
