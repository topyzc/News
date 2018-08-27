package cn.news.entities;

public class Categories {
	
	private int topicId;
	
	private String topicName;

	
	public Categories(int topicId, String topicName) {
		super();
		this.topicId = topicId;
		this.topicName = topicName;
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

	@Override
	public String toString() {
		return "Categories [topicId=" + topicId + ", topicName=" + topicName + "]";
	}

	


	
	

}
