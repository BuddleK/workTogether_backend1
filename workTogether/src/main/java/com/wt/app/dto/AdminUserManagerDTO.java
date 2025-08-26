package com.wt.app.dto;

public class AdminUserManagerDTO {
	// 전체 유저 테이블
	private int userNumber; // 전체 유저 넘버
	private String userName; // 일반 or 돌봄 유저 이름
	private String userId; // 전체 유저 아이디
	private String userEmail; // 일반 or 돌봄 유저 이메일
	private String userPhone; // 일반 or 돌봄 유저 전화번호
	private String userType; // 유저 타입

	// 유저 디테일 페이지를 위한 필드
	private String usersCreatedDate; // 유저 생성일
	private String usersAddressLine1; // 주소1
	private String usersAddressLine2; // 주소2
	private String usersPassword; // 유저 패스워드
	private int usersPoint; // 유저 포인트
	public int getUserNumber() {
		return userNumber;
	}
	public void setUserNumber(int userNumber) {
		this.userNumber = userNumber;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
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

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getUsersCreatedDate() {
		return usersCreatedDate;
	}
	public void setUsersCreatedDate(String usersCreatedDate) {
		this.usersCreatedDate = usersCreatedDate;
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
	public String getUsersPassword() {
		return usersPassword;
	}
	public void setUsersPassword(String usersPassword) {
		this.usersPassword = usersPassword;
	}
<<<<<<< HEAD

	public int getUsersPoint() {
		return usersPoint;
	}

=======
	public int getUsersPoint() {
		return usersPoint;
	}
>>>>>>> main
	public void setUsersPoint(int usersPoint) {
		this.usersPoint = usersPoint;
	}
	@Override
	public String toString() {
		return "AdminUserManagerDTO [userNumber=" + userNumber + ", userName=" + userName + ", userId=" + userId
				+ ", userEmail=" + userEmail + ", userPhone=" + userPhone + ", userType=" + userType
				+ ", usersCreatedDate=" + usersCreatedDate + ", usersAddressLine1=" + usersAddressLine1
				+ ", usersAddressLine2=" + usersAddressLine2 + ", usersPassword=" + usersPassword + ", usersPoint="
				+ usersPoint + "]";
	}

	
}
