package com.wt.app.dto;

public class NormalModifyDTO {
	private int UserNumber;
	private int normalNumber;
	private String usersName;
	private String userId;
	private char normalUsersLevel;
	private String usersPostCode;
	private String usersAddrLine1;
	private String usersAddrLine2;
	private String usersPhone;
	private String usersEmail;
	private String usersPassword;

	public int getUserNumber() {
		return UserNumber;
	}

	public void setUserNumber(int userNumber) {
		UserNumber = userNumber;
	}

	public int getNormalNumber() {
		return normalNumber;
	}

	public void setNormalNumber(int normalNumber) {
		this.normalNumber = normalNumber;
	}

	public String getUsersName() {
		return usersName;
	}

	public void setUsersName(String usersName) {
		this.usersName = usersName;
	}
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public char getNormalUsersLevel() {
		return normalUsersLevel;
	}

	public void setNormalUsersLevel(char normalUsersLevel) {
		this.normalUsersLevel = normalUsersLevel;
	}

	public String getUsersPostCode() {
		return usersPostCode;
	}

	public void setUsersPostCode(String usersPostCode) {
		this.usersPostCode = usersPostCode;
	}

	public String getUsersAddrLine1() {
		return usersAddrLine1;
	}

	public void setUsersAddrLine1(String usersAddrLine1) {
		this.usersAddrLine1 = usersAddrLine1;
	}

	public String getUsersAddrLine2() {
		return usersAddrLine2;
	}

	public void setUsersAddrLine2(String usersAddrLine2) {
		this.usersAddrLine2 = usersAddrLine2;
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
		return "NormalModifyDTO [UserNumber=" + UserNumber + ", normalNumber=" + normalNumber + ", usersName="
				+ usersName + ", normalUsersLevel=" + normalUsersLevel + ", usersPostCode=" + usersPostCode
				+ ", usersAddrLine1=" + usersAddrLine1 + ", usersAddrLine2=" + usersAddrLine2 + ", usersPhone="
				+ usersPhone + ", usersEmail=" + usersEmail + ", usersPassword=" + usersPassword + "]";
	}



}
