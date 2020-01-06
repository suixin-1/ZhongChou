package com.yh.pojo;

public class Condition {
private String psName;
private String usName;
private int psType;
private String pstName;
@Override
public String toString() {
	return "Condition [psName=" + psName + ", usName=" + usName + ", psType=" + psType + ", pstName=" + pstName + "]";
}
public Condition() {
	super();
}
public Condition(String psName, String usName, int psType, String pstName) {
	super();
	this.psName = psName;
	this.usName = usName;
	this.psType = psType;
	this.pstName = pstName;
}
public String getPsName() {
	return psName;
}
public void setPsName(String psName) {
	this.psName = psName;
}
public String getUsName() {
	return usName;
}
public void setUsName(String usName) {
	this.usName = usName;
}
public int getPsType() {
	return psType;
}
public void setPsType(int psType) {
	this.psType = psType;
}
public String getPstName() {
	return pstName;
}
public void setPstName(String pstName) {
	this.pstName = pstName;
}

}
