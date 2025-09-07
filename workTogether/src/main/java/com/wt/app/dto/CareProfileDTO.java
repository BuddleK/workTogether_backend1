package com.wt.app.dto;

import java.util.List;

public class CareProfileDTO {

	// 회원 번호
	// 요일 정보
	// 프로필 사진 파일 형식
	// 프로필 사진 파일 명
	// 프로필 사진 경로
	// 자격증 파일 형식
	// 자격증 파일 명
	// 자격증 경로
	// 계좌 사본 파일 형식
	// 계좌 사본 파일 명
	// 계좌 사본 경로
	// 우편번호
	// 주소
	// 상세 주소
	// 소개글
	
	private int usersNumber;
	
	private String dayMonday;
	private String dayTuesday;
	private String dayWednesday;
	private String dayThursday;
	private String dayFriday;
	private String daySaturday;
	private String daySunday;
	
	private String profilesFilesType;
	private String profilesFilesName;
	private String profilesFilesPath;
	private String profilesFilesSizeBytes;

	private String licenseFilesType;
	private String licenseFilesName;
	private String licenseFilesPath;
	private String licenseFilesSizeBytes;
	
	private String accountFilesType;
	private String accountFilesName;
	private String accountFilesPath;
	private String accountFilesSizeBytes;
	
	private String usersPostsalCode;
	private String usersAddressLine1;
	private String usersAddressLine2;
	
	private String careIntroText;

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

	public String getProfilesFilesSizeBytes() {
		return profilesFilesSizeBytes;
	}

	public void setProfilesFilesSizeBytes(String profilesFilesSizeBytes) {
		this.profilesFilesSizeBytes = profilesFilesSizeBytes;
	}

	public String getLicenseFilesType() {
		return licenseFilesType;
	}

	public void setLicenseFilesType(String licenseFilesType) {
		this.licenseFilesType = licenseFilesType;
	}

	public String getLicenseFilesName() {
		return licenseFilesName;
	}

	public void setLicenseFilesName(String licenseFilesName) {
		this.licenseFilesName = licenseFilesName;
	}

	public String getLicenseFilesPath() {
		return licenseFilesPath;
	}

	public void setLicenseFilesPath(String licenseFilesPath) {
		this.licenseFilesPath = licenseFilesPath;
	}

	public String getLicenseFilesSizeBytes() {
		return licenseFilesSizeBytes;
	}

	public void setLicenseFilesSizeBytes(String licenseFilesSizeBytes) {
		this.licenseFilesSizeBytes = licenseFilesSizeBytes;
	}

	public String getAccountFilesType() {
		return accountFilesType;
	}

	public void setAccountFilesType(String accountFilesType) {
		this.accountFilesType = accountFilesType;
	}

	public String getAccountFilesName() {
		return accountFilesName;
	}

	public void setAccountFilesName(String accountFilesName) {
		this.accountFilesName = accountFilesName;
	}

	public String getAccountFilesPath() {
		return accountFilesPath;
	}

	public void setAccountFilesPath(String accountFilesPath) {
		this.accountFilesPath = accountFilesPath;
	}

	public String getAccountFilesSizeBytes() {
		return accountFilesSizeBytes;
	}

	public void setAccountFilesSizeBytes(String accountFilesSizeBytes) {
		this.accountFilesSizeBytes = accountFilesSizeBytes;
	}

	public String getUsersPostsalCode() {
		return usersPostsalCode;
	}

	public void setUsersPostsalCode(String usersPostsalCode) {
		this.usersPostsalCode = usersPostsalCode;
	}

	public String getUsersAddressLine1() {
		return usersAddressLine1;
	}

	public void setUsersAddressLine1(String usersAddressLine1) {
		this.usersAddressLine1 = usersAddressLine1;
	}

	public String getUsersAddressLine2() {
		return usersAddressLine2;
	}

	public void setUsersAddressLine2(String usersAddressLine2) {
		this.usersAddressLine2 = usersAddressLine2;
	}

	public String getCareIntroText() {
		return careIntroText;
	}

	public void setCareIntroText(String careIntroText) {
		this.careIntroText = careIntroText;
	}

	@Override
	public String toString() {
		return "CareProfileDTO [usersNumber=" + usersNumber + ", dayMonday=" + dayMonday + ", dayTuesday=" + dayTuesday
				+ ", dayWednesday=" + dayWednesday + ", dayThursday=" + dayThursday + ", dayFriday=" + dayFriday
				+ ", daySaturday=" + daySaturday + ", daySunday=" + daySunday + ", profilesFilesType="
				+ profilesFilesType + ", profilesFilesName=" + profilesFilesName + ", profilesFilesPath="
				+ profilesFilesPath + ", profilesFilesSizeBytes=" + profilesFilesSizeBytes + ", licenseFilesType="
				+ licenseFilesType + ", licenseFilesName=" + licenseFilesName + ", licenseFilesPath=" + licenseFilesPath
				+ ", licenseFilesSizeBytes=" + licenseFilesSizeBytes + ", accountFilesType=" + accountFilesType
				+ ", accountFilesName=" + accountFilesName + ", accountFilesPath=" + accountFilesPath
				+ ", accountFilesSizeBytes=" + accountFilesSizeBytes + ", usersPostsalCode=" + usersPostsalCode
				+ ", usersAddressLine1=" + usersAddressLine1 + ", usersAddressLine2=" + usersAddressLine2
				+ ", careIntroText=" + careIntroText + "]";
	}
}
