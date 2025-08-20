package com.wt.app.dto;

public class NewsMainDTO {

//	배너 뉴스 번호
//	배너 뉴스 제목
//	배너 뉴스 내용
//	배너 뉴스 링크
//	배너 뉴스 이미지 경로
	
	private int bannerNewsNumber;
	private String bannerTitle;
	private String bannerContent;
	private String bannerLinkUrl;
	private String banner_files_path;
	public int getBannerNewsNumber() {
		return bannerNewsNumber;
	}
	public void setBannerNewsNumber(int bannerNewsNumber) {
		this.bannerNewsNumber = bannerNewsNumber;
	}
	public String getBannerTitle() {
		return bannerTitle;
	}
	public void setBannerTitle(String bannerTitle) {
		this.bannerTitle = bannerTitle;
	}
	public String getBannerContent() {
		return bannerContent;
	}
	public void setBannerContent(String bannerContent) {
		this.bannerContent = bannerContent;
	}
	public String getBannerLinkUrl() {
		return bannerLinkUrl;
	}
	public void setBannerLinkUrl(String bannerLinkUrl) {
		this.bannerLinkUrl = bannerLinkUrl;
	}
	public String getBanner_files_path() {
		return banner_files_path;
	}
	public void setBanner_files_path(String banner_files_path) {
		this.banner_files_path = banner_files_path;
	}
	@Override
	public String toString() {
		return "NewsMainDTO [bannerNewsNumber=" + bannerNewsNumber + ", bannerTitle=" + bannerTitle + ", bannerContent="
				+ bannerContent + ", bannerLinkUrl=" + bannerLinkUrl + ", banner_files_path=" + banner_files_path + "]";
	}
	
}
