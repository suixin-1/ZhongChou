package com.yh.pojo.f_common;

import java.io.Serializable;

/**
 * 
 * @author Administrator
 *	返回数据封装类 F
 */
public class ResponseCommon implements Serializable{
	private Integer status;
	private Object data;
	private String msg;
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public ResponseCommon(Integer status, Object data, String msg) {
		super();
		this.status = status;
		this.data = data;
		this.msg = msg;
	}
	public ResponseCommon() {
		super();
	}
	@Override
	public String toString() {
		return "ResponseCommon [status=" + status + ", data=" + data + ", msg=" + msg + "]";
	}
	
}
