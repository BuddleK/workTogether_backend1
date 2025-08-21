package com.wt.app.dto;

public class CareExitDTO {

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

//	-- 매칭
//	CREATE TABLE tbl_matchings (
//	    match_number NUMBER PRIMARY KEY,
//	    care_number NUMBER NOT NULL,
//	    normal_number NUMBER NOT NULL,
//	    match_date DATE NOT NULL,
//	    match_match_time VARCHAR2(20) NOT NULL,
//	    match_points NUMBER NOT NULL,
//	    match_status CHAR(1) DEFAULT 'S' CHECK (match_status IN ('C', 'S', 'D')), -- C: 완료, S: 진행, D: 취소
//	    CONSTRAINT fk_match_care FOREIGN KEY (care_number) REFERENCES tbl_care_users(care_number) ON DELETE CASCADE,
//	    CONSTRAINT fk_match_normal FOREIGN KEY (normal_number) REFERENCES tbl_normal_users(normal_number) ON DELETE CASCADE
//	);

	private int usersNumber;
	private int matchNumber;

	public int getUsersNumber() {
		return usersNumber;
	}

	public void setUsersNumber(int usersNumber) {
		this.usersNumber = usersNumber;
	}

	public int getMatchNumber() {
		return matchNumber;
	}

	public void setMatchNumber(int matchNumber) {
		this.matchNumber = matchNumber;
	}

	@Override
	public String toString() {
		return "CareExitDTO [usersNumber=" + usersNumber + ", matchNumber=" + matchNumber + "]";
	}

}
