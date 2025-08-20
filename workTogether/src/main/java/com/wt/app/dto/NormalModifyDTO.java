package com.wt.app.dto;

public class NormalModifyDTO {
	private int UserNumber;
	private int NormalNumber;
	private String usersName;
	private char normalUsersLevel;
	private String UsersPostCode;
	private String UsersAddrLine1;
	private String UsersAddrLine2;
	private String UsersPhone;
	private String UsersEmail;
	private String UsersPassword;

	public int getUserNumber() {
		return UserNumber;
	}

	public void setUserNumber(int userNumber) {
		UserNumber = userNumber;
	}

	public int getNormalNumber() {
		return NormalNumber;
	}

	public void setNormalNumber(int normalNumber) {
		NormalNumber = normalNumber;
	}

	public String getUsersName() {
		return usersName;
	}

	public void setUsersName(String usersName) {
		this.usersName = usersName;
	}

	public char getNormalUsersLevel() {
		return normalUsersLevel;
	}

	public void setNormalUsersLevel(char normalUsersLevel) {
		this.normalUsersLevel = normalUsersLevel;
	}

	public String getUsersPostCode() {
		return UsersPostCode;
	}

	public void setUsersPostCode(String usersPostCode) {
		UsersPostCode = usersPostCode;
	}

	public String getUsersAddrLine1() {
		return UsersAddrLine1;
	}

	public void setUsersAddrLine1(String usersAddrLine1) {
		UsersAddrLine1 = usersAddrLine1;
	}

	public String getUsersAddrLine2() {
		return UsersAddrLine2;
	}

	public void setUsersAddrLine2(String usersAddrLine2) {
		UsersAddrLine2 = usersAddrLine2;
	}

	public String getUsersPhone() {
		return UsersPhone;
	}

	public void setUsersPhone(String usersPhone) {
		UsersPhone = usersPhone;
	}

	public String getUsersEmail() {
		return UsersEmail;
	}

	public void setUsersEmail(String usersEmail) {
		UsersEmail = usersEmail;
	}

	public String getUsersPassword() {
		return UsersPassword;
	}

	public void setUsersPassword(String usersPassword) {
		UsersPassword = usersPassword;
	}

	@Override
	public String toString() {
		return "NormalModifyDTO [UserNumber=" + UserNumber + ", NormalNumber=" + NormalNumber + ", usersName="
				+ usersName + ", normalUsersLevel=" + normalUsersLevel + ", UsersPostCode=" + UsersPostCode
				+ ", UsersAddrLine1=" + UsersAddrLine1 + ", UsersAddrLine2=" + UsersAddrLine2 + ", UsersPhone="
				+ UsersPhone + ", UsersEmail=" + UsersEmail + ", UsersPassword=" + UsersPassword + "]";
	}

}
