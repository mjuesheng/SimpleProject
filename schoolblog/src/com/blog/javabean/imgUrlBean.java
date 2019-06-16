package com.blog.javabean;

public class imgUrlBean {
	String id;
	String url;
	String imgName;
	public imgUrlBean(){
		
	}
	
	public imgUrlBean(String id,String url){
		this.id = id;
		this.url = url;
	}
	public imgUrlBean(String id,String url,String imgName){
		this.id = id;
		this.url = url;
		this.imgName  = imgName;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getimgName() {
		return imgName;
	}

	public void setimgName(String imgName) {
		this.imgName = imgName;
	}

	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
}
