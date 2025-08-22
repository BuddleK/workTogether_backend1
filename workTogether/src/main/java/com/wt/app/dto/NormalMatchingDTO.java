package com.wt.app.dto;

public class NormalMatchingDTO {
	// 매칭 테이블
	private int matchNumber; // 매칭 번호
	private int careNumber;	// 돌봄 회원 번호
	private int normalNumber; // 일반 회원 번호
	private String matchDate; // 매칭 날짜
	private String matchTime; // 매칭 시간
	private int matchPoints; // 매칭 포인트
	private char matchStatus; // 매칭 상태

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
		return "NormalMatchingDTO [matchNumber=" + matchNumber + ", careNumber=" + careNumber + ", normalNumber="
				+ normalNumber + ", matchDate=" + matchDate + ", matchTime=" + matchTime + ", matchPoints="
				+ matchPoints + ", matchStatus=" + matchStatus + "]";
	}

}
