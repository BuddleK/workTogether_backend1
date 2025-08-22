package com.wt.app.dto;

public class UsersLoginDTO {
	//전체 유저 테이블
	private int usersNumber;			//회원 번호
	private String usersId;			//회원 아이디
    private String usersPassword;	//회원 비밀번호
    private char usersType;			//회원 타입
    
	public int getUserNumber() {
		return usersNumber;
	}
	public void setUserNumber(int userNumber) {
		this.usersNumber = userNumber;
	}
	public String getUsersId() {
		return usersId;
	}
	public void setUsersId(String userId) {
		this.usersId = userId;
	}
	public String getUsersPassword() {
		return usersPassword;
	}
	public void setUsersPassword(String usersPassword) {
		this.usersPassword = usersPassword;
	}
	public char getUserType() {
		return usersType;
	}
	public void setUserType(char userType) {
		this.usersType = userType;
	}
	@Override
	public String toString() {
		return "UsersLoginDTO [usersNumber=" + usersNumber + ", usersId=" + usersId + ", usersPassword=" + usersPassword
				+ ", userType=" + usersType + "]";
	}
    
	

//    users_id VARCHAR2(30) NOT NULL UNIQUE,
//    users_password VARCHAR2(255) NOT NULL,
//    users_type CHAR(1) CHECK (users_type IN ('C', 'N')) NOT NULL,
    
	
	
}
