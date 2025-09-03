package com.wt.app.dto;

public class AdminNewsBoardDTO {
//	    news_number NUMBER PRIMARY KEY,
	 //   admin_number NUMBER NOT NULL,
//	    news_title VARCHAR2(300) NOT NULL,
//	    news_link_url VARCHAR2(1000),
//	    news_created_date DATE NOT NULL,
//	    news_updated_date DATE,
		
	private int newsNumber;
    private int adminNumber;
    private String newsTitle;
    private String newsLinkUrl;
    private String newsCreatedDate;
    private String newsUpdatedDate;
	public int getNewsNumber() {
		return newsNumber;
	}
	public void setNewsNumber(int newsNumber) {
		this.newsNumber = newsNumber;
	}
	public int getAdminNumber() {
		return adminNumber;
	}
	public void setAdminNumber(int adminNumber) {
		this.adminNumber = adminNumber;
	}
	public String getNewsTitle() {
		return newsTitle;
	}
	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}
	public String getNewsLinkUrl() {
		return newsLinkUrl;
	}
	public void setNewsLinkUrl(String newsLinkUrl) {
		this.newsLinkUrl = newsLinkUrl;
	}
	public String getNewsCreatedDate() {
		return newsCreatedDate;
	}
	public void setNewsCreatedDate(String newsCreatedDate) {
		this.newsCreatedDate = newsCreatedDate;
	}
	public String getNewsUpdatedDate() {
		return newsUpdatedDate;
	}
	public void setNewsUpdatedDate(String newsUpdatedDate) {
		this.newsUpdatedDate = newsUpdatedDate;
	}
	@Override
	public String toString() {
		return "AdminNewsBoardDTO [newsNumber=" + newsNumber + ", adminNumber=" + adminNumber + ", newsTitle="
				+ newsTitle + ", newsLinkUrl=" + newsLinkUrl + ", newsCreatedDate=" + newsCreatedDate
				+ ", newsUpdatedDate=" + newsUpdatedDate + "]";
	}
	
    
}
