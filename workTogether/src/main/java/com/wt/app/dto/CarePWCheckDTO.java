package com.wt.app.dto;

public class CarePWCheckDTO {
	private int usersNumber;
    private String usersPassword;
	public int getUsersNumber(int usersNumber) {
		return usersNumber;
	}
	public void setUsersNumber(int usersNumber) {
		this.usersNumber = usersNumber;
	}
	public String getUsersPassword(String usersPassword) {
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
