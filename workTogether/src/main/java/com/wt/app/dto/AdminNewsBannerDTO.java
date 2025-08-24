package com.wt.app.dto;

public class AdminNewsBannerDTO {
	// 뉴스 테이블
	private int bannerNewsNumber; // 뉴스 번호
	private String bannerTitle; // 뉴스 제목
	private String bannerLinkUrl; // 뉴스링크
	private String bannerCreatedDate; // 뉴스 생성일

	private String bannerImageFilesNumber;

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

	public String getBannerImageFilesNumber() {
		return bannerImageFilesNumber;
	}

	public void setBannerImageFilesNumber(String bannerImageFilesNumber) {
		this.bannerImageFilesNumber = bannerImageFilesNumber;
	}

	@Override
	public String toString() {
		return "AdminNewsBannerDTO [bannerNewsNumber=" + bannerNewsNumber + ", bannerTitle=" + bannerTitle
				+ ", bannerLinkUrl=" + bannerLinkUrl + ", bannerCreatedDate=" + bannerCreatedDate
				+ ", bannerImageFilesNumber=" + bannerImageFilesNumber + "]";
	}

}
