package com.wt.app.dto;

public class CarePwCheckDTO {
	private int usersNumber;
    private String usersPassword;
	public int getUsersNumber() {
		return usersNumber;
	}
	public void setUsersNumber(int usersNumber) {
		this.usersNumber = usersNumber;
	}
	public String getUsersPassword() {
		return usersPassword;
	}
	public void setUsersPassword(String usersPassword) {
		this.usersPassword = usersPassword;
	}
	@Override
	public String toString() {
		return "CarePwCheckDTO [usersNumber=" + usersNumber + ", usersPassword=" + usersPassword + "]";
	}
    
}
