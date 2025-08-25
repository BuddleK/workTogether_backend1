package com.wt.app.dto;

public class MainDTO {

	private int banner_news_number;
	private int banner_image_files_number;
	private String banner_title;
	private String banner_content;
	private String banner_link_url;
	private String banner_files_path;
	private String banner_files_type;
	
	private int posts_number;
	private String posts_title;
	private int users_number;
	private String users_name;
	private String posts_created_date;
	
	
	private int care_number;
	private int care_profiles_photo_number;
	private String care_intro_text;
	private String usersName;
	private int profilesFilesNumber;
	private String profilesFilesPath;
	private int heartsCareNumber;
	private int usersNumber;
	private String dayMonday;
	private String dayTuesday;
	private String dayWednesday;
	private String dayThursday;
	private String dayFriday;
	private String daySaturday;
	private String daySunday;
	
	private int favorites_shops_number;
	private String shops_name;
	private int shopsNumber;
	
	//지도 api
	
	public int getBanner_news_number() {
		return banner_news_number;
	}
	public void setBanner_news_number(int banner_news_number) {
		this.banner_news_number = banner_news_number;
	}
	public int getBanner_image_files_number() {
		return banner_image_files_number;
	}
	public void setBanner_image_files_number(int banner_image_files_number) {
		this.banner_image_files_number = banner_image_files_number;
	}
	public String getBanner_title() {
		return banner_title;
	}
	public void setBanner_title(String banner_title) {
		this.banner_title = banner_title;
	}
	public String getBanner_content() {
		return banner_content;
	}
	public void setBanner_content(String banner_content) {
		this.banner_content = banner_content;
	}
	public String getBanner_link_url() {
		return banner_link_url;
	}
	public void setBanner_link_url(String banner_link_url) {
		this.banner_link_url = banner_link_url;
	}
	public String getBanner_files_path() {
		return banner_files_path;
	}
	public void setBanner_files_path(String banner_files_path) {
		this.banner_files_path = banner_files_path;
	}
	public String getBanner_files_type() {
		return banner_files_type;
	}
	public void setBanner_files_type(String banner_files_type) {
		this.banner_files_type = banner_files_type;
	}
	public int getPosts_number() {
		return posts_number;
	}
	public void setPosts_number(int posts_number) {
		this.posts_number = posts_number;
	}
	public String getPosts_title() {
		return posts_title;
	}
	public void setPosts_title(String posts_title) {
		this.posts_title = posts_title;
	}
	public int getUsers_number() {
		return users_number;
	}
	public void setUsers_number(int users_number) {
		this.users_number = users_number;
	}
	public String getUsers_name() {
		return users_name;
	}
	public void setUsers_name(String users_name) {
		this.users_name = users_name;
	}
	public String getPosts_created_date() {
		return posts_created_date;
	}
	public void setPosts_created_date(String posts_created_date) {
		this.posts_created_date = posts_created_date;
	}
	public int getCare_number() {
		return care_number;
	}
	public void setCare_number(int care_number) {
		this.care_number = care_number;
	}
	public int getCare_profiles_photo_number() {
		return care_profiles_photo_number;
	}
	public void setCare_profiles_photo_number(int care_profiles_photo_number) {
		this.care_profiles_photo_number = care_profiles_photo_number;
	}
	public String getCare_intro_text() {
		return care_intro_text;
	}
	public void setCare_intro_text(String care_intro_text) {
		this.care_intro_text = care_intro_text;
	}
	public String getUsersName() {
		return usersName;
	}
	public void setUsersName(String usersName) {
		this.usersName = usersName;
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
	public int getUsersNumber() {
		return usersNumber;
	}
	public void setUsersNumber(int usersNumber) {
		this.usersNumber = usersNumber;
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
	public int getFavorites_shops_number() {
		return favorites_shops_number;
	}
	public void setFavorites_shops_number(int favorites_shops_number) {
		this.favorites_shops_number = favorites_shops_number;
	}
	public String getShops_name() {
		return shops_name;
	}
	public void setShops_name(String shops_name) {
		this.shops_name = shops_name;
	}
	public int getShopsNumber() {
		return shopsNumber;
	}
	public void setShopsNumber(int shopsNumber) {
		this.shopsNumber = shopsNumber;
	}
	@Override
	public String toString() {
		return "MainDTO [banner_news_number=" + banner_news_number + ", banner_image_files_number="
				+ banner_image_files_number + ", banner_title=" + banner_title + ", banner_content=" + banner_content
				+ ", banner_link_url=" + banner_link_url + ", banner_files_path=" + banner_files_path
				+ ", banner_files_type=" + banner_files_type + ", posts_number=" + posts_number + ", posts_title="
				+ posts_title + ", users_number=" + users_number + ", users_name=" + users_name
				+ ", posts_created_date=" + posts_created_date + ", care_number=" + care_number
				+ ", care_profiles_photo_number=" + care_profiles_photo_number + ", care_intro_text=" + care_intro_text
				+ ", usersName=" + usersName + ", profilesFilesNumber=" + profilesFilesNumber + ", profilesFilesPath="
				+ profilesFilesPath + ", heartsCareNumber=" + heartsCareNumber + ", usersNumber=" + usersNumber
				+ ", dayMonday=" + dayMonday + ", dayTuesday=" + dayTuesday + ", dayWednesday=" + dayWednesday
				+ ", dayThursday=" + dayThursday + ", dayFriday=" + dayFriday + ", daySaturday=" + daySaturday
				+ ", daySunday=" + daySunday + ", favorites_shops_number=" + favorites_shops_number + ", shops_name="
				+ shops_name + ", shopsNumber=" + shopsNumber + "]";
	}
	

	
	

}
