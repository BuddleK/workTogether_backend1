package com.wt.app.dto;

public class NewsListDTO {

//	뉴스 번호
//	뉴스 제목
//	뉴스 링크
	
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
		return "NewsDTO [newsNumber=" + newsNumber + ", adminNumber=" + adminNumber + ", newsTitle=" + newsTitle
				+ ", newsLinkUrl=" + newsLinkUrl + ", newsCreatedDate=" + newsCreatedDate + ", newsUpdatedDate="
				+ newsUpdatedDate + "]";
	}
}
