package com.wt.app.dto;

public class FindId {
	//users_name VARCHAR2(50) NOT NULL,
	//users_phone VARCHAR2(30) NOT NULL,
	//users_type CHAR(1) CHECK (users_type IN ('C', 'N')) NOT NULL,
	private int userNumber;
	private String usersName;
	private String usersPhone;
	private char usersType;
	
	
	
	
	public int getUserNumber() {
		return userNumber;
	}




	public void setUserNumber(int userNumber) {
		this.userNumber = userNumber;
	}




	public String getUsersName() {
		return usersName;
	}




	public void setUsersName(String usersName) {
		this.usersName = usersName;
	}




	public String getUsersPhone() {
		return usersPhone;
	}




	public void setUsersPhone(String usersPhone) {
		this.usersPhone = usersPhone;
	}




	public char getUsersType() {
		return usersType;
	}




	public void setUsersType(char usersType) {
		this.usersType = usersType;
	}




	@Override
	public String toString() {
		return "FindId [userNumber=" + userNumber + ", usersName=" + usersName + ", usersPhone=" + usersPhone
				+ ", usersType=" + usersType + "]";
	}
	
	
	
	
}
