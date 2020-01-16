package com.yh.pojo;

import java.io.Serializable;

public class Comment implements Serializable {
	private String name;
	private String comment;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	@Override
	public String toString() {
		return "Comment [name=" + name + ", comment=" + comment + "]";
	}
	
}
