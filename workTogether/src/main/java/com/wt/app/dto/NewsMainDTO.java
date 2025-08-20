package com.wt.app.dto;

public class NewsMainDTO {

	뉴스 번호
	뉴스 제목
	뉴스 링크
	뉴스 파일
	private int bannerNewsNumber;
	private int adminNumber;
	private int bannerImageFilesNumber;
	private String bannerTitle;
	private String bannerContent;
	private String bannerLinkUrl;
	private String bannerCreatedDate;
	private String bannerUpdatedDate;
	public int getBannerNewsNumber() {
		return bannerNewsNumber;
	}
	public void setBannerNewsNumber(int bannerNewsNumber) {
		this.bannerNewsNumber = bannerNewsNumber;
	}
	public int getAdminNumber() {
		return adminNumber;
	}
	public void setAdminNumber(int adminNumber) {
		this.adminNumber = adminNumber;
	}
	public int getBannerImageFilesNumber() {
		return bannerImageFilesNumber;
	}
	public void setBannerImageFilesNumber(int bannerImageFilesNumber) {
		this.bannerImageFilesNumber = bannerImageFilesNumber;
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
	public String getBannerCreatedDate() {
		return bannerCreatedDate;
	}
	public void setBannerCreatedDate(String bannerCreatedDate) {
		this.bannerCreatedDate = bannerCreatedDate;
	}
	public String getBannerUpdatedDate() {
		return bannerUpdatedDate;
	}
	public void setBannerUpdatedDate(String bannerUpdatedDate) {
		this.bannerUpdatedDate = bannerUpdatedDate;
	}
	@Override
	public String toString() {
		return "NewsBannerDTO [bannerNewsNumber=" + bannerNewsNumber + ", adminNumber=" + adminNumber
				+ ", bannerImageFilesNumber=" + bannerImageFilesNumber + ", bannerTitle=" + bannerTitle
				+ ", bannerContent=" + bannerContent + ", bannerLinkUrl=" + bannerLinkUrl + ", bannerCreatedDate="
				+ bannerCreatedDate + ", bannerUpdatedDate=" + bannerUpdatedDate + "]";
	}
}
