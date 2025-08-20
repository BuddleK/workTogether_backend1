package com.wt.app.dto;

import java.util.List;

public class NormalHeartListDTO<T> {
	int careNumber;
	List<T> profilesFilesNumber;

	String userName;

	char dayMonday;
	char dayTuesday;
	char dayWednesday;
	char dayThursday;
	char dayFriday;
	char daySaturday;
	char daySunday;

	String careIntroText;

	public int getCareNumber() {
		return careNumber;
	}

	public void setCareNumber(int careNumber) {
		this.careNumber = careNumber;
	}

	public List<T> getProfilesFilesNumber() {
		return profilesFilesNumber;
	}

	public void setProfilesFilesNumber(List<T> profilesFilesNumber) {
		this.profilesFilesNumber = profilesFilesNumber;
	}

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
