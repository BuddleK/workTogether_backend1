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
	
//	CREATE TABLE tbl_normal_users (
//		    normal_number NUMBER,
//		    users_name VARCHAR2(50) NOT NULL,
//		    users_email VARCHAR2(255) NOT NULL UNIQUE,
//		    users_phone VARCHAR2(30) NOT NULL,
//		    users_postsal_code VARCHAR2(10) NOT NULL,
//		    users_address_line1 VARCHAR2(255) NOT NULL,
//		    users_address_line2 VARCHAR2(255) NOT NULL,
//		    normal_users_level CHAR(1) NOT NULL CHECK (normal_users_level IN ('1', '2', '3', '4')),
//		    users_number NUMBER NOT NULL UNIQUE,
//		    CONSTRAINT pk_normal_users PRIMARY KEY(normal_number),
//		    CONSTRAINT fk_normal_users FOREIGN KEY (users_number) REFERENCES tbl_users (users_number) ON DELETE CASCADE
//		);
	
	private int matchNumber;
	private int careNumber;
	private int normalNumber;
	private String matchDate;
	private String matchMatchTime;
	private int matchPoints;
	private char matchStatus; //DEFAULT 'S' CHECK (match_status IN ('C', 'S', 'D')), -- C: 완료, S: 진행, D: 취소
	private String usersName;


	public String getUsersName() {
		return usersName;
	}


	public void setUsersName(String usersName) {
		this.usersName = usersName;
	}


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


	public char getMatchStatus() {
		return matchStatus;
	}


	public void setMatchStatus(char matchStatus) {
		this.matchStatus = matchStatus;
	}


	@Override
	public String toString() {
		return "CareMatchingDTO [matchNumber=" + matchNumber + ", careNumber=" + careNumber + ", normalNumber="
				+ normalNumber + ", matchDate=" + matchDate + ", matchMatchTime=" + matchMatchTime + ", matchPoints="
				+ matchPoints + ", matchStatus=" + matchStatus + "]";
	}
	
	
	
	
	
	
	
}
