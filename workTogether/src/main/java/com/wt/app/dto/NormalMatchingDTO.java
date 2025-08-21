package com.wt.app.dto;

public class NormalMatchingDTO {
	// 
	private int matchNumber;
	private int careNumber;
	private int normalNumber;
	private String matchDate;
	private String matchTime;
	private int matchPoints;
	private char matchStatus;

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
