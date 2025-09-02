package com.wt.app.dto;

public class NormalUsersDTO {
	private Long usersNumber;
	private String normalUsersLevel;
	@Override
	public String toString() {
		return "NormalUsersDTO [usersNumber=" + usersNumber + ", normalUsersLevel=" + normalUsersLevel + "]";
	}
	public Long getUsersNumber() {
		return usersNumber;
	}
	public void setUsersNumber(Long usersNumber) {
		this.usersNumber = usersNumber;
	}
	public String getNormalUsersLevel() {
		return normalUsersLevel;
	}
	public void setNormalUsersLevel(String normalUsersLevel) {
		this.normalUsersLevel = normalUsersLevel;
	}
	
	
	
	
}
