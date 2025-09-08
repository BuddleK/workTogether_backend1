package com.wt.app.dto;

public class NormalMatchingDTO {
	// 매칭 테이블
	private int matchNumber; // 매칭 번호
	private String normalName; // 일반 회원 이름
	private String careName; // 돌봄 회원 이름
	private String matchDate; // 매칭 날짜
	private String matchMatchTime; // 매칭 시간
	private int matchPoints; // 매칭 포인트
	private String matchStatus; // 매칭 상태
	private String month;
	
	public int getMatchNumber() {
		return matchNumber;
	}
	public void setMatchNumber(int matchNumber) {
		this.matchNumber = matchNumber;
	}
	public String getNormalName() {
		return normalName;
	}
	public void setNormalName(String normalName) {
		this.normalName = normalName;
	}
	public String getCareName() {
		return careName;
	}
	public void setCareName(String careName) {
		this.careName = careName;
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
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	@Override
	public String toString() {
		return "NormalMatchingDTO [matchNumber=" + matchNumber + ", normalName=" + normalName + ", careName=" + careName
				+ ", matchDate=" + matchDate + ", matchMatchTime=" + matchMatchTime + ", matchPoints=" + matchPoints
				+ ", matchStatus=" + matchStatus + ", month=" + month + "]";
	}
}
