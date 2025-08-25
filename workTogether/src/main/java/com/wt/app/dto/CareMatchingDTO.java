package com.wt.app.dto;

public class CareMatchingDTO {

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
//	SELECT * FROM TBL_USERS;
//
//	CREATE TABLE tbl_normal_users (
//	    users_number NUMBER,
//	    users_name VARCHAR2(50) NOT NULL,
//	    users_email VARCHAR2(255) NOT NULL UNIQUE,
//	    users_phone VARCHAR2(30) NOT NULL,
//	    users_postsal_code VARCHAR2(10) NOT NULL,
//	    users_address_line1 VARCHAR2(255) NOT NULL,
//	    users_address_line2 VARCHAR2(255) NOT NULL,
//	    normal_users_level CHAR(1) NOT NULL CHECK (normal_users_level IN ('1', '2', '3', '4')),
//	    CONSTRAINT pk_normal_users PRIMARY KEY(users_number),
//	    CONSTRAINT fk_normal_users FOREIGN KEY (users_number) REFERENCES tbl_users (users_number) ON DELETE CASCADE
//	);
//
//	-- 돌봄 회원
//	CREATE TABLE tbl_care_users (
//	    users_number NUMBER,
//	    users_name VARCHAR2(50) NOT NULL,
//	    users_email VARCHAR2(255) NOT NULL UNIQUE,
//	    users_phone VARCHAR2(30) NOT NULL,
//	    
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

	private int matchNumber;
	private int careNumber;
	private int normalNumber;
	private String matchDate;
	private String matchMatchTime;
	private int matchPoints;
	private String matchStatus; // DEFAULT 'S' CHECK (match_status IN ('C', 'S', 'D')), -- C: 완료, S: 진행, D: 취소
	private String usersName;
	private int usersNumber;
	private String usersId;
	public int getMatchNumber() {
		return matchNumber;
	}
	public void setMatchNumber(int matchNumber) {
		this.matchNumber = matchNumber;
	}
	public int getCareNumber() {
		return careNumber;
	}
	public void setCareNumber(int careNumber) {
		this.careNumber = careNumber;
	}
	public int getNormalNumber() {
		return normalNumber;
	}
	public void setNormalNumber(int normalNumber) {
		this.normalNumber = normalNumber;
	}
	public String getMatchDate() {
		return matchDate;
	}
	public void setMatchDate(String matchDate) {
		this.matchDate = matchDate;
	}
	public String getMatchMatchTime() {
		return matchMatchTime;
	}
	public void setMatchMatchTime(String matchMatchTime) {
		this.matchMatchTime = matchMatchTime;
	}
	public int getMatchPoints() {
		return matchPoints;
	}
	public void setMatchPoints(int matchPoints) {
		this.matchPoints = matchPoints;
	}
	public String getMatchStatus() {
		return matchStatus;
	}
	public void setMatchStatus(String matchStatus) {
		this.matchStatus = matchStatus;
	}
	public String getUsersName() {
		return usersName;
	}
	public void setUsersName(String usersName) {
		this.usersName = usersName;
	}
	public int getUsersNumber() {
		return usersNumber;
	}
	public void setUsersNumber(int usersNumber) {
		this.usersNumber = usersNumber;
	}
	public String getUsersId() {
		return usersId;
	}
	public void setUsersId(String usersId) {
		this.usersId = usersId;
	}
	@Override
	public String toString() {
		return "CareMatchingDTO [matchNumber=" + matchNumber + ", careNumber=" + careNumber + ", normalNumber="
				+ normalNumber + ", matchDate=" + matchDate + ", matchMatchTime=" + matchMatchTime + ", matchPoints="
				+ matchPoints + ", matchStatus=" + matchStatus + ", usersName=" + usersName + ", usersNumber="
				+ usersNumber + ", usersId=" + usersId + "]";
	}


	

}
