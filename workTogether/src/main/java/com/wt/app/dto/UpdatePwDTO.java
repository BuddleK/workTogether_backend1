package com.wt.app.dto;

public class UpdatePwDTO {
	private String usersId;
	private String newPassword;
	public String getUsersId() {
		return usersId;
	}
	public void setUsersId(String usersId) {
		this.usersId = usersId;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	@Override
	public String toString() {
		return "UpdatePwDTO [usersId=" + usersId + ", newPassword=" + newPassword + "]";
	}
	
}
