package com.wt.app.dto;

import java.util.List;

public class NormalHeartListDTO {
	// 돌봄 유저 테이블
	private int careNumber; // 돌봄 유저 번호
	private String usersName; // 전체 유저 번호
	
	private int heartsNormalNumber;
	private String usersAddressLine1;
	private String careIntroText;
	private int careProfilesPhotoNumber;
	private String profilesFilesType;
	private String profilesFilesName;
	private String profilesFilesPath;
	private String dayMonday;
	private String dayTuesday;
	private String dayWednesday;
	private String dayThursday;
	private String dayFriday;
	private String daySaturday;
	private String daySunday;
	public int getCareNumber() {
		return careNumber;
	}
	public void setCareNumber(int careNumber) {
		this.careNumber = careNumber;
	}
	public String getUsersName() {
		return usersName;
	}
	public void setUsersName(String usersName) {
		this.usersName = usersName;
	}
	public int getHeartsNormalNumber() {
		return heartsNormalNumber;
	}
	public void setHeartsNormalNumber(int heartsNormalNumber) {
		this.heartsNormalNumber = heartsNormalNumber;
	}
	public String getUsersAddressLine1() {
		return usersAddressLine1;
	}
	public void setUsersAddressLine1(String usersAddressLine1) {
		this.usersAddressLine1 = usersAddressLine1;
	}
	public String getCareIntroText() {
		return careIntroText;
	}
	public void setCareIntroText(String careIntroText) {
		this.careIntroText = careIntroText;
	}
	public int getCareProfilesPhotoNumber() {
		return careProfilesPhotoNumber;
	}
	public void setCareProfilesPhotoNumber(int careProfilesPhotoNumber) {
		this.careProfilesPhotoNumber = careProfilesPhotoNumber;
	}
	public String getProfilesFilesType() {
		return profilesFilesType;
	}
	public void setProfilesFilesType(String profilesFilesType) {
		this.profilesFilesType = profilesFilesType;
	}
	public String getProfilesFilesName() {
		return profilesFilesName;
	}
	public void setProfilesFilesName(String profilesFilesName) {
		this.profilesFilesName = profilesFilesName;
	}
	public String getProfilesFilesPath() {
		return profilesFilesPath;
	}
	public void setProfilesFilesPath(String profilesFilesPath) {
		this.profilesFilesPath = profilesFilesPath;
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
	@Override
	public String toString() {
		return "NormalHeartListDTO [careNumber=" + careNumber + ", usersName=" + usersName + ", heartsNormalNumber="
				+ heartsNormalNumber + ", usersAddressLine1=" + usersAddressLine1 + ", careIntroText=" + careIntroText
				+ ", careProfilesPhotoNumber=" + careProfilesPhotoNumber + ", profilesFilesType=" + profilesFilesType
				+ ", profilesFilesName=" + profilesFilesName + ", profilesFilesPath=" + profilesFilesPath
				+ ", dayMonday=" + dayMonday + ", dayTuesday=" + dayTuesday + ", dayWednesday=" + dayWednesday
				+ ", dayThursday=" + dayThursday + ", dayFriday=" + dayFriday + ", daySaturday=" + daySaturday
				+ ", daySunday=" + daySunday + "]";
	}
	

	

}
