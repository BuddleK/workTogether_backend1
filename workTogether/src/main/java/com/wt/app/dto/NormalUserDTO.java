package com.wt.app.dto;

public class NormalUserDTO {
	private int normalNumber;
    private int usersNumber;
    private String normalUsersLevel;
    
	public int getNormalNumber() {
		return normalNumber;
	}
	public void setNormalNumber(int normalNumber) {
		this.normalNumber = normalNumber;
	}
	public int getUsersNumber() {
		return usersNumber;
	}
	public void setUsersNumber(int usersNumber) {
		this.usersNumber = usersNumber;
	}
	public String getNormalUsersLevel() {
		return normalUsersLevel;
	}
	public void setNormalUsersLevel(String normalUsersLevel) {
		this.normalUsersLevel = normalUsersLevel;
	}
	
	@Override
	public String toString() {
		return "NormalUserDTO [normalNumber=" + normalNumber + ", usersNumber=" + usersNumber + ", normalUsersLevel="
				+ normalUsersLevel + "]";
	}
}
