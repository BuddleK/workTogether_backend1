package com.wt.app.dto;

public class FindPwDTO {
	//전체 유저 테이블
	private int usersNumber;	//회원 번호
	private String usersName;	//회원 이름
	private String usersPhone;	//회원 전화번호
	private char usersType;		//회원 유형
	private String usersId;		//회원 아이디
	
	public int getusersNumber() {
		return usersNumber;
	}
	public void setusersNumber(int usersNumber) {
		this.usersNumber = usersNumber;
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
	public String getUsersId() {
		return usersId;
	}
	public void setUsersId(String usersId) {
		this.usersId = usersId;
	}
	@Override
	public String toString() {
		return "FindPw [usersNumber=" + usersNumber + ", usersName=" + usersName + ", usersPhone=" + usersPhone
				+ ", usersType=" + usersType + ", usersId=" + usersId + "]";
	}
	
	
	
}
