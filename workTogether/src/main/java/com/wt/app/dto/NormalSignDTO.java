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
	private long usersNumber;
	private String usersId;
    private String usersPassword;
    private String usersType;

    // 상세
    private String usersName;
    private String usersEmail;
    private String usersPhone;
    private String usersPostsalCode;
    private String usersAddressLine1;
    private String usersAddressLine2;
    private String normalUsersLevel;
	public long getUsersNumber() {
		return usersNumber;
	}
	public void setUsersNumber(long usersNumber) {
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
	public String getNormalUsersLevel() {
		return normalUsersLevel;
	}
	public void setNormalUsersLevel(String normalUsersLevel) {
		this.normalUsersLevel = normalUsersLevel;
	}
	@Override
	public String toString() {
		return "NormalSignDTO [usersNumber=" + usersNumber + ", usersId=" + usersId + ", usersPassword=" + usersPassword
				+ ", usersType=" + usersType + ", usersName=" + usersName + ", usersEmail=" + usersEmail
				+ ", usersPhone=" + usersPhone + ", usersPostsalCode=" + usersPostsalCode + ", usersAddressLine1="
				+ usersAddressLine1 + ", usersAddressLine2=" + usersAddressLine2 + ", normalUsersLevel="
				+ normalUsersLevel + "]";
	}
    
    
}
