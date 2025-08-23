package com.wt.app.dto;

public class FindPwDTO {
	// 전체 유저 테이블
	private String usersId;
	private String usersName;
	private String usersPhone;
	private String usersType;
	public String getUsersId() {
		return usersId;
	}
	public void setUsersId(String usersId) {
		this.usersId = usersId;
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
	public String getUsersType() {
		return usersType;
	}
	public void setUsersType(String usersType) {
		this.usersType = usersType;
	}
	@Override
	public String toString() {
		return "FindPwDTO [usersId=" + usersId + ", usersName=" + usersName + ", usersPhone=" + usersPhone
				+ ", usersType=" + usersType + "]";
	}

	
}
