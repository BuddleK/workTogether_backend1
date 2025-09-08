package com.wt.app.dto;

public class PostsDTO {
//	PK 번호
//	게시글 번호
//	게시글 제목
//	작성자 번호
//	작성자 이름
//	조회수
//	작성일
//	내용

	private int postsNumber;
	private String postsTitle;
	private int usersNumber;
	private String usersName;
	private int postsViewCount;
	private String postsCreatedDate;
	private String postsUpdatedDate;
	private String postsContent;
	
	private int reportPostNumber;
	private int reportUsersNumber;
	private String reportReason;
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
	public String getPostsUpdatedDate() {
		return postsUpdatedDate;
	}
	public void setPostsUpdatedDate(String postsUpdatedDate) {
		this.postsUpdatedDate = postsUpdatedDate;
	}
	public String getPostsContent() {
		return postsContent;
	}
	public void setPostsContent(String postsContent) {
		this.postsContent = postsContent;
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
	public String getReportReason() {
		return reportReason;
	}
	public void setReportReason(String reportReason) {
		this.reportReason = reportReason;
	}
	@Override
	public String toString() {
		return "PostsDTO [postsNumber=" + postsNumber + ", postsTitle=" + postsTitle + ", usersNumber=" + usersNumber
				+ ", usersName=" + usersName + ", postsViewCount=" + postsViewCount + ", postsCreatedDate="
				+ postsCreatedDate + ", postsUpdatedDate=" + postsUpdatedDate + ", postsContent=" + postsContent
				+ ", reportPostNumber=" + reportPostNumber + ", reportUsersNumber=" + reportUsersNumber
				+ ", reportReason=" + reportReason + "]";
	}
	
	
	
	
	
	
}
