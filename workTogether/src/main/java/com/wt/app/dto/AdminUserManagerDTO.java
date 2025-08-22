package com.wt.app.dto;

public class AdminUserManagerDTO {
	// 전체 유저 테이블
	private int userNumber; // 전체 유저 넘버
	private String userName; // 일반 or 돌봄 유저 이름
	private String userId; // 전체 유저 아이디
	private String userEmail; // 일반 or 돌봄 유저 이메일
	private String userPhone; // 일반 or 돌봄 유저 전화번호
	private char userType; // 유저 타입

	public int getUserNumber() {
		return userNumber;
	}

	public void setUserNumber(int userNumber) {
		this.userNumber = userNumber;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public char getUserType() {
		return userType;
	}

	public void setUserType(char userType) {
		this.userType = userType;
	}

	@Override
	public String toString() {
		return "AdminUserManagerDTO [userNumber=" + userNumber + ", userName=" + userName + ", userId=" + userId
				+ ", userEmail=" + userEmail + ", userPhone=" + userPhone + ", userType=" + userType + "]";
	}

}
