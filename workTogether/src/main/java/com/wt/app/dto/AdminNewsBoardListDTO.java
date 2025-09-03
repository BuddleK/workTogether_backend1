package com.wt.app.dto;

public class AdminNewsBoardListDTO {
	private int    newsNumber;
    private String newsTitle;
    private String newsLinkUrl;      // ← 목록에도 필요 (매퍼에서 SELECT 함)
    private String adminName;
    private String newsCreatedDate;  // ← TO_CHAR로 받음
    private String newsUpdatedDate;
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
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
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
		return "AdminNewsBoardListDTO [newsNumber=" + newsNumber + ", newsTitle=" + newsTitle + ", newsLinkUrl="
				+ newsLinkUrl + ", adminName=" + adminName + ", newsCreatedDate=" + newsCreatedDate
				+ ", newsUpdatedDate=" + newsUpdatedDate + "]";
	}
	
}
