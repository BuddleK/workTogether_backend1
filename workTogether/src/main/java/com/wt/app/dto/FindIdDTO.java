package com.wt.app.dto;

public class FindIdDTO {
	//users_name VARCHAR2(50) NOT NULL,
	//users_phone VARCHAR2(30) NOT NULL,
	//users_type CHAR(1) CHECK (users_type IN ('C', 'N')) NOT NULL,
	
	//유저테이블
	private int userNumber;		//회원 번호
	private String usersName;	//회원 이름
	private String usersPhone;	//회원 전화번호
	private char usersType;		//회원 타입
	
	
	
	
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
