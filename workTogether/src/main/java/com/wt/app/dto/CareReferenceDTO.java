package com.wt.app.dto;

public class CareReferenceDTO {

//	CREATE TABLE tbl_reference (
//		    reference_number NUMBER PRIMARY KEY,
//		    reference_users_number NUMBER NOT NULL,
//		    reference_title VARCHAR2(300) NOT NULL,
//		    reference_created_date DATE NOT NULL,
//		    reference_content VARCHAR2(300) NOT NULL,
//		    reference_answered_yn CHAR(1) DEFAULT 'N' CHECK (reference_answered_yn IN ('Y', 'N')),
//		    CONSTRAINT fk_ref_users FOREIGN KEY (reference_users_number) REFERENCES tbl_users(users_number) ON DELETE CASCADE
//		);

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
//
//
//	-- 돌봄 회원
//	CREATE TABLE tbl_care_users (
//	    care_number NUMBER,
//	    users_name VARCHAR2(50) NOT NULL,
//	    users_email VARCHAR2(255) NOT NULL UNIQUE,
//	    users_phone VARCHAR2(30) NOT NULL,
//	    users_postsal_code VARCHAR2(10) NOT NULL,
//	    users_address_line1 VARCHAR2(255) NOT NULL,
//	    users_address_line2 VARCHAR2(255) NOT NULL,
//	    care_intro_text VARCHAR2(150),
//	    care_certificate_files_num NUMBER NOT NULL,
//	    care_passbook_files_num NUMBER NOT NULL,
//	    care_profiles_photo_number NUMBER,
//	    care_accept CHAR(1) DEFAULT 'N' CHECK (care_accept IN ('Y', 'N')),
//	    users_number NUMBER NOT NULL UNIQUE,
//	    CONSTRAINT pk_care_users PRIMARY KEY(care_number),
//	    CONSTRAINT fk_care_users FOREIGN KEY (users_number) REFERENCES tbl_users (users_number),
//	    CONSTRAINT fk_care_cert_files FOREIGN KEY (care_certificate_files_num) REFERENCES tbl_files_license(license_files_number) ON DELETE CASCADE,
//	    CONSTRAINT fk_care_passbook_files FOREIGN KEY (care_passbook_files_num) REFERENCES tbl_files_account(account_files_number) ON DELETE CASCADE,
//	    CONSTRAINT fk_care_profiles_photo FOREIGN KEY (care_profiles_photo_number) REFERENCES tbl_files_profiles(profiles_files_number) ON DELETE CASCADE
//	);

	private int referenceNumber;
	private int referenceUsersNumber;
	private String referenceTitle;
	private String referenceCreatedDate;
	private char referenceAnsweredYN;

	private int usersNumber;
	private String usersName;

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

	public int getReferenceNumber() {
		return referenceNumber;
	}

	public void setReferenceNumber(int referenceNumber) {
		this.referenceNumber = referenceNumber;
	}

	public int getReferenceUsersNumber() {
		return referenceUsersNumber;
	}

	public void setReferenceUsersNumber(int referenceUsersNumber) {
		this.referenceUsersNumber = referenceUsersNumber;
	}

	public String getReferenceTitle() {
		return referenceTitle;
	}

	public void setReferenceTitle(String referenceTitle) {
		this.referenceTitle = referenceTitle;
	}

	public String getReferenceCreatedDate() {
		return referenceCreatedDate;
	}

	public void setReferenceCreatedDate(String referenceCreatedDate) {
		this.referenceCreatedDate = referenceCreatedDate;
	}

	public char getReferenceAnsweredYN() {
		return referenceAnsweredYN;
	}

	public void setReferenceAnsweredYN(char referenceAnsweredYN) {
		this.referenceAnsweredYN = referenceAnsweredYN;
	}

	@Override
	public String toString() {
		return "CareReferenceDTO [referenceNumber=" + referenceNumber + ", referenceUsersNumber=" + referenceUsersNumber
				+ ", referenceTitle=" + referenceTitle + ", referenceCreatedDate=" + referenceCreatedDate
				+ ", referenceAnsweredYN=" + referenceAnsweredYN + ", usersNumber=" + usersNumber + ", usersName="
				+ usersName + "]";
	}

}
