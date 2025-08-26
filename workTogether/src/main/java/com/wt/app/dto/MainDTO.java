package com.wt.app.dto;

public class MainDTO {

	private int bannerNewsNumber;
	private int bannerImageFilesNumber;
	private String bannerTitle;
	private String bannerContent;
	private String bannerLinkUrl;
	private String bannerFilesPath;
	private String bannerFilesType;
	
	private int postsNumber;
	private String postsTitle;
	private int usersNumber;
	private String usersName;
	private String postsCreatedDate;
	
	
	private int careNumber;
	private int careProfilesPhotoNumber;
	private String careIntroText;
	private int profilesFilesNumber;
	private String profilesFilesPath;
	private int heartsCareNumber;
	private String dayMonday;
	private String dayTuesday;
	private String dayWednesday;
	private String dayThursday;
	private String dayFriday;
	private String daySaturday;
	private String daySunday;
	
	private int favoritesDhopsNumber;
	private String shopsName;
	private int shopsNumber;
	
	//지도 api
	
	public int getBannerNewsNumber() {
		return bannerNewsNumber;
	}
	public void setBannerNewsNumber(int bannerNewsNumber) {
		this.bannerNewsNumber = bannerNewsNumber;
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
	public String getBannerFilesPath() {
		return bannerFilesPath;
	}
	public void setBannerFilesPath(String bannerFilesPath) {
		this.bannerFilesPath = bannerFilesPath;
	}
	public String getBannerFilesType() {
		return bannerFilesType;
	}
	public void setBannerFilesType(String bannerFilesType) {
		this.bannerFilesType = bannerFilesType;
	}
	public int getPostsNumber() {
		return postsNumber;
	}
	public void setPostsNumber(int postsNumber) {
		this.postsNumber = postsNumber;
	}
	public String getPostsTitle() {
		return postsTitle;
	}
	public void setPostsTitle(String postsTitle) {
		this.postsTitle = postsTitle;
	}
	public int getUsersNumber() {
		return usersNumber;
	}
	public void setUsersNumber(int usersNumber) {
		this.usersNumber = usersNumber;
	}
	public String getUsersName() {
		return usersName;
	}
	public void setUsersName(String usersName) {
		this.usersName = usersName;
	}
	public String getPostsCreatedDate() {
		return postsCreatedDate;
	}
	public void setPostsCreatedDate(String postsCreatedDate) {
		this.postsCreatedDate = postsCreatedDate;
	}
	public int getCareNumber() {
		return careNumber;
	}
	public void setCareNumber(int careNumber) {
		this.careNumber = careNumber;
	}
	public int getCareProfilesPhotoNumber() {
		return careProfilesPhotoNumber;
	}
	public void setCareProfilesPhotoNumber(int careProfilesPhotoNumber) {
		this.careProfilesPhotoNumber = careProfilesPhotoNumber;
	}
	public String getCareIntroText() {
		return careIntroText;
	}
	public void setCareIntroText(String careIntroText) {
		this.careIntroText = careIntroText;
	}
	public int getProfilesFilesNumber() {
		return profilesFilesNumber;
	}
	public void setProfilesFilesNumber(int profilesFilesNumber) {
		this.profilesFilesNumber = profilesFilesNumber;
	}
	public String getProfilesFilesPath() {
		return profilesFilesPath;
	}
	public void setProfilesFilesPath(String profilesFilesPath) {
		this.profilesFilesPath = profilesFilesPath;
	}
	public int getHeartsCareNumber() {
		return heartsCareNumber;
	}
	public void setHeartsCareNumber(int heartsCareNumber) {
		this.heartsCareNumber = heartsCareNumber;
	}
	public String getDayMonday() {
		return dayMonday;
	}
	public void setDayMonday(String dayMonday) {
		this.dayMonday = dayMonday;
	}
	public String getDayTuesday() {
		return dayTuesday;
	}
	public void setDayTuesday(String dayTuesday) {
		this.dayTuesday = dayTuesday;
	}
	public String getDayWednesday() {
		return dayWednesday;
	}
	public void setDayWednesday(String dayWednesday) {
		this.dayWednesday = dayWednesday;
	}
	public String getDayThursday() {
		return dayThursday;
	}
	public void setDayThursday(String dayThursday) {
		this.dayThursday = dayThursday;
	}
	public String getDayFriday() {
		return dayFriday;
	}
	public void setDayFriday(String dayFriday) {
		this.dayFriday = dayFriday;
	}
	public String getDaySaturday() {
		return daySaturday;
	}
	public void setDaySaturday(String daySaturday) {
		this.daySaturday = daySaturday;
	}
	public String getDaySunday() {
		return daySunday;
	}
	public void setDaySunday(String daySunday) {
		this.daySunday = daySunday;
	}
	public int getFavoritesDhopsNumber() {
		return favoritesDhopsNumber;
	}
	public void setFavoritesDhopsNumber(int favoritesDhopsNumber) {
		this.favoritesDhopsNumber = favoritesDhopsNumber;
	}
	public String getShopsName() {
		return shopsName;
	}
	public void setShopsName(String shopsName) {
		this.shopsName = shopsName;
	}
	public int getShopsNumber() {
		return shopsNumber;
	}
	public void setShopsNumber(int shopsNumber) {
		this.shopsNumber = shopsNumber;
	}
	@Override
	public String toString() {
		return "MainDTO [bannerNewsNumber=" + bannerNewsNumber + ", banner_imageFilesNumber=" + bannerImageFilesNumber
				+ ", bannerTitle=" + bannerTitle + ", bannerContent=" + bannerContent + ", bannerLinkUrl="
				+ bannerLinkUrl + ", bannerFilesPath=" + bannerFilesPath + ", bannerFilesType=" + bannerFilesType
				+ ", postsNumber=" + postsNumber + ", postsTitle=" + postsTitle + ", usersNumber=" + usersNumber
				+ ", usersName=" + usersName + ", postsCreatedDate=" + postsCreatedDate + ", careNumber=" + careNumber
				+ ", careProfilesPhotoNumber=" + careProfilesPhotoNumber + ", careIntroText=" + careIntroText
				+ ", profilesFilesNumber=" + profilesFilesNumber + ", profilesFilesPath=" + profilesFilesPath
				+ ", heartsCareNumber=" + heartsCareNumber + ", dayMonday=" + dayMonday + ", dayTuesday=" + dayTuesday
				+ ", dayWednesday=" + dayWednesday + ", dayThursday=" + dayThursday + ", dayFriday=" + dayFriday
				+ ", daySaturday=" + daySaturday + ", daySunday=" + daySunday + ", favoritesDhopsNumber="
				+ favoritesDhopsNumber + ", shopsName=" + shopsName + ", shopsNumber=" + shopsNumber + "]";
	}
	
	
	
	

}
