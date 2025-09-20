package com.wt.app.dto;

public class AdminReportListDTO {
	private int postsNumber;
	private int reportPostNumber;
	private int reportUsersNumber;
	private int usersNumber;
	private String usersName;
	private String reportReason;
	
	public int getPostsNumber() {
		return postsNumber;
	}
	public void setPostsNumber(int postsNumber) {
		this.postsNumber = postsNumber;
	}
	public int getReportPostNumber() {
		return reportPostNumber;
	}
	public void setReportPostNumber(int reportPostNumber) {
		this.reportPostNumber = reportPostNumber;
	}
	public int getReportUsersNumber() {
		return reportUsersNumber;
	}
	public void setReportUsersNumber(int reportUsersNumber) {
		this.reportUsersNumber = reportUsersNumber;
	}
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
	public String getReportReason() {
		return reportReason;
	}
	public void setReportReason(String reportReason) {
		this.reportReason = reportReason;
	}
	
	@Override
	public String toString() {
		return "NormalSignDTO [usersNumber=" + usersNumber + ", reportPostNumber=" + reportPostNumber + ", reportUsersNumber=" + reportUsersNumber
				+ ", usersNumber=" + usersNumber + ", usersName=" + usersName + ", reportReason=" + reportReason + "]";
	}
	
	
	
}
