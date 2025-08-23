package com.wt.app.dto;

public class UsersDTO {

	private Long usersNumber;
    private String usersId;
    private String usersPassword;
    private String usersType;         
    private String usersCreatedDate;
    private String usersUpdatedDate;
    private Long usersPoint;
	public Long getUsersNumber() {
		return usersNumber;
	}
	public void setUsersNumber(Long usersNumber) {
		this.usersNumber = usersNumber;
	}
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
	public String getUsersType() {
		return usersType;
	}
	public void setUsersType(String usersType) {
		this.usersType = usersType;
	}
	public String getUsersCreatedDate() {
		return usersCreatedDate;
	}
	public void setUsersCreatedDate(String usersCreatedDate) {
		this.usersCreatedDate = usersCreatedDate;
	}
	public String getUsersUpdatedDate() {
		return usersUpdatedDate;
	}
	public void setUsersUpdatedDate(String usersUpdatedDate) {
		this.usersUpdatedDate = usersUpdatedDate;
	}
	public Long getUsersPoint() {
		return usersPoint;
	}
	public void setUsersPoint(Long usersPoint) {
		this.usersPoint = usersPoint;
	}
	
	@Override
	public String toString() {
		return "UsersDTO [usersNumber=" + usersNumber + ", usersId=" + usersId + ", usersPassword=" + usersPassword
				+ ", usersType=" + usersType + ", usersCreatedDate=" + usersCreatedDate + ", usersUpdatedDate="
				+ usersUpdatedDate + ", usersPoint=" + usersPoint + "]";
	}
}
