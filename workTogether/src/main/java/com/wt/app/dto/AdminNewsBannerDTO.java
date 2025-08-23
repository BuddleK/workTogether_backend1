package com.wt.app.dto;

public class AdminNewsBannerDTO {
	// 뉴스 테이블
	private int newsNumber; // 뉴스 번호
	private String newsTitle; // 뉴스 제목
	private String newsCreatedDate; // 뉴스 생성일

	// 뉴스 베너 파일 테이블
	private int banner_files_number; // 베너 파일 번호

	public int getBanner_files_number() {
		return banner_files_number;
	}

	public void setBanner_files_number(int banner_files_number) {
		this.banner_files_number = banner_files_number;
	}

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

	public String getNewsCreatedDate() {
		return newsCreatedDate;
	}

	public void setNewsCreatedDate(String newsCreatedDate) {
		this.newsCreatedDate = newsCreatedDate;
	}

	@Override
	public String toString() {
		return "AdminNewsBannerDTO [newsNumber=" + newsNumber + ", newsTitle=" + newsTitle + ", newsCreatedDate="
				+ newsCreatedDate + ", banner_files_number=" + banner_files_number + "]";
	}
}
