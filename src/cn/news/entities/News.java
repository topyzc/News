package cn.news.entities;

import java.util.Date;

public class News {
	
	private int newsId;
	private String newsName;
	private String newsText;
	private int topicId;	
	private Date newsTime;

	

	public News(String newsName, String newsText, int topicId, Date newsTime) {
		super();
		this.newsName = newsName;
		this.newsText = newsText;
		this.topicId = topicId;
		this.newsTime = newsTime;
	}

	public News(int newsId, String newsName, String newsText, Date newsTime) {
		super();
		this.newsId = newsId;
		this.newsName = newsName;
		this.newsText = newsText;
		this.newsTime = newsTime;
	}

	public News(int newsId, String newsName, String newsText, int topicId, Date newsTime) {
		super();
		this.newsId = newsId;
		this.newsName = newsName;
		this.newsText = newsText;
		this.topicId = topicId;
		this.newsTime = newsTime;
	}
    
	public int getNewsId() {
		return newsId;
	}

   
	public int getTopicId() {
		return topicId;
	}

	public void setTopicId(int topicId) {
		this.topicId = topicId;
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

	/*public int getTopicId() {
		return topicId;
	}

	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}
*/
	
	public Date getNewsTime() {
		return newsTime;
	}

	public void setNewsTime(Date newsTime) {
		this.newsTime = newsTime;
	}

	@Override
	public String toString() {
		return "News [newsId=" + newsId + ", newsName=" + newsName + ", newsText=" + newsText + ", topicId=" + topicId
				+ ", newsTime=" + newsTime + "]";
	}


	

	

	
	
	
	

}
