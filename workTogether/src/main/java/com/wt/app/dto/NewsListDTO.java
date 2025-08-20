package com.wt.app.dto;

public class NewsListDTO {

//	일반 뉴스 번호
//	일반 뉴스 제목
//	일반 뉴스 링크
//	일반 뉴스 등록일
	
	private int newsNumber;
	private String newsTitle;
	private String newsLinkUrl;
	private String newsCreatedDate;
	public int getNewsNumber() {
		return newsNumber;
	}
	public void setNewsNumber(int newsNumber) {
		this.newsNumber = newsNumber;
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
	@Override
	public String toString() {
		return "NewsListDTO [newsNumber=" + newsNumber + ", newsTitle=" + newsTitle + ", newsLinkUrl=" + newsLinkUrl
				+ ", newsCreatedDate=" + newsCreatedDate + "]";
	}
	
}
