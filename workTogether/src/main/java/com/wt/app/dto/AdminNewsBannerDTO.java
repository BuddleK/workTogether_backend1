package com.wt.app.dto;

public class AdminNewsBannerDTO {
	private int bannerNewsNumber;
    private int adminNumber;
    private String bannerTitle;
    private String bannerLinkUrl;
    private String bannerCreatedDate;
    private String bannerUpdatedDate;
    private int bannerImageFilesNumber;
    private String bannerFilesName; 
    private String bannerFilesPath;
    private long bannerFilesSize;
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
	public String getBannerUpdatedDate() {
		return bannerUpdatedDate;
	}
	public void setBannerUpdatedDate(String bannerUpdatedDate) {
		this.bannerUpdatedDate = bannerUpdatedDate;
	}
	public int getBannerImageFilesNumber() {
		return bannerImageFilesNumber;
	}
	public void setBannerImageFilesNumber(int bannerImageFilesNumber) {
		this.bannerImageFilesNumber = bannerImageFilesNumber;
	}
	public String getBannerFilesName() {
		return bannerFilesName;
	}
	public void setBannerFilesName(String bannerFilesName) {
		this.bannerFilesName = bannerFilesName;
	}
	public String getBannerFilesPath() {
		return bannerFilesPath;
	}
	public void setBannerFilesPath(String bannerFilesPath) {
		this.bannerFilesPath = bannerFilesPath;
	}
	public long getBannerFilesSize() {
		return bannerFilesSize;
	}
	public void setBannerFilesSize(long bannerFilesSize) {
		this.bannerFilesSize = bannerFilesSize;
	}
	@Override
	public String toString() {
		return "AdminNewsBannerDTO [bannerNewsNumber=" + bannerNewsNumber + ", adminNumber=" + adminNumber
				+ ", bannerTitle=" + bannerTitle + ", bannerLinkUrl=" + bannerLinkUrl + ", bannerCreatedDate="
				+ bannerCreatedDate + ", bannerUpdatedDate=" + bannerUpdatedDate + ", bannerImageFilesNumber="
				+ bannerImageFilesNumber + ", bannerFilesName=" + bannerFilesName + ", bannerFilesPath="
				+ bannerFilesPath + ", bannerFilesSize=" + bannerFilesSize + "]";
	} 

	
}
