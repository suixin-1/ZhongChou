package com.yh.pojo;

import java.io.Serializable;
import java.util.Date;

public class ProjectA implements Serializable{
   private String pstName;
   private String psName;
   private  Date psStarttime;
   private Date psEndtime;
   private double psGetmoney;
   private double psMoney;
   private String usName;
   private int usId;
   private String psType;
   private int psId;

   public int getPsId() {
	return psId;
}
public void setPsId(int psId) {
	this.psId = psId;
}
public double getPsMoney() {
	return psMoney;
}
public void setPsMoney(double psMoney) {
	this.psMoney = psMoney;
}
public String getPsType() {
	return psType;
}
public void setPsType(String psType) {
	this.psType = psType;
}
public String getPstName() {
	return pstName;
}
public void setPstName(String pstName) {
	this.pstName = pstName;
}
public String getPsName() {
	return psName;
}
public void setPsName(String psName) {
	this.psName = psName;
}
public Date getPsStarttime() {
	return psStarttime;
}
public void setPsStarttime(Date psStarttime) {
	this.psStarttime = psStarttime;
}
public Date getPsEndtime() {
	return psEndtime;
}
public void setPsEndtime(Date psEndtime) {
	this.psEndtime = psEndtime;
}
public double getPsGetmoney() {
	return psGetmoney;
}
public void setPsGetmoney(double psGetmoney) {
	this.psGetmoney = psGetmoney;
}
public String getUsName() {
	return usName;
}
public void setUsName(String usName) {
	this.usName = usName;
}
public int getUsId() {
	return usId;
}
public void setUsId(int usId) {
	this.usId = usId;
}
@Override
public String toString() {
	return "projectA [pstName=" + pstName + ", psName=" + psName + ", psStarttime=" + psStarttime + ", psEndtime="
			+ psEndtime + ", psGetmoney=" + psGetmoney + ", usName=" + usName + ", usId=" + usId + "]";
}
public ProjectA(String pstName, String psName, Date psStarttime, Date psEndtime, double psGetmoney, String usName,
		int usId) {
	super();
	this.pstName = pstName;
	this.psName = psName;
	this.psStarttime = psStarttime;
	this.psEndtime = psEndtime;
	this.psGetmoney = psGetmoney;
	this.usName = usName;
	this.usId = usId;
}
public ProjectA() {
	super();
}
 
   
   
   
   
   
   
}
