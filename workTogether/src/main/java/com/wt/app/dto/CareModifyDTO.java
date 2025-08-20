package com.wt.app.dto;

public class CareModifyDTO {
//	-- 회원
//	CREATE TABLE tbl_users (
//	    users_number NUMBER ,
//	    CONSTRAINT pk_tbl_users PRIMARY KEY (users_number),
//	    users_type CHAR(1) CHECK (users_type IN ('C', 'N')) NOT NULL,
//	    users_id VARCHAR2(30) NOT NULL UNIQUE,
//	    users_name VARCHAR2(50) NOT NULL,
//	    users_password VARCHAR2(255) NOT NULL,
//	    users_email VARCHAR2(255) NOT NULL UNIQUE,
//	    users_phone VARCHAR2(30) NOT NULL,
//	    users_postsal_code VARCHAR2(10) NOT NULL,
//	    users_address_line1 VARCHAR2(255) NOT NULL,
//	    users_address_line2 VARCHAR2(255) NOT NULL,
//	    users_created_date DATE NOT NULL,
//	    users_updated_date DATE
//	);
	
	int usersNumber;
	String usersName;
	String usersPostsalCode;
	String usersAddressLine1;
	String usersAddressLine2;
	String usersPhone;
	String usersId;
	String usersEmail;
	String usersPassword;
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
	public String getUsersId() {
		return usersId;
	}
	public void setUsersId(String usersId) {
		this.usersId = usersId;
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
		return "careModifyDTO [usersNumber=" + usersNumber + ", usersName=" + usersName + ", usersPostsalCode="
				+ usersPostsalCode + ", usersAddressLine1=" + usersAddressLine1 + ", usersAddressLine2="
				+ usersAddressLine2 + ", usersPhone=" + usersPhone + ", usersId=" + usersId + ", usersEmail="
				+ usersEmail + ", usersPassword=" + usersPassword + "]";
	}
	
	
}
