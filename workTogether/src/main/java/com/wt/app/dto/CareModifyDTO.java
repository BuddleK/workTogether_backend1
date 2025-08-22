package com.wt.app.dto;

public class CareModifyDTO {
//	CREATE TABLE tbl_users (
//		    users_number NUMBER,
//		    users_id VARCHAR2(30) NOT NULL UNIQUE,
//		    users_password VARCHAR2(255) NOT NULL,
//		    users_type CHAR(1) CHECK (users_type IN ('C', 'N')) NOT NULL,
//		    users_created_date DATE DEFAULT sysdate,
//		    users_updated_date DATE DEFAULT sysdate,
//		    users_point number default 0,
//		    CONSTRAINT pk_tbl_users PRIMARY KEY (users_number)
//		);
//
//		-- 돌봄 회원
//		CREATE TABLE tbl_care_users (
//		    care_number NUMBER,
//		    users_name VARCHAR2(50) NOT NULL,
//		    users_email VARCHAR2(255) NOT NULL UNIQUE,
//		    users_phone VARCHAR2(30) NOT NULL,
//		    users_postsal_code VARCHAR2(10) NOT NULL,
//		    users_address_line1 VARCHAR2(255) NOT NULL,
//		    users_address_line2 VARCHAR2(255) NOT NULL,
//		    care_intro_text VARCHAR2(150),
//		    care_certificate_files_num NUMBER NOT NULL,
//		    care_passbook_files_num NUMBER NOT NULL,
//		    care_profiles_photo_number NUMBER,
//		    care_accept CHAR(1) DEFAULT 'N' CHECK (care_accept IN ('Y', 'N')),
//		    users_number NUMBER NOT NULL UNIQUE,
//		    CONSTRAINT pk_care_users PRIMARY KEY(care_number),
//		    CONSTRAINT fk_care_users FOREIGN KEY (users_number) REFERENCES tbl_users (users_number),
//		    CONSTRAINT fk_care_cert_files FOREIGN KEY (care_certificate_files_num) REFERENCES tbl_files_license(license_files_number) ON DELETE CASCADE,
//		    CONSTRAINT fk_care_passbook_files FOREIGN KEY (care_passbook_files_num) REFERENCES tbl_files_account(account_files_number) ON DELETE CASCADE,
//		    CONSTRAINT fk_care_profiles_photo FOREIGN KEY (care_profiles_photo_number) REFERENCES tbl_files_profiles(profiles_files_number) ON DELETE CASCADE
//		);

	private int usersNumber;
	private int careNumber;
	private String usersName;
	private String usersPostsalCode;
	private String usersAddressLine1;
	private String usersAddressLine2;
	private String usersPhone;
	private String usersId;
	private String usersEmail;
	private String usersPassword;
	public int getUsersNumber() {
		return usersNumber;
	}
	public void setUsersNumber(int usersNumber) {
		this.usersNumber = usersNumber;
	}
	public int getCareNumber() {
		return careNumber;
	}
	public void setCareNumber(int careNumber) {
		this.careNumber = careNumber;
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
		return "CareModifyDTO [usersNumber=" + usersNumber + ", careNumber=" + careNumber + ", usersName=" + usersName
				+ ", usersPostsalCode=" + usersPostsalCode + ", usersAddressLine1=" + usersAddressLine1
				+ ", usersAddressLine2=" + usersAddressLine2 + ", usersPhone=" + usersPhone + ", usersId=" + usersId
				+ ", usersEmail=" + usersEmail + ", usersPassword=" + usersPassword + "]";
	}

	

}
