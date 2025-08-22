package com.wt.app.dto;

public class AdminNewsBoardListDTO {
	private int newsNumber;			// 뉴스 번호
    private String newsTitle;		// 뉴스 제목
    private String adminName;       // 관리자 이름
    private String newsCreatedDate; // 작성 날짜
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
	@Override
	public String toString() {
		return "AdminNewsBoardListDTO [newsNumber=" + newsNumber + ", newsTitle=" + newsTitle + ", adminName="
				+ adminName + ", newsCreatedDate=" + newsCreatedDate + "]";
	}
	
    

}
