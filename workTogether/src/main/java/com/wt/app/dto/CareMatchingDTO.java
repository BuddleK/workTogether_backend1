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
	
	int matchNumber;
	int careNumber;
	int normalNumber;
	String matchDate;
	String matchMatchTime;
	int matchPoints;
	char matchStatus; //DEFAULT 'S' CHECK (match_status IN ('C', 'S', 'D')), -- C: 완료, S: 진행, D: 취소
	
	@Override
	public String toString() {
		return "CareMatchingDTO [matchNumber=" + matchNumber + ", careNumber=" + careNumber + ", normalNumber="
				+ normalNumber + ", matchDate=" + matchDate + ", matchMatchTime=" + matchMatchTime + ", matchPoints="
				+ matchPoints + ", matchStatus=" + matchStatus + "]";
	}
	
	
	
	
	
	
	
}
