package com.wt.app.dto;

public class PostsDTO {
//    posts_number NUMBER PRIMARY KEY,
//    posts_title VARCHAR2(300) NOT NULL,
//    users_number NUMBER NOT NULL,
//    posts_content VARCHAR2(4000) NOT NULL,
//    posts_view_count NUMBER DEFAULT 0 NOT NULL,
//    posts_created_date DATE NOT NULL,
//    posts_updated_date DATE,
//    posts_report_count NUMBER DEFAULT 0 NOT NULL
	int postsNumber;
	String postsTitle;
	int userNumber;
	String postsContent;
	int viewCount;
	String createdDate;
	String updatedDate;
	int reportCount;

	public int getPostsNumber() {
		return postsNumber;
	}

	public void setPostsNumber(int postsNumber) {
		this.postsNumber = postsNumber;
	}

	public String getPostsTitle() {
		return postsTitle;
	}

	public void setPostsTitle(String postsTitle) {
		this.postsTitle = postsTitle;
	}

	public int getUserNumber() {
		return userNumber;
	}

	public void setUserNumber(int userNumber) {
		this.userNumber = userNumber;
	}

	public String getPostsContent() {
		return postsContent;
	}

	public void setPostsContent(String postsContent) {
		this.postsContent = postsContent;
	}

	public int getViewCount() {
		return viewCount;
	}

	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}

	public int getReportCount() {
		return reportCount;
	}

	public void setReportCount(int reportCount) {
		this.reportCount = reportCount;
	}

	@Override
	public String toString() {
		return "PostsDTO [postsNumber=" + postsNumber + ", postsTitle=" + postsTitle + ", userNumber=" + userNumber
				+ ", postsContent=" + postsContent + ", viewCount=" + viewCount + ", createdDate=" + createdDate
				+ ", updatedDate=" + updatedDate + ", reportCount=" + reportCount + "]";
	}

}
