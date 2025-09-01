package com.wt.app.dto;

public class CareExitDTO {
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
//	-- 돌봄 회원
//	CREATE TABLE tbl_care_users (
//	    users_number NUMBER,
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
//	    CONSTRAINT pk_care_users PRIMARY KEY(users_number ),
//	    CONSTRAINT fk_care_users FOREIGN KEY (users_number) REFERENCES tbl_users (users_number),
//	    CONSTRAINT fk_care_cert_files FOREIGN KEY (care_certificate_files_num) REFERENCES tbl_files_license(license_files_number) ON DELETE CASCADE,
//	    CONSTRAINT fk_care_passbook_files FOREIGN KEY (care_passbook_files_num) REFERENCES tbl_files_account(account_files_number) ON DELETE CASCADE,
//	    CONSTRAINT fk_care_profiles_photo FOREIGN KEY (care_profiles_photo_number) REFERENCES tbl_files_profiles(profiles_files_number) ON DELETE CASCADE
//	);
//
//	-- 매칭
//	CREATE TABLE tbl_matchings (
//	    match_number NUMBER PRIMARY KEY,
//	    care_number NUMBER NOT NULL,
//	    normal_number NUMBER NOT NULL,
//	    match_date DATE NOT NULL,
//	    match_match_time VARCHAR2(20) NOT NULL,
//	    match_points NUMBER NOT NULL,
//	    match_status CHAR(1) DEFAULT 'S' CHECK (match_status IN ('C', 'S', 'D')), -- C: 완료, S: 진행, D: 취소
//	    CONSTRAINT fk_match_care FOREIGN KEY (care_number) REFERENCES tbl_care_users(users_number ) ON DELETE CASCADE,
//	    CONSTRAINT fk_match_normal FOREIGN KEY (normal_number) REFERENCES tbl_normal_users(users_number) ON DELETE CASCADE
//	);

	private int usersNumber;
	private int careNumber;
	private String matchStatus;
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
	public String getMatchStatus() {
		return matchStatus;
	}
	public void setMatchStatus(String matchStatus) {
		this.matchStatus = matchStatus;
	}
	@Override
	public String toString() {
		return "CareExitDTO [usersNumber=" + usersNumber + ", careNumber=" + careNumber + ", matchStatus=" + matchStatus
				+ "]";
	}
	


}
