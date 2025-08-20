package com.wt.app.dto;

import java.sql.Date;

public class UsersDTO {
	private int usersNumber;
    private String usersType;
    private String usersId;
    private String usersName;
    private String usersPassword;
    private String usersEmail;
    private String usersPhone;
    private String usersPostalCode;
    private String usersAddressLine1;
    private String usersAddressLine2;
    private String usersCreatedDate;
    private String usersUpdatedDate;
	//
    public int getUsersNumber() {
		return usersNumber;
	}
	public void setUsersNumber(int usersNumber) {
		this.usersNumber = usersNumber;
	}
	public String getUsersType() {
		return usersType;
	}
	public void setUsersType(String usersType) {
		this.usersType = usersType;
	}
	public String getUsersId() {
		return usersId;
	}
	public void setUsersId(String usersId) {
		this.usersId = usersId;
	}
	public String getUsersName() {
		return usersName;
	}
	public void setUsersName(String usersName) {
		this.usersName = usersName;
	}
	public String getUsersPassword() {
		return usersPassword;
	}
	public void setUsersPassword(String usersPassword) {
		this.usersPassword = usersPassword;
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
	public String getUsersPostalCode() {
		return usersPostalCode;
	}
	public void setUsersPostalCode(String usersPostalCode) {
		this.usersPostalCode = usersPostalCode;
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
	public Date getUsersCreatedDate() {
		return usersCreatedDate;
	}
	public void setUsersCreatedDate(Date usersCreatedDate) {
		this.usersCreatedDate = usersCreatedDate;
	}
	public Date getUsersUpdatedDate() {
		return usersUpdatedDate;
	}
	public void setUsersUpdatedDate(Date usersUpdatedDate) {
		this.usersUpdatedDate = usersUpdatedDate;
	}
	
	@Override
	public String toString() {
		return "UserDTO [usersNumber=" + usersNumber + ", usersType=" + usersType + ", usersId=" + usersId
				+ ", usersName=" + usersName + ", usersPassword=" + usersPassword + ", usersEmail=" + usersEmail
				+ ", usersPhone=" + usersPhone + ", usersPostalCode=" + usersPostalCode + ", usersAddressLine1="
				+ usersAddressLine1 + ", usersAddressLine2=" + usersAddressLine2 + ", usersCreatedDate="
				+ usersCreatedDate + ", usersUpdatedDate=" + usersUpdatedDate + "]";
	}
    
    
	
    
	
}
