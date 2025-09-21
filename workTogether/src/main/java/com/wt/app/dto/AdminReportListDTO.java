package com.wt.app.dto;

public class AdminReportListDTO {
	// 신고 테이블
	private int reportNumber; // 신고 번호
	private int postsNumber; // 게시물 번호
	private int reportUsersNumber;
	// 게시물 테이블
	private int usersNumber; // 전체 유저 번호
	private String postsTitle; // 게시물 제목
	private String postsContent;
	private int postsViewCount;
	private String postsCreatedDate; // 게시물 생성일
	private String postsUpdateDate;
	private int postsReportCount; // 게시물 조회수
	private String usersName;
	private String reportReason;
	
	public int getReportNumber() {
		return reportNumber;
	}

	public void setReportNumber(int reportNumber) {
		this.reportNumber = reportNumber;
	}

	public int getPostsNumber() {
		return postsNumber;
	}

	public void setPostsNumber(int postsNumber) {
		this.postsNumber = postsNumber;
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

	public String getPostsTitle() {
		return postsTitle;
	}

	public void setPostsTitle(String postsTitle) {
		this.postsTitle = postsTitle;
	}

	public String getPostsContent() {
		return postsContent;
	}

	public void setPostsContent(String postsContent) {
		this.postsContent = postsContent;
	}

	public int getPostsViewCount() {
		return postsViewCount;
	}

	public void setPostsViewCount(int postsViewCount) {
		this.postsViewCount = postsViewCount;
	}

	public String getPostsCreatedDate() {
		return postsCreatedDate;
	}

	public void setPostsCreatedDate(String postsCreatedDate) {
		this.postsCreatedDate = postsCreatedDate;
	}

	public String getPostsUpdateDate() {
		return postsUpdateDate;
	}

	public void setPostsUpdateDate(String postsUpdateDate) {
		this.postsUpdateDate = postsUpdateDate;
	}

	public int getPostsReportCount() {
		return postsReportCount;
	}

	public void setPostsReportCount(int postsReportCount) {
		this.postsReportCount = postsReportCount;
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
		return "AdminReportListDTO [reportNumber=" + reportNumber + ", postsNumber=" + postsNumber
				+ ", reportUsersNumber=" + reportUsersNumber + ", usersNumber=" + usersNumber + ", postsTitle="
				+ postsTitle + ", postsContent=" + postsContent + ", postsViewCount=" + postsViewCount
				+ ", postsCreatedDate=" + postsCreatedDate + ", postsUpdateDate=" + postsUpdateDate
				+ ", postsReportCount=" + postsReportCount + ", usersName=" + usersName + ", reportReason=" + reportReason + "]";
	}

	
	

	

}
