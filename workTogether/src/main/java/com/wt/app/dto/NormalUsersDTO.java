package com.wt.app.dto;

public class NormalUsersDTO {
	private Long usersNumber;
	private String usersName;
	private String usersEmail;
	private String usersPhone;
	private String usersPostsalCode;
	private String usersAddressLine1;
	private String usersAddressLine2;
	private String normalUsersLevel;
	public Long getUsersNumber() {
		return usersNumber;
	}
	public void setUsersNumber(Long usersNumber) {
		this.usersNumber = usersNumber;
	}
	public String getUsersName() {
		return usersName;
	}
	public void setUsersName(String usersName) {
		this.usersName = usersName;
	}
	public String getUsersEmail() {
		return usersEmail;
	}
	public void setUsersEmail(String usersEmail) {
		this.usersEmail = usersEmail;
	}
	public String getUsersPhone() {
		return usersPhone;
	}
	public void setUsersPhone(String usersPhone) {
		this.usersPhone = usersPhone;
	}
	public String getUsersPostsalCode() {
		return usersPostsalCode;
	}
	public void setUsersPostsalCode(String usersPostsalCode) {
		this.usersPostsalCode = usersPostsalCode;
	}
	public String getUsersAddressLine1() {
		return usersAddressLine1;
	}
	public void setUsersAddressLine1(String usersAddressLine1) {
		this.usersAddressLine1 = usersAddressLine1;
	}
	public String getUsersAddressLine2() {
		return usersAddressLine2;
	}
	public void setUsersAddressLine2(String usersAddressLine2) {
		this.usersAddressLine2 = usersAddressLine2;
	}
	public String getNormalUsersLevel() {
		return normalUsersLevel;
	}
	public void setNormalUsersLevel(String normalUsersLevel) {
		this.normalUsersLevel = normalUsersLevel;
	}
	@Override
	public String toString() {
		return "NormalUsersDTO [usersNumber=" + usersNumber + ", usersName=" + usersName + ", usersEmail=" + usersEmail
				+ ", usersPhone=" + usersPhone + ", usersPostsalCode=" + usersPostsalCode + ", usersAddressLine1="
				+ usersAddressLine1 + ", usersAddressLine2=" + usersAddressLine2 + ", normalUsersLevel="
				+ normalUsersLevel + "]";
	}
	
	
}
