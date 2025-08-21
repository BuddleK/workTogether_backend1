package com.wt.app.dto;

public class NormalSignDTO {

//	normal_number NUMBER,
//    users_name VARCHAR2(50) NOT NULL,
//    users_email VARCHAR2(255) NOT NULL UNIQUE,
//    users_phone VARCHAR2(30) NOT NULL,
//    users_postsal_code VARCHAR2(10) NOT NULL,
//    users_address_line1 VARCHAR2(255) NOT NULL,
//    users_address_line2 VARCHAR2(255) NOT NULL,
//    normal_users_level CHAR(1) NOT NULL CHECK (normal_users_level IN ('1', '2', '3', '4')),
//    users_number NUMBER NOT NULL UNIQUE,
	
	//일반 유저 테이블
	private int normalNumber;			//일반회원 번호
	private String usersName;			//일반회원 이름
	private String usersEmail;			//일반회원 이메일
	private String usersPhone;			//일반회원 전화번호
	private String usersPostsalCode;	//일반회원 우편번호
	private String usersAddressLine1;	//일반회원 주소1
	private String usersAddressLine2;	//일반회원 상세주소
	private char normalUsersLevel;		//일반회원 상태
	
	//전체 유저 테이블
	private int usersNumber;			//회원 번호
	private String usersId;				//회원 아이디
	private String usersPassword;		//회원 비밀번호
	private char usersType;				//회원 타입
	private String usersCreateDate;		//회원 생성일
	private String usersUpdatedDate;	//회원 수정일
	
	public int getNormalNumber() {
		return normalNumber;
	}
	public void setNormalNumber(int normalNumber) {
		this.normalNumber = normalNumber;
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
	public char getNormalUsersLevel() {
		return normalUsersLevel;
	}
	public void setNormalUsersLevel(char normalUsersLevel) {
		this.normalUsersLevel = normalUsersLevel;
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
		return "NormalSginDTO [normalNumber=" + normalNumber + ", usersName=" + usersName + ", usersEmail=" + usersEmail
				+ ", usersPhone=" + usersPhone + ", usersPostsalCode=" + usersPostsalCode + ", usersAddressLine1="
				+ usersAddressLine1 + ", usersAddressLine2=" + usersAddressLine2 + ", normalUsersLevel="
				+ normalUsersLevel + ", usersNumber=" + usersNumber + ", usersId=" + usersId + ", usersPassword="
				+ usersPassword + ", usersType=" + usersType + ", usersCreateDate=" + usersCreateDate
				+ ", usersUpdatedDate=" + usersUpdatedDate + "]";
	}
	
	
	
}
