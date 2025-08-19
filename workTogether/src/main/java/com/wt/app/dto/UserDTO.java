package com.wt.app.dto;

public class UserDTO {
	private int userNumber;
    private String userType;
    private String userId;
    private String userName;
    private String userPassword;
    private String userEmail;
    private String userPhone;
    private String userPostalCode;
    private String userAddressLine1;
    private String userAddressLine2;
    
    
	public int getUserNumber() {
		return userNumber;
	}
	public void setUserNumber(int userNumber) {
		this.userNumber = userNumber;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getUserPostalCode() {
		return userPostalCode;
	}
	public void setUserPostalCode(String userPostalCode) {
		this.userPostalCode = userPostalCode;
	}
	public String getUserAddressLine1() {
		return userAddressLine1;
	}
	public void setUserAddressLine1(String userAddressLine1) {
		this.userAddressLine1 = userAddressLine1;
	}
	public String getUserAddressLine2() {
		return userAddressLine2;
	}
	public void setUserAddressLine2(String userAddressLine2) {
		this.userAddressLine2 = userAddressLine2;
	}
	
	@Override
	public String toString() {
		return "UserDTO [userNumber=" + userNumber + ", userType=" + userType + ", userId=" + userId + ", userName="
				+ userName + ", userPassword=" + userPassword + ", userEmail=" + userEmail + ", userPhone=" + userPhone
				+ ", userPostalCode=" + userPostalCode + ", userAddressLine1=" + userAddressLine1
				+ ", userAddressLine2=" + userAddressLine2 + "]";
	}
    
	
}
