package com.wt.app.dto;

public class CareListDTO {
//	-- 회원
	private int usersNumber;
	private char usersType;
	private String usersId;
	private String usersName;
	private String usersAddressLine1;
//	-- 돌봄 회원
	private int careNumber;
	private String careIntroText;
	private String careProfilesPhotoNumber;

//	날짜
	private char dayMonday;
	private char dayTuesday;
	private char dayWednesday;
	private char dayThursday;
	private char dayFriday;
	private char daySaturday;
	private char daySunday;

//		-- 파일 프로필
	private String profilesFilesType;
	private String profilesFilesName;
	private String profilesFilesPath;
//		-- 하트
	private int heartsNormalNumber;
	private int heartsCareNumber;
	
//		--쪽지(단방향 시작)
	private int messageNumber;
	private String messageContent;
	public int getUsersNumber() {
		return usersNumber;
	}
	public void setUsersNumber(int usersNumber) {
		this.usersNumber = usersNumber;
	}
	public char getUsersType() {
		return usersType;
	}
	public void setUsersType(char usersType) {
		this.usersType = usersType;
	}
	public String getUsersId() {
		return usersId;
	}
	public void setUsersId(String usersId) {
		this.usersId = usersId;
	}
	public String getUsersName() {
		return usersName;
	}
	public void setUsersName(String usersName) {
		this.usersName = usersName;
	}
	public String getUsersAddressLine1() {
		return usersAddressLine1;
	}
	public void setUsersAddressLine1(String usersAddressLine1) {
		this.usersAddressLine1 = usersAddressLine1;
	}
	public int getCareNumber() {
		return careNumber;
	}
	public void setCareNumber(int careNumber) {
		this.careNumber = careNumber;
	}
	public String getCareIntroText() {
		return careIntroText;
	}
	public void setCareIntroText(String careIntroText) {
		this.careIntroText = careIntroText;
	}
	public String getCareProfilesPhotoNumber() {
		return careProfilesPhotoNumber;
	}
	public void setCareProfilesPhotoNumber(String careProfilesPhotoNumber) {
		this.careProfilesPhotoNumber = careProfilesPhotoNumber;
	}
	public char getDayMonday() {
		return dayMonday;
	}
	public void setDayMonday(char dayMonday) {
		this.dayMonday = dayMonday;
	}
	public char getDayTuesday() {
		return dayTuesday;
	}
	public void setDayTuesday(char dayTuesday) {
		this.dayTuesday = dayTuesday;
	}
	public char getDayWednesday() {
		return dayWednesday;
	}
	public void setDayWednesday(char dayWednesday) {
		this.dayWednesday = dayWednesday;
	}
	public char getDayThursday() {
		return dayThursday;
	}
	public void setDayThursday(char dayThursday) {
		this.dayThursday = dayThursday;
	}
	public char getDayFriday() {
		return dayFriday;
	}
	public void setDayFriday(char dayFriday) {
		this.dayFriday = dayFriday;
	}
	public char getDaySaturday() {
		return daySaturday;
	}
	public void setDaySaturday(char daySaturday) {
		this.daySaturday = daySaturday;
	}
	public char getDaySunday() {
		return daySunday;
	}
	public void setDaySunday(char daySunday) {
		this.daySunday = daySunday;
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
	public int getHeartsNormalNumber() {
		return heartsNormalNumber;
	}
	public void setHeartsNormalNumber(int heartsNormalNumber) {
		this.heartsNormalNumber = heartsNormalNumber;
	}
	public int getHeartsCareNumber() {
		return heartsCareNumber;
	}
	public void setHeartsCareNumber(int heartsCareNumber) {
		this.heartsCareNumber = heartsCareNumber;
	}
	public int getMessageNumber() {
		return messageNumber;
	}
	public void setMessageNumber(int messageNumber) {
		this.messageNumber = messageNumber;
	}
	public String getMessageContent() {
		return messageContent;
	}
	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}
	@Override
	public String toString() {
		return "CareListDTO [usersNumber=" + usersNumber + ", usersType=" + usersType + ", usersId=" + usersId
				+ ", usersName=" + usersName + ", usersAddressLine1=" + usersAddressLine1 + ", careNumber=" + careNumber
				+ ", careIntroText=" + careIntroText + ", careProfilesPhotoNumber=" + careProfilesPhotoNumber
				+ ", dayMonday=" + dayMonday + ", dayTuesday=" + dayTuesday + ", dayWednesday=" + dayWednesday
				+ ", dayThursday=" + dayThursday + ", dayFriday=" + dayFriday + ", daySaturday=" + daySaturday
				+ ", daySunday=" + daySunday + ", profilesFilesType=" + profilesFilesType + ", profilesFilesName="
				+ profilesFilesName + ", profilesFilesPath=" + profilesFilesPath + ", heartsNormalNumber="
				+ heartsNormalNumber + ", heartsCareNumber=" + heartsCareNumber + ", messageNumber=" + messageNumber
				+ ", messageContent=" + messageContent + "]";
	}
	
	
	

	

	
	
	
	

	
	
}
