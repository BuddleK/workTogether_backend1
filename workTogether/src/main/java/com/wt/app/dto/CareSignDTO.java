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
	// 돌봄 유저 테이블
	private String usersId;
	private String usersPassword;
	private String usersType; // 'C'

	// 상세
    private int usersNumber;
	private String usersName;
	private String usersEmail;
	private String usersPhone;
	private String usersPostsalCode;
	private String usersAddressLine1;
	private String usersAddressLine2;
	private String careIntroText;
    private String careAccept;

	
	private Long careCertificateFilesNum;
	private Long carePassbookFilesNum;
	private Long careProfilesPhotoNumber;
	
	
	
	public int getUsersNumber() {
		return usersNumber;
	}
	public void setUsersNumber(int usersNumber) {
		this.usersNumber = usersNumber;
	}
	public String getCareAccept() {
		return careAccept;
	}
	public void setCareAccept(String careAccept) {
		this.careAccept = careAccept;
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
	public String getUsersType() {
		return usersType;
	}
	public void setUsersType(String usersType) {
		this.usersType = usersType;
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
	public Long getCareCertificateFilesNum() {
		return careCertificateFilesNum;
	}
	public void setCareCertificateFilesNum(Long careCertificateFilesNum) {
		this.careCertificateFilesNum = careCertificateFilesNum;
	}
	public Long getCarePassbookFilesNum() {
		return carePassbookFilesNum;
	}
	public void setCarePassbookFilesNum(Long carePassbookFilesNum) {
		this.carePassbookFilesNum = carePassbookFilesNum;
	}
	public Long getCareProfilesPhotoNumber() {
		return careProfilesPhotoNumber;
	}
	public void setCareProfilesPhotoNumber(Long careProfilesPhotoNumber) {
		this.careProfilesPhotoNumber = careProfilesPhotoNumber;
	}
	@Override
	public String toString() {
		return "CareSignDTO [usersId=" + usersId + ", usersPassword=" + usersPassword + ", usersType=" + usersType
				+ ", usersNumber=" + usersNumber + ", usersName=" + usersName + ", usersEmail=" + usersEmail
				+ ", usersPhone=" + usersPhone + ", usersPostsalCode=" + usersPostsalCode + ", usersAddressLine1="
				+ usersAddressLine1 + ", usersAddressLine2=" + usersAddressLine2 + ", careIntroText=" + careIntroText
				+ ", careAccept=" + careAccept + ", careCertificateFilesNum=" + careCertificateFilesNum
				+ ", carePassbookFilesNum=" + carePassbookFilesNum + ", careProfilesPhotoNumber="
				+ careProfilesPhotoNumber + "]";
	}
	
	
}
