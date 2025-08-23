package com.wt.app.dto;

public class CareReferenceCheckDTO {
//	-- 문의
//	CREATE TABLE tbl_reference (
//	    reference_number NUMBER PRIMARY KEY,
//	    reference_users_number NUMBER NOT NULL,
//	    reference_title VARCHAR2(300) NOT NULL,
//	    reference_created_date DATE NOT NULL,
//	    reference_content VARCHAR2(300) NOT NULL,
//	    reference_answered_yn CHAR(1) DEFAULT 'N' CHECK (reference_answered_yn IN ('Y', 'N')),
//	    CONSTRAINT fk_ref_users FOREIGN KEY (reference_users_number) REFERENCES tbl_users(users_number) ON DELETE CASCADE
//	);
//
//	-- 회원
//	CREATE TABLE tbl_users (
//	    users_number NUMBER,
//	    users_id VARCHAR2(30) NOT NULL UNIQUE,
//	    users_password VARCHAR2(255) NOT NULL,
//	    users_type CHAR(1) CHECK (users_type IN ('C', 'N')) NOT NULL,
//	    users_created_date DATE DEFAULT sysdate,
//	    users_updated_date DATE DEFAULT sysdate,
//	    users_point number default 0,
//	    CONSTRAINT pk_tbl_users PRIMARY KEY (users_number)
//	);

	private int referenceNumber;
	private int referenceUsers;
	private String referenceTitle;
	private String referenceCreated;
	private String referenceContent;
	private int usersNumber;
	private String usersName;
	public int getReferenceNumber() {
		return referenceNumber;
	}
	public void setReferenceNumber(int referenceNumber) {
		this.referenceNumber = referenceNumber;
	}
	public int getReferenceUsers() {
		return referenceUsers;
	}
	public void setReferenceUsers(int referenceUsers) {
		this.referenceUsers = referenceUsers;
	}
	public String getReferenceTitle() {
		return referenceTitle;
	}
	public void setReferenceTitle(String referenceTitle) {
		this.referenceTitle = referenceTitle;
	}
	public String getReferenceCreated() {
		return referenceCreated;
	}
	public void setReferenceCreated(String referenceCreated) {
		this.referenceCreated = referenceCreated;
	}
	public String getReferenceContent() {
		return referenceContent;
	}
	public void setReferenceContent(String referenceContent) {
		this.referenceContent = referenceContent;
	}
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
	@Override
	public String toString() {
		return "CareReferenceCheckDTO [referenceNumber=" + referenceNumber + ", referenceUsers=" + referenceUsers
				+ ", referenceTitle=" + referenceTitle + ", referenceCreated=" + referenceCreated
				+ ", referenceContent=" + referenceContent + ", usersNumber=" + usersNumber + ", usersName=" + usersName
				+ "]";
	}
	
	
	

}
