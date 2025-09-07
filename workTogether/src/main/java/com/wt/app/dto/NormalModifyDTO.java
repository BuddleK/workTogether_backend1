package com.wt.app.dto;

public class NormalModifyDTO {
	private int usersNumber;
	private String usersName;
	private String usersId;
	private String normalUsersLevel;
	private String usersPostsalCode;
	private String usersAddressLine1;
	private String usersAddressLine2;
	private String usersPhone;
	private String usersEmail;
	private String usersPassword;

	public int getUsersNumber() {
		return usersNumber;
	}

	public void setUsersNumber(int usersNumber) {
		this.usersNumber = usersNumber;
	}

	public String getUsersName() {
		return usersName;
	}

	public void setUsersName(String usersName) {
		this.usersName = usersName;
	}

	public String getUsersId() {
		return usersId;
	}

	public void setUsersId(String usersId) {
		this.usersId = usersId;
	}

	public String getNormalUsersLevel() {
		return normalUsersLevel;
	}

	public void setNormalUsersLevel(String normalUsersLevel) {
		this.normalUsersLevel = normalUsersLevel;
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

	public String getUsersPhone() {
		return usersPhone;
	}

	public void setUsersPhone(String usersPhone) {
		this.usersPhone = usersPhone;
	}

	public String getUsersEmail() {
		return usersEmail;
	}

	public void setUsersEmail(String usersEmail) {
		this.usersEmail = usersEmail;
	}

	public String getUsersPassword() {
		return usersPassword;
	}

	public void setUsersPassword(String usersPassword) {
		this.usersPassword = usersPassword;
	}

	@Override
	public String toString() {
		return "NormalModifyDTO [usersNumber=" + usersNumber + ", usersName=" + usersName + ", usersId=" + usersId
				+ ", normalUsersLevel=" + normalUsersLevel + ", usersPostsalCode=" + usersPostsalCode
				+ ", usersAddressLine1=" + usersAddressLine1 + ", usersAddressLine2=" + usersAddressLine2
				+ ", usersPhone=" + usersPhone + ", usersEmail=" + usersEmail + ", usersPassword=" + usersPassword
				+ "]";
	}

}
