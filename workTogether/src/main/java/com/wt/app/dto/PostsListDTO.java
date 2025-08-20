package com.wt.app.dto;

public class PostsListDTO {
	
//	게시글 번호
//	게시글 제목
//	작성자 번호
//	작성자 이름
//	조회수
//	작성일
	
	private int postsNumber;
	private String postsTitle;
	private int usersNumber;
	private String usersName;
	private int viewCount;
	private String createdDate;
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
	@Override
	public String toString() {
		return "PostsListDTO [postsNumber=" + postsNumber + ", postsTitle=" + postsTitle + ", usersNumber="
				+ usersNumber + ", usersName=" + usersName + ", viewCount=" + viewCount + ", createdDate=" + createdDate
				+ "]";
	}
	
}
