package com.wt.app.dto;

public class AdminReportListDTO {
	// 신고 테이블
	private int reportNumber; // 신고 번호
	private int postsNumber; // 게시물 번호
	private int usersNumber; // 전체 유저 번호
	// 게시물 테이블
	private String postsTitle; // 게시물 제목
	private String postsCreatedDate; // 게시물 생성일
	private int postsReportCount; // 게시물 조회수

	public int getReportNumber() {
		return reportNumber;
	}

	public void setReportNumber(int reportNumber) {
		this.reportNumber = reportNumber;
	}

	public int getPostsReportCount() {
		return postsReportCount;
	}

	public void setPostsReportCount(int postsReportCount) {
		this.postsReportCount = postsReportCount;
	}

	public int getPostsNumber() {
		return postsNumber;
	}

	public void setPostsNumber(int postsNumber) {
		this.postsNumber = postsNumber;
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

	public String getPostsCreatedDate() {
		return postsCreatedDate;
	}

	public void setPostsCreatedDate(String postsCreatedDate) {
		this.postsCreatedDate = postsCreatedDate;
	}

	@Override
	public String toString() {
		return "AdminReportListDTO [reportNumber=" + reportNumber + ", postsNumber=" + postsNumber + ", usersNumber="
				+ usersNumber + ", postsTitle=" + postsTitle + ", postsCreatedDate=" + postsCreatedDate
				+ ", postsReportCount=" + postsReportCount + "]";
	}

}
