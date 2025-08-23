package com.wt.app.dto;

public class AdminCareRejectRequestDTO {
	private int usersNumber;
	private String rejectReason;

	public int getUsersNumber() {
		return usersNumber;
	}

	public void setUsersNumber(int usersNumber) {
		this.usersNumber = usersNumber;
	}

	public String getRejectReason() {
		return rejectReason;
	}

	public void setRejectReason(String rejectReason) {
		this.rejectReason = rejectReason;
	}

	@Override
	public String toString() {
		return "AdminCareRejectRequestDTO [usersNumber=" + usersNumber + ", rejectReason=" + rejectReason + "]";
	}

}
