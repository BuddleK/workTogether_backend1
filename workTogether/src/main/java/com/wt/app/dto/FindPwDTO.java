package com.wt.app.dto;

public class FindPwDTO {
	private int usetNumber;
	private String usersName;
	private String usersPhone;
	private char usersType;
	private String usersId;
	public int getUsetNumber() {
		return usetNumber;
	}
	public void setUsetNumber(int usetNumber) {
		this.usetNumber = usetNumber;
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
		return "FindPw [usetNumber=" + usetNumber + ", usersName=" + usersName + ", usersPhone=" + usersPhone
				+ ", usersType=" + usersType + ", usersId=" + usersId + "]";
	}
	
	
	
}
