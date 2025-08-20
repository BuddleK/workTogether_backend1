package com.wt.app.dto;

public class CareSignDTO {
//    care_number NUMBER,
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
//    
//    users_number NUMBER,
//    users_id VARCHAR2(30) NOT NULL UNIQUE,
//    users_password VARCHAR2(255) NOT NULL,
//    users_type CHAR(1) CHECK (users_type IN ('C', 'N')) NOT NULL,
//    users_created_date DATE DEFAULT sysdate,
//    users_updated_date DATE DEFAULT sysdate,
	private int careNumber;
	private String usersName;
	private String usersEmail;
	private String usersPhone;
	private String usersPostsalCode;
	private String usersAddressLine1;
	private String usersAddressLine2;
	private String careIntroText;
	private String careCertificateFilesNum;
	private String carePassbookFilesNum;
	private String careProfilesPhotoNumber;
	private String careAccept;
	
	private int usersNumber;
	private String usersId;
	private String usersPassword;
	private char usersType;
	private String usersCreateDate;
	private String usersUpdatedDate;
	
	
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


	public String getUsersEmail() {
		return usersEmail;
	}


	public void setUsersEmail(String usersEmail) {
		this.usersEmail = usersEmail;
	}


	public String getUsersPhone() {
		return usersPhone;
	}


	public void setUsersPhone(String usersPhone) {
		this.usersPhone = usersPhone;
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


	public String getCareCertificateFilesNum() {
		return careCertificateFilesNum;
	}


	public void setCareCertificateFilesNum(String careCertificateFilesNum) {
		this.careCertificateFilesNum = careCertificateFilesNum;
	}


	public String getCarePassbookFilesNum() {
		return carePassbookFilesNum;
	}


	public void setCarePassbookFilesNum(String carePassbookFilesNum) {
		this.carePassbookFilesNum = carePassbookFilesNum;
	}


	public String getCareProfilesPhotoNumber() {
		return careProfilesPhotoNumber;
	}


	public void setCareProfilesPhotoNumber(String careProfilesPhotoNumber) {
		this.careProfilesPhotoNumber = careProfilesPhotoNumber;
	}


	public String getCareAccept() {
		return careAccept;
	}


	public void setCareAccept(String careAccept) {
		this.careAccept = careAccept;
	}


	public int getUsersNumber() {
		return usersNumber;
	}


	public void setUsersNumber(int usersNumber) {
		this.usersNumber = usersNumber;
	}


	public String getUsersId() {
		return usersId;
	}


	public void setUsersId(String usersId) {
		this.usersId = usersId;
	}


	public String getUsersPassword() {
		return usersPassword;
	}


	public void setUsersPassword(String usersPassword) {
		this.usersPassword = usersPassword;
	}


	public char getUsersType() {
		return usersType;
	}


	public void setUsersType(char usersType) {
		this.usersType = usersType;
	}


	public String getUsersCreateDate() {
		return usersCreateDate;
	}


	public void setUsersCreateDate(String usersCreateDate) {
		this.usersCreateDate = usersCreateDate;
	}


	public String getUsersUpdatedDate() {
		return usersUpdatedDate;
	}


	public void setUsersUpdatedDate(String usersUpdatedDate) {
		this.usersUpdatedDate = usersUpdatedDate;
	}


	@Override
	public String toString() {
		return "CareSginDTO [careNumber=" + careNumber + ", usersName=" + usersName + ", usersEmail=" + usersEmail
				+ ", usersPhone=" + usersPhone + ", usersPostsalCode=" + usersPostsalCode + ", usersAddressLine1="
				+ usersAddressLine1 + ", usersAddressLine2=" + usersAddressLine2 + ", careIntroText=" + careIntroText
				+ ", careCertificateFilesNum=" + careCertificateFilesNum + ", carePassbookFilesNum="
				+ carePassbookFilesNum + ", careProfilesPhotoNumber=" + careProfilesPhotoNumber + ", careAccept="
				+ careAccept + ", usersNumber=" + usersNumber + ", usersId=" + usersId + ", usersPassword="
				+ usersPassword + ", usersType=" + usersType + ", usersCreateDate=" + usersCreateDate
				+ ", usersUpdatedDate=" + usersUpdatedDate + "]";
	}
	
	
}
