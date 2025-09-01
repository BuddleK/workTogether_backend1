package com.wt.app.dto;

public class AdminReportListDTO {
	// 신고 테이블
	private int reportNumber; // 신고 번호
	private int postNumber; // 게시물 번호
	private int usersNumber; // 전체 유저 번호
	// 게시물 테이블
	private String postTitle; // 게시물 제목
	private String postCreatedDate; // 게시물 생성일
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

	public int getPostNumber() {
		return postNumber;
	}

	public void setPostNumber(int postNumber) {
		this.postNumber = postNumber;
	}

	public int getUsersNumber() {
		return usersNumber;
	}

	public void setUsersNumber(int usersNumber) {
		this.usersNumber = usersNumber;
	}

	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	public String getPostCreatedDate() {
		return postCreatedDate;
	}

	public void setPostCreatedDate(String postCreatedDate) {
		this.postCreatedDate = postCreatedDate;
	}

	@Override
	public String toString() {
		return "AdminReportListDTO [reportNumber=" + reportNumber + ", postNumber=" + postNumber + ", usersNumber="
				+ usersNumber + ", postTitle=" + postTitle + ", postCreatedDate=" + postCreatedDate
				+ ", postsReportCount=" + postsReportCount + "]";
	}

}
