package com.wt.app.dto;

public class UsersDTO {

	private Long usersNumber;
    private String usersId;
    private String usersPassword;
    private String usersType;         
    private Long usersPoint;
	private String careAccept;
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
	public Long getUsersPoint() {
		return usersPoint;
	}
	public void setUsersPoint(Long usersPoint) {
		this.usersPoint = usersPoint;
	}
	public String getCareAccept() {
		return careAccept;
	}
	public void setCareAccept(String careAccept) {
		this.careAccept = careAccept;
	}
	@Override
	public String toString() {
		return "UsersDTO [usersNumber=" + usersNumber + ", usersId=" + usersId + ", usersPassword=" + usersPassword
				+ ", usersType=" + usersType + ", usersPoint=" + usersPoint + ", careAccept=" + careAccept + "]";
	}
	
	
}
