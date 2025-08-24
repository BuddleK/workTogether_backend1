package com.wt.app.dto;

public class CareProfileDTO {

//	-- 파일 프로필
//	CREATE TABLE tbl_files_profiles (
//	    profiles_files_number NUMBER PRIMARY KEY,
//	    profiles_files_type VARCHAR2(30) NOT NULL,
//	    profiles_files_name VARCHAR2(255) NOT NULL,
//	    profiles_files_path VARCHAR2(1000) NOT NULL,
//	    profiles_files_size_bytes NUMBER,
//	    profiles_created_date DATE NOT NULL
//	);
//	
//	-- 파일 자격증
//CREATE TABLE tbl_files_license (
//    license_files_number NUMBER PRIMARY KEY,
//    license_files_type VARCHAR2(30) NOT NULL,
//    license_files_name VARCHAR2(255) NOT NULL,
//    license_files_path VARCHAR2(1000) NOT NULL,
//    license_files_size_bytes NUMBER,
//    license_created_date DATE NOT NULL
//);

//	-- 파일 통장 사본
//	CREATE TABLE tbl_files_account (
//	    account_files_number NUMBER PRIMARY KEY,
//	    account_files_type VARCHAR2(30) NOT NULL,
//	    account_files_name VARCHAR2(255) NOT NULL,
//	    account_files_path VARCHAR2(1000) NOT NULL,
//	    account_files_size_bytes NUMBER,
//	    account_created_date DATE NOT NULL
//	)

//	-- 돌봄 회원
//	care_number NUMBER,
//    users_name VARCHAR2(50) NOT NULL,
//    users_email VARCHAR2(255) NOT NULL UNIQUE,
//    users_phone VARCHAR2(30) NOT NULL,
//    users_postsal_code VARCHAR2(10) NOT NULL,
//    users_address_line1 VARCHAR2(255) NOT NULL,
//    users_address_line2 VARCHAR2(255) NOT NULL,
//    care_intro_text VARCHAR2(150),
//    care_certificate_files_num NUMBER NOT NULL,
//    care_passbook_files_num NUMBER NOT NULL,
//    care_profiles_photo_number NUMBER,
//    care_accept CHAR(1) DEFAULT 'N' CHECK (care_accept IN ('Y', 'N')),
//    users_number NUMBER NOT NULL UNIQUE,

//	-- 회원
//	CREATE TABLE tbl_users (
//	    users_number NUMBER,
//	    users_id VARCHAR2(30) NOT NULL UNIQUE,
//	    users_password VARCHAR2(255) NOT NULL,
//	    users_type CHAR(1) CHECK (users_type IN ('C', 'N')) NOT NULL,
//	    users_created_date DATE DEFAULT sysdate,
//	    users_updated_date DATE DEFAULT sysdate,
//	    users_point number default 0,
//	    CONSTRAINT pk_tbl_users PRIMARY KEY (users_number)
//	);
	
//	-- 날짜
//	CREATE TABLE tbl_day (
//	    care_number NUMBER PRIMARY KEY,
//	    day_monday CHAR(1) DEFAULT 'N' CHECK (day_monday IN ('Y', 'N')),
//	    day_tuesday CHAR(1) DEFAULT 'N' CHECK (day_tuesday IN ('Y', 'N')),
//	    day_wednesday CHAR(1) DEFAULT 'N' CHECK (day_wednesday IN ('Y', 'N')),
//	    day_thursday CHAR(1) DEFAULT 'N' CHECK (day_thursday IN ('Y', 'N')),
//	    day_friday CHAR(1) DEFAULT 'N' CHECK (day_friday IN ('Y', 'N')),
//	    day_saturday CHAR(1) DEFAULT 'N' CHECK (day_saturday IN ('Y', 'N')),
//	    day_sunday CHAR(1) DEFAULT 'N' CHECK (day_sunday IN ('Y', 'N')),
//	    CONSTRAINT fk_day_care FOREIGN KEY (care_number) REFERENCES tbl_care_users(care_number) ON DELETE CASCADE
//	);

	private int profilesFilesNumber;
	private String profilesFilesType;
	private String profilesFilesName;
	private String profilesFilesPath;
	private int profilesFilesSizeBytes;
	private String profilesCreatedDate;

	private int careNumber;
	private char dayMonday;
	private char dayTuesday;
	private char dayWednesday;
	private char dayThursday;
	private char dayFriday;
	private char daySaturday;
	private char daySunday;

	private int licenseFilesNumber;
	private String licenseFilesType;
	private String licenseFilesName;
	private String licenseFilesPath;
	private int licenseFilesSizeBytes;
	private String licenseCreatedDate;

	private int accountFilesNumber;
	private String accountFilesType;
	private String accountFilesName;
	private String accountFilesPath;
	private int accountFilesSizeBytes;
	private String accountCreatedDate;

	private int usersNumber;
	private String usersPostsalCode;
	private String usersAddressLine1;
	private String usersAddressLine2;
	private String careIntroText;
	private char careAccept; // DEFAULT 'N' CHECK (care_accept IN ('Y', 'N')),

	public int getProfilesFilesNumber() {
		return profilesFilesNumber;
	}

	public void setProfilesFilesNumber(int profilesFilesNumber) {
		this.profilesFilesNumber = profilesFilesNumber;
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

	public int getProfilesFilesSizeBytes() {
		return profilesFilesSizeBytes;
	}

	public void setProfilesFilesSizeBytes(int profilesFilesSizeBytes) {
		this.profilesFilesSizeBytes = profilesFilesSizeBytes;
	}

	public String getProfilesCreatedDate() {
		return profilesCreatedDate;
	}

	public void setProfilesCreatedDate(String profilesCreatedDate) {
		this.profilesCreatedDate = profilesCreatedDate;
	}

	public int getCareNumber() {
		return careNumber;
	}

	public void setCareNumber(int careNumber) {
		this.careNumber = careNumber;
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

	public int getLicenseFilesNumber() {
		return licenseFilesNumber;
	}

	public void setLicenseFilesNumber(int licenseFilesNumber) {
		this.licenseFilesNumber = licenseFilesNumber;
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

	public int getLicenseFilesSizeBytes() {
		return licenseFilesSizeBytes;
	}

	public void setLicenseFilesSizeBytes(int licenseFilesSizeBytes) {
		this.licenseFilesSizeBytes = licenseFilesSizeBytes;
	}

	public String getLicenseCreatedDate() {
		return licenseCreatedDate;
	}

	public void setLicenseCreatedDate(String licenseCreatedDate) {
		this.licenseCreatedDate = licenseCreatedDate;
	}

	public int getAccountFilesNumber() {
		return accountFilesNumber;
	}

	public void setAccountFilesNumber(int accountFilesNumber) {
		this.accountFilesNumber = accountFilesNumber;
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

	public int getAccountFilesSizeBytes() {
		return accountFilesSizeBytes;
	}

	public void setAccountFilesSizeBytes(int accountFilesSizeBytes) {
		this.accountFilesSizeBytes = accountFilesSizeBytes;
	}

	public String getAccountCreatedDate() {
		return accountCreatedDate;
	}

	public void setAccountCreatedDate(String accountCreatedDate) {
		this.accountCreatedDate = accountCreatedDate;
	}

	public int getUsersNumber() {
		return usersNumber;
	}

	public void setUsersNumber(int usersNumber) {
		this.usersNumber = usersNumber;
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

	public char getCareAccept() {
		return careAccept;
	}

	public void setCareAccept(char careAccept) {
		this.careAccept = careAccept;
	}

	@Override
	public String toString() {
		return "CareProfileDTO [profilesFilesNumber=" + profilesFilesNumber + ", profilesFilesType=" + profilesFilesType
				+ ", profilesFilesName=" + profilesFilesName + ", profilesFilesPath=" + profilesFilesPath
				+ ", profilesFilesSizeBytes=" + profilesFilesSizeBytes + ", profilesCreatedDate=" + profilesCreatedDate
				+ ", careNumber=" + careNumber + ", dayMonday=" + dayMonday + ", dayTuesday=" + dayTuesday
				+ ", dayWednesday=" + dayWednesday + ", dayThursday=" + dayThursday + ", dayFriday=" + dayFriday
				+ ", daySaturday=" + daySaturday + ", daySunday=" + daySunday + ", licenseFilesNumber="
				+ licenseFilesNumber + ", licenseFilesType=" + licenseFilesType + ", licenseFilesName="
				+ licenseFilesName + ", licenseFilesPath=" + licenseFilesPath + ", licenseFilesSizeBytes="
				+ licenseFilesSizeBytes + ", licenseCreatedDate=" + licenseCreatedDate + ", accountFilesNumber="
				+ accountFilesNumber + ", accountFilesType=" + accountFilesType + ", accountFilesName="
				+ accountFilesName + ", accountFilesPath=" + accountFilesPath + ", accountFilesSizeBytes="
				+ accountFilesSizeBytes + ", accountCreatedDate=" + accountCreatedDate + ", usersNumber=" + usersNumber
				+ ", usersPostsalCode=" + usersPostsalCode + ", usersAddressLine1=" + usersAddressLine1
				+ ", usersAddressLine2=" + usersAddressLine2 + ", careIntroText=" + careIntroText + ", careAccept="
				+ careAccept + ", getProfilesFilesNumber()=" + getProfilesFilesNumber() + ", getProfilesFilesType()="
				+ getProfilesFilesType() + ", getProfilesFilesName()=" + getProfilesFilesName()
				+ ", getProfilesFilesPath()=" + getProfilesFilesPath() + ", getProfilesFilesSizeBytes()="
				+ getProfilesFilesSizeBytes() + ", getProfilesCreatedDate()=" + getProfilesCreatedDate()
				+ ", getCareNumber()=" + getCareNumber() + ", getDayMonday()=" + getDayMonday() + ", getDayTuesday()="
				+ getDayTuesday() + ", getDayWednesday()=" + getDayWednesday() + ", getDayThursday()="
				+ getDayThursday() + ", getDayFriday()=" + getDayFriday() + ", getDaySaturday()=" + getDaySaturday()
				+ ", getDaySunday()=" + getDaySunday() + ", getLicenseFilesNumber()=" + getLicenseFilesNumber()
				+ ", getLicenseFilesType()=" + getLicenseFilesType() + ", getLicenseFilesName()="
				+ getLicenseFilesName() + ", getLicenseFilesPath()=" + getLicenseFilesPath()
				+ ", getLicenseFilesSizeBytes()=" + getLicenseFilesSizeBytes() + ", getLicenseCreatedDate()="
				+ getLicenseCreatedDate() + ", getAccountFilesNumber()=" + getAccountFilesNumber()
				+ ", getAccountFilesType()=" + getAccountFilesType() + ", getAccountFilesName()="
				+ getAccountFilesName() + ", getAccountFilesPath()=" + getAccountFilesPath()
				+ ", getAccountFilesSizeBytes()=" + getAccountFilesSizeBytes() + ", getAccountCreatedDate()="
				+ getAccountCreatedDate() + ", getUsersNumber()=" + getUsersNumber() + ", getUsersPostsalCode()="
				+ getUsersPostsalCode() + ", getUsersAddressLine1()=" + getUsersAddressLine1()
				+ ", getUsersAddressLine2()=" + getUsersAddressLine2() + ", getCareIntroText()=" + getCareIntroText()
				+ ", getCareAccept()=" + getCareAccept() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

}
