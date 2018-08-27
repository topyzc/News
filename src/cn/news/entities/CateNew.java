package cn.news.entities;

import java.util.Date;

public class CateNew {
	
	private int newsId;
	private String newsName;
	private String newsText;
    private int topicId;
	
	private String topicName;	
	private Date newsTime;
	
	
	public CateNew(int newsId, String newsName, String newsText, int topicId, String topicName, Date newsTime) {
		super();
		this.newsId = newsId;
		this.newsName = newsName;
		this.newsText = newsText;
		this.topicId = topicId;
		this.topicName = topicName;
		this.newsTime = newsTime;
	}
	public int getNewsId() {
		return newsId;
	}
	public void setNewsId(int newsId) {
		this.newsId = newsId;
	}
	public String getNewsName() {
		return newsName;
	}
	public void setNewsName(String newsName) {
		this.newsName = newsName;
	}
	public String getNewsText() {
		return newsText;
	}
	public void setNewsText(String newsText) {
		this.newsText = newsText;
	}
	public int getTopicId() {
		return topicId;
	}
	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}
	public String getTopicName() {
		return topicName;
	}
	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}
	public Date getNewsTime() {
		return newsTime;
	}
	public void setNewsTime(Date newsTime) {
		this.newsTime = newsTime;
	}
	

}
