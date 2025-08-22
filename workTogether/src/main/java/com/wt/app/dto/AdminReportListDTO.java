package com.wt.app.dto;

public class AdminReportListDTO {
	private int reportNumber;
	private int postNumber;
	private int usersNumber;

	private String postTitle;
	private String postCreatedDate;
	private int postsViewCount;

	public int getReportNumber() {
		return reportNumber;
	}

	public void setReportNumber(int reportNumber) {
		this.reportNumber = reportNumber;
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

	public int getPostsViewCount() {
		return postsViewCount;
	}

	public void setPostsViewCount(int postsViewCount) {
		this.postsViewCount = postsViewCount;
	}

	@Override
	public String toString() {
		return "AdminReportListDTO [reportNumber=" + reportNumber + ", postNumber=" + postNumber + ", usersNumber="
				+ usersNumber + ", postTitle=" + postTitle + ", postCreatedDate=" + postCreatedDate
				+ ", postsViewCount=" + postsViewCount + "]";
	}

}
