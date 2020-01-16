package com.yh.pojo;

import java.io.Serializable;

public class zhongchouResult implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer status;
	
	private Object data;
	
	private String msg;
	
	public zhongchouResult(){}
	
	public zhongchouResult(Integer status){
		this.status = status;
	}
	
	public zhongchouResult(Integer status,String msg){
		this.status = status;
		this.msg = msg;
	}
	
	public zhongchouResult(Integer status,String msg,Object data){
		this.status = status;
		this.msg = msg;
		this.data = data;
	}

	public Integer getStatus() {
		return status;
	}
	
	public static zhongchouResult ok(){
		return new zhongchouResult(200);
	}
	public static zhongchouResult ok(Integer status,Object data){
		return new zhongchouResult(status,null,data);
	}
	public static zhongchouResult ok(Integer status,String msg,Object data){
		return new zhongchouResult(status,msg,data);
	}
	public static zhongchouResult build(Integer status,String msg){
		return new zhongchouResult(status,msg);
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

	@Override
	public String toString() {
		return "zhongchouResult [status=" + status + ", data=" + data + ", msg=" + msg + "]";
	}
	
	
}
