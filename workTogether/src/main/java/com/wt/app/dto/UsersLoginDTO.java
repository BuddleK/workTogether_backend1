package com.wt.app.dto;

public class UsersLoginDTO {
	//전체 유저 테이블
	private String usersId;
    private String usersPassword;
	
	public String getUsersId() {
		return usersId;
	}
	public void setUsersId(String usersId) {
		this.usersId = usersId;
	}
	public String getUsersPassword() {
		return usersPassword;
	}
	public void setUsersPassword(String usersPassword) {
		this.usersPassword = usersPassword;
	}
	@Override
	public String toString() {
		return "UsersLoginDTO [usersId=" + usersId
				+ ", usersPassword=" + usersPassword + "]";
	}

	
    
	
}
