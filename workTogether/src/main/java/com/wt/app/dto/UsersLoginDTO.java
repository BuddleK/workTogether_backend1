package com.wt.app.dto;

public class UsersLoginDTO {
	private int userNumber;
	private String userId;
    private String usersPassword;
    private char userType;
	public int getUserNumber() {
		return userNumber;
	}
	public void setUserNumber(int userNumber) {
		this.userNumber = userNumber;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUsersPassword() {
		return usersPassword;
	}
	public void setUsersPassword(String usersPassword) {
		this.usersPassword = usersPassword;
	}
	public char getUserType() {
		return userType;
	}
	public void setUserType(char userType) {
		this.userType = userType;
	}
	@Override
	public String toString() {
		return "UsersLoginDTO [userNumber=" + userNumber + ", userId=" + userId + ", usersPassword=" + usersPassword
				+ ", userType=" + userType + "]";
	}
    
	

//    users_id VARCHAR2(30) NOT NULL UNIQUE,
//    users_password VARCHAR2(255) NOT NULL,
//    users_type CHAR(1) CHECK (users_type IN ('C', 'N')) NOT NULL,
    
	
	
}
