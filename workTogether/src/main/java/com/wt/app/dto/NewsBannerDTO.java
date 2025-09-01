package com.wt.app.dto;

public class NewsBannerDTO {
//	-- 뉴스 베너
//	CREATE TABLE tbl_news_banners (
//	    banner_news_number NUMBER PRIMARY KEY,
//	    admin_number NUMBER NOT NULL,
//	    banner_image_files_number NUMBER,
//	    banner_title VARCHAR2(300) NOT NULL,
//	    banner_content VARCHAR2(4000),
//	    banner_link_url VARCHAR2(1000) NOT NULL,
//	    banner_created_date DATE NOT NULL,
//	    banner_updated_date DATE,
//	    CONSTRAINT fk_banner_admin FOREIGN KEY (admin_number) REFERENCES tbl_admin(admin_number) ON DELETE CASCADE,
//	    CONSTRAINT fk_banner_image FOREIGN KEY (banner_image_files_number) REFERENCES tbl_files_banner(banner_files_number) ON DELETE CASCADE
//	);
	private int bannerNewsNumber;
	private int adminNumber;
	private int bannerImageFilesNumber;
	private String bannerTitle;
	private String bannerContent;
	private String bannerLinkUrl;
	private String bannerCreatedDate;
	private String bannerUpdatedDate;
	private String bannerFilesPath;
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
	public String getBannerFilesPath() {
		return bannerFilesPath;
	}
	public void setBannerFilesPath(String bannerFilesPath) {
		this.bannerFilesPath = bannerFilesPath;
	}
	@Override
	public String toString() {
		return "NewsBannerDTO [bannerNewsNumber=" + bannerNewsNumber + ", adminNumber=" + adminNumber
				+ ", bannerImageFilesNumber=" + bannerImageFilesNumber + ", bannerTitle=" + bannerTitle
				+ ", bannerContent=" + bannerContent + ", bannerLinkUrl=" + bannerLinkUrl + ", bannerCreatedDate="
				+ bannerCreatedDate + ", bannerUpdatedDate=" + bannerUpdatedDate + ", bannerFilesPath="
				+ bannerFilesPath + "]";
	}
	
}
