package com.blog.javabean;

/**
 * 
 * 今日新闻  Bean
 * @author Administrator
 *
 */
public class newsBean {
	private String title;
	private String imgUrl;
	private String newsUrl;
	
	public newsBean(String title,String imgUrl,String newsUrl){
		this.title = title;
		this.imgUrl = imgUrl;
		this.newsUrl = newsUrl;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public String getNewsUrl() {
		return newsUrl;
	}
	public void setNewsUrl(String newsUrl) {
		this.newsUrl = newsUrl;
	}
}
