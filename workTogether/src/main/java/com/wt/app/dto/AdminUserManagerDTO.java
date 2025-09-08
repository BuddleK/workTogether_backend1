package com.wt.app.dto;

public class AdminUserManagerDTO {
	// 전체 유저 테이블
	private int usersNumber; // 전체 유저 넘버
	private String usersName; // 일반 or 돌봄 유저 이름
	private String usersId; // 전체 유저 아이디
	private String usersEmail; // 일반 or 돌봄 유저 이메일
	private String usersPhone; // 일반 or 돌봄 유저 전화번호
	private String usersType; // 유저 타입

	// 유저 디테일 페이지를 위한 필드
	private String usersCreatedDate; // 유저 생성일
	private String usersAddressLine1; // 주소1
	private String usersAddressLine2; // 주소2
	private String usersPassword; // 유저 패스워드
	private int usersPoint; // 유저 포인트

	public int getusersNumber() {
		return usersNumber;
	}

	public void setusersNumber(int usersNumber) {
		this.usersNumber = usersNumber;
	}

	public String getusersName() {
		return usersName;
	}

	public void setusersName(String usersName) {
		this.usersName = usersName;
	}

	public String getusersId() {
		return usersId;
	}

	public void setusersId(String usersId) {
		this.usersId = usersId;
	}

	public String getusersEmail() {
		return usersEmail;
	}

	public void setusersEmail(String usersEmail) {
		this.usersEmail = usersEmail;
	}

	public String getusersPhone() {
		return usersPhone;
	}

	public void setusersPhone(String usersPhone) {
		this.usersPhone = usersPhone;
	}

	public String getusersType() {
		return usersType;
	}

	public void setusersType(String usersType) {
		this.usersType = usersType;
	}

	public String getusersCreatedDate() {
		return usersCreatedDate;
	}

	public void setusersCreatedDate(String usersCreatedDate) {
		this.usersCreatedDate = usersCreatedDate;
	}

	public String getusersAddressLine1() {
		return usersAddressLine1;
	}

	public void setusersAddressLine1(String usersAddressLine1) {
		this.usersAddressLine1 = usersAddressLine1;
	}

	public String getusersAddressLine2() {
		return usersAddressLine2;
	}

	public void setusersAddressLine2(String usersAddressLine2) {
		this.usersAddressLine2 = usersAddressLine2;
	}

	public String getusersPassword() {
		return usersPassword;
	}

	public void setusersPassword(String usersPassword) {
		this.usersPassword = usersPassword;
	}

	public int getusersPoint() {
		return usersPoint;
	}

	public void setusersPoint(int usersPoint) {
		this.usersPoint = usersPoint;
	}

	@Override
	public String toString() {
		return "AdminusersManagerDTO [usersNumber=" + usersNumber + ", usersName=" + usersName + ", usersId=" + usersId
				+ ", usersEmail=" + usersEmail + ", usersPhone=" + usersPhone + ", usersType=" + usersType
				+ ", usersCreatedDate=" + usersCreatedDate + ", usersAddressLine1=" + usersAddressLine1
				+ ", usersAddressLine2=" + usersAddressLine2 + ", usersPassword=" + usersPassword + ", usersPoint="
				+ usersPoint + "]";
	}

}
