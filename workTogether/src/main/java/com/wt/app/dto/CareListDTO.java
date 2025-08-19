package com.wt.app.dto;

public class CareListDTO {
//	-- 회원
	private int users_number;
	private char users_type;
	private String users_id;
	private String users_name;
	private String users_address_line1;
//	-- 돌봄 회원
	private int care_number;
	private String care_intro_text;
	private String care_profiles_photo_number;

//	날짜
	private char day_monday;
	private char day_tuesday;
	private char day_wednesday;
	private char day_thursday;
	private char day_friday;
	private char day_saturday;
	private char day_sunday;

//		-- 파일 프로필
	private String profiles_files_type;
	private String profiles_files_name;
	private String profiles_files_path;
//		-- 하트
	private int hearts_normal_number;
	private int hearts_care_number;
	public int getUsers_number() {
		return users_number;
	}
	public void setUsers_number(int users_number) {
		this.users_number = users_number;
	}
	public char getUsers_type() {
		return users_type;
	}
	public void setUsers_type(char users_type) {
		this.users_type = users_type;
	}
	public String getUsers_id() {
		return users_id;
	}
	public void setUsers_id(String users_id) {
		this.users_id = users_id;
	}
	public String getUsers_name() {
		return users_name;
	}
	public void setUsers_name(String users_name) {
		this.users_name = users_name;
	}
	public String getUsers_address_line1() {
		return users_address_line1;
	}
	public void setUsers_address_line1(String users_address_line1) {
		this.users_address_line1 = users_address_line1;
	}
	public int getCare_number() {
		return care_number;
	}
	public void setCare_number(int care_number) {
		this.care_number = care_number;
	}
	public String getCare_intro_text() {
		return care_intro_text;
	}
	public void setCare_intro_text(String care_intro_text) {
		this.care_intro_text = care_intro_text;
	}
	public String getCare_profiles_photo_number() {
		return care_profiles_photo_number;
	}
	public void setCare_profiles_photo_number(String care_profiles_photo_number) {
		this.care_profiles_photo_number = care_profiles_photo_number;
	}
	public char getDay_monday() {
		return day_monday;
	}
	public void setDay_monday(char day_monday) {
		this.day_monday = day_monday;
	}
	public char getDay_tuesday() {
		return day_tuesday;
	}
	public void setDay_tuesday(char day_tuesday) {
		this.day_tuesday = day_tuesday;
	}
	public char getDay_wednesday() {
		return day_wednesday;
	}
	public void setDay_wednesday(char day_wednesday) {
		this.day_wednesday = day_wednesday;
	}
	public char getDay_thursday() {
		return day_thursday;
	}
	public void setDay_thursday(char day_thursday) {
		this.day_thursday = day_thursday;
	}
	public char getDay_friday() {
		return day_friday;
	}
	public void setDay_friday(char day_friday) {
		this.day_friday = day_friday;
	}
	public char getDay_saturday() {
		return day_saturday;
	}
	public void setDay_saturday(char day_saturday) {
		this.day_saturday = day_saturday;
	}
	public char getDay_sunday() {
		return day_sunday;
	}
	public void setDay_sunday(char day_sunday) {
		this.day_sunday = day_sunday;
	}
	public String getProfiles_files_type() {
		return profiles_files_type;
	}
	public void setProfiles_files_type(String profiles_files_type) {
		this.profiles_files_type = profiles_files_type;
	}
	public String getProfiles_files_name() {
		return profiles_files_name;
	}
	public void setProfiles_files_name(String profiles_files_name) {
		this.profiles_files_name = profiles_files_name;
	}
	public String getProfiles_files_path() {
		return profiles_files_path;
	}
	public void setProfiles_files_path(String profiles_files_path) {
		this.profiles_files_path = profiles_files_path;
	}
	public int getHearts_normal_number() {
		return hearts_normal_number;
	}
	public void setHearts_normal_number(int hearts_normal_number) {
		this.hearts_normal_number = hearts_normal_number;
	}
	public int getHearts_care_number() {
		return hearts_care_number;
	}
	public void setHearts_care_number(int hearts_care_number) {
		this.hearts_care_number = hearts_care_number;
	}
	@Override
	public String toString() {
		return "CareListDTO [users_number=" + users_number + ", users_type=" + users_type + ", users_id=" + users_id
				+ ", users_name=" + users_name + ", users_address_line1=" + users_address_line1 + ", care_number="
				+ care_number + ", care_intro_text=" + care_intro_text + ", care_profiles_photo_number="
				+ care_profiles_photo_number + ", day_monday=" + day_monday + ", day_tuesday=" + day_tuesday
				+ ", day_wednesday=" + day_wednesday + ", day_thursday=" + day_thursday + ", day_friday=" + day_friday
				+ ", day_saturday=" + day_saturday + ", day_sunday=" + day_sunday + ", profiles_files_type="
				+ profiles_files_type + ", profiles_files_name=" + profiles_files_name + ", profiles_files_path="
				+ profiles_files_path + ", hearts_normal_number=" + hearts_normal_number + ", hearts_care_number="
				+ hearts_care_number + "]";
	}

	
	
}
