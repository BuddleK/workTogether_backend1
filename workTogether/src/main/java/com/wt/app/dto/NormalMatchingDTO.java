package com.wt.app.dto;

public class NormalMatchingDTO {
//    match_number NUMBER PRIMARY KEY,
//    care_number NUMBER NOT NULL,
//    normal_number NUMBER NOT NULL,
//    match_date DATE NOT NULL,
//    match_time VARCHAR2(20) NOT NULL,
//    match_points NUMBER NOT NULL,
//    match_status CHAR(1) DEFAULT 'S' CHECK (match_status IN ('C', 'S', 'D'))
	int matchNumber;
	int careNumber;
	int NormalNumber;
	String matchDate;
	String matchTime;
	int matchPoints;
	char matchStatus;

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
		return NormalNumber;
	}

	public void setNormalNumber(int normalNumber) {
		NormalNumber = normalNumber;
	}

	public String getMatchDate() {
		return matchDate;
	}

	public void setMatchDate(String matchDate) {
		this.matchDate = matchDate;
	}

	public String getMatchTime() {
		return matchTime;
	}

	public void setMatchTime(String matchTime) {
		this.matchTime = matchTime;
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
		return "NormalMatchingDTO [matchNumber=" + matchNumber + ", careNumber=" + careNumber + ", NormalNumber="
				+ NormalNumber + ", matchDate=" + matchDate + ", matchTime=" + matchTime + ", matchPoints="
				+ matchPoints + ", matchStatus=" + matchStatus + "]";
	}

}
