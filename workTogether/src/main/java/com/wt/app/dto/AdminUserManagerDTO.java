package com.wt.app.dto;

public class AdminUserManagerDTO {
	private int userNumber;
	private String userName;
	private String userId;
	private String userEmail;
	private String userPhone;
	private char userType;

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
