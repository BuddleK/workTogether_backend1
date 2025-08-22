package com.wt.app.dto;

public class AdminNewsBoardDTO {
//	    news_number NUMBER PRIMARY KEY,
	 //   admin_number NUMBER NOT NULL,
//	    news_title VARCHAR2(300) NOT NULL,
//	    news_link_url VARCHAR2(1000),
//	    news_created_date DATE NOT NULL,
//	    news_updated_date DATE,
		
	private int newsNumber;			// 뉴스 번호
    private int adminNumber;     	// 관리자 번호
    private String newsTitle;       // 제목
    private String newsContent;     // 내용 -- 있어야 할 것.. 같아서 추가
    private String newsLinkUrl;     // 링크
    private Integer filesNumber;    // 첨부파일
    private String newsCreatedDate; // 작성날짜
    private String newsUpdatedDate; // 수정날짜
	
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
	public String getNewsContent() {
		return newsContent;
	}
	public void setNewsContent(String newsContent) {
		this.newsContent = newsContent;
	}
	public String getNewsLinkUrl() {
		return newsLinkUrl;
	}
	public void setNewsLinkUrl(String newsLinkUrl) {
		this.newsLinkUrl = newsLinkUrl;
	}
	public Integer getFilesNumber() {
		return filesNumber;
	}
	public void setFilesNumber(Integer filesNumber) {
		this.filesNumber = filesNumber;
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
				+ newsTitle + ", newsContent=" + newsContent + ", newsLinkUrl=" + newsLinkUrl + ", filesNumber="
				+ filesNumber + ", newsCreatedDate=" + newsCreatedDate + ", newsUpdatedDate=" + newsUpdatedDate + "]";
	}
    
    
}
