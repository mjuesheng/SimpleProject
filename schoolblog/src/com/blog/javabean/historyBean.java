package com.blog.javabean;

import java.util.Date;

public class historyBean {
	String userId;
	Date upTime;
	String operName;
	String type;
	int count;
	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}


	public historyBean(Date upTime,String operName,String type,int count){
		this.upTime = upTime;
		this.operName = operName;
		this.type = type;
		this.count = count;
	}
	
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Date getUpTime() {
		return upTime;
	}
	public void setUpTime(Date upTime) {
		this.upTime = upTime;
	}
	public String getOperName() {
		return operName;
	}
	public void setOperName(String operName) {
		this.operName = operName;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

}
