package com.blog.javabean;

import java.util.Date;

public class docBean {
	
	private String messageId;
	private String username;
	private String personalIntro;
	private String imgId;
	private String textName;
	private String txt;
	private String type;
	
	private Date date;
	private int txtNum;
	private int readNum;
	
	
	public docBean(){}
	public docBean(String messageId,String username,String personalIntro,String imgId,String textName,String txt,Date date,int txtNum,int readNum){
		this.messageId = messageId;
		this.username = username;
		this.personalIntro = personalIntro;
		this.imgId = imgId;
		this.textName = textName;
		this.txt = txt;
		this.date = date;
		this.txtNum = txtNum;
		this.readNum = readNum;
	}
	
	public docBean(String messageId,String username,String personalIntro,String imgId,String textName,String txt,Date date,int txtNum,int readNum,String type){
		this.messageId = messageId;
		this.username = username;
		this.personalIntro = personalIntro;
		this.imgId = imgId;
		this.textName = textName;
		this.txt = txt;
		this.date = date;
		this.txtNum = txtNum;
		this.readNum = readNum;
		this.type = type;
	}
	
	public docBean(String messageId,String username,String personalIntro,String imgId,String textName,String txt,Date date,int txtNum){
		this.messageId = messageId;
		this.username = username;
		this.personalIntro = personalIntro;
		this.imgId = imgId;
		this.textName = textName;
		this.txt = txt;
		this.date = date;
		this.txtNum = txtNum;
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
	public String getPersonalIntro() {
		return personalIntro;
	}
	public void setPersonalIntro(String personalIntro) {
		this.personalIntro = personalIntro;
	}
	public String getImgId() {
		return imgId;
	}
	public void setImgId(String imgId) {
		this.imgId = imgId;
	}
	public String getTextName() {
		return textName;
	}
	public void setTextName(String textName) {
		this.textName = textName;
	}
	public String getTxt() {
		return txt;
	}
	public void setTxt(String txt) {
		this.txt = txt;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getTxtNum() {
		return txtNum;
	}
	public void setTxtNum(int txtNum) {
		this.txtNum = txtNum;
	}
	public int getReadNum() {
		return readNum;
	}
	public void setReadNum(int readNum) {
		this.readNum = readNum;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
