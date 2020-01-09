package com.yh.pojo.CLindex;
/**
 * 
 * @author Administrator
 *前段首页 自封pojo
 */
import java.io.Serializable;
import java.util.Date;



public class CLindexRe implements Serializable{
private int	r_id;// 推荐表id
private int	r_ps_id;//  项目表id
	 
private String	ps_name;//  项目标题
private double ps_money;// 筹资金额 总金额
private double	ps_getmoney;//  项目已筹资金额
private int	ps_getpeople;// 项目支持人数
private int	ps_type;//  项目状态
private String   ps_story; //项目故事
   private Date    ps_starttime;//项目开始的时间
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
public String getPs_name() {
	return ps_name;
}
public void setPs_name(String ps_name) {
	this.ps_name = ps_name;
}
public double getPs_money() {
	return ps_money;
}
public void setPs_money(double ps_money) {
	this.ps_money = ps_money;
}
public double getPs_getmoney() {
	return ps_getmoney;
}
public void setPs_getmoney(double ps_getmoney) {
	this.ps_getmoney = ps_getmoney;
}
public int getPs_getpeople() {
	return ps_getpeople;
}
public void setPs_getpeople(int ps_getpeople) {
	this.ps_getpeople = ps_getpeople;
}
public int getPs_type() {
	return ps_type;
}
public void setPs_type(int ps_type) {
	this.ps_type = ps_type;
}
public String getPs_story() {
	return ps_story;
}
public void setPs_story(String ps_story) {
	this.ps_story = ps_story;
}
public Date getPs_starttime() {
	return ps_starttime;
}
public void setPs_starttime(Date ps_starttime) {
	this.ps_starttime = ps_starttime;
}
@Override
public String toString() {
	return "CLindexRe [r_id=" + r_id + ", r_ps_id=" + r_ps_id + ", ps_name=" + ps_name + ", ps_money=" + ps_money
			+ ", ps_getmoney=" + ps_getmoney + ", ps_getpeople=" + ps_getpeople + ", ps_type=" + ps_type + ", ps_story="
			+ ps_story + ", ps_starttime=" + ps_starttime + "]";
}





}
