package com.blog.javabean;

import java.util.Date;

public class megSubBean {
	private String messageId;
	
	private String username;
	private String title;
	private String introduce;
	private String text;
	private String discuss;
	private String homePage;
	private Date date;
	private String textType;
	private int readNum;
	
	public int getReadNum() {
		return readNum;
	}
	public void setReadNum(int readNum) {
		this.readNum = readNum;
	}
	public megSubBean(){}
	public megSubBean(String messageId,String username,String title,String introduce,String text,String discuss,String homePage,Date date,String textType){
		this.messageId = messageId;
		this.username = username;
		this.title = title;
		this.introduce = introduce;
		this.text = text;
		this.discuss = discuss;
		this.homePage = homePage;
		this.date = date;
		this.textType = textType;
	}
	public megSubBean(String messageId,String username,String title,String introduce,String text,String discuss,String homePage,Date date,String textType,int readNum){
		this.messageId = messageId;
		this.username = username;
		this.title = title;
		this.introduce = introduce;
		this.text = text;
		this.discuss = discuss;
		this.homePage = homePage;
		this.date = date;
		this.textType = textType;
		this.readNum = readNum;
	}
	public String getMessageId() {
		return messageId;
	}
	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getDiscuss() {
		return discuss;
	}
	public void setDiscuss(String discuss) {
		this.discuss = discuss;
	}
	public String getHomePage() {
		return homePage;
	}
	public void setHomePage(String homePage) {
		this.homePage = homePage;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getTextType() {
		return textType;
	}
	public void setTextType(String textType) {
		this.textType = textType;
	}
}
