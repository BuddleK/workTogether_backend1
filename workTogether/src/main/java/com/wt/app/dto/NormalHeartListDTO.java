package com.wt.app.dto;

import java.util.List;

public class NormalHeartListDTO {
	//돌봄 유저 테이블
	private int careNumber; // 돌봄 유저 번호
//	private List<T> profilesFilesNumber; // 프로필 파일 번호

	//전체 유저 테이블
	private String userName; // 전체 유저 번호

	//요일 테이블
	private char dayMonday;
	private char dayTuesday;
	private char dayWednesday;
	private char dayThursday;
	private char dayFriday;
	private char daySaturday;
	private char daySunday;

	//돌봄 유저 테이블
	private String careIntroText; //

	public int getCareNumber() {
		return careNumber;
	}

	public void setCareNumber(int careNumber) {
		this.careNumber = careNumber;
	}

//	public List<T> getProfilesFilesNumber() {
//		return profilesFilesNumber;
//	}
//
//	public void setProfilesFilesNumber(List<T> profilesFilesNumber) {
//		this.profilesFilesNumber = profilesFilesNumber;
//	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public String getCareIntroText() {
		return careIntroText;
	}

	public void setCareIntroText(String careIntroText) {
		this.careIntroText = careIntroText;
	}

	@Override
	public String toString() {
		return "NormalHeartListDTO [careNumber=" + careNumber + ", profilesFilesNumber=" + profilesFilesNumber
				+ ", userName=" + userName + ", dayMonday=" + dayMonday + ", dayTuesday=" + dayTuesday
				+ ", dayWednesday=" + dayWednesday + ", dayThursday=" + dayThursday + ", dayFriday=" + dayFriday
				+ ", daySaturday=" + daySaturday + ", daySunday=" + daySunday + ", careIntroText=" + careIntroText
				+ "]";
	}

}
