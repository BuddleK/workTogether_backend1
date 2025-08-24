package com.wt.app.dto;

public class AdminCareApproveRequestDTO {
	private int usersNumber;

	public int getUsersNumber() {
		return usersNumber;
	}

	public void setUsersNumber(int usersNumber) {
		this.usersNumber = usersNumber;
	}

	@Override
	public String toString() {
		return "AdminCareApproveRequestDTO [usersNumber=" + usersNumber + "]";
	}

}
