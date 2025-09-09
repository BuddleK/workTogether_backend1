package com.wt.app.dto;

public class NormalPostsListDTO {
	
	// 게시물 테이블
	private int postsNumber; // 게시판 번호
	private String usersName;
	private int usersNumber; // 전체 유저 번호
	private String postsTitle; // 게시판 제목
	private String postsCreatedDate; // 게시판 생성 일
	@Override
	public String toString() {
		return "NormalPostsListDTO [postsNumber=" + postsNumber + ", usersName=" + usersName + ", usersNumber="
				+ usersNumber + ", postsTitle=" + postsTitle + ", postsCreatedDate=" + postsCreatedDate + "]";
	}
	public int getPostsNumber() {
		return postsNumber;
	}
	public void setPostsNumber(int postsNumber) {
		this.postsNumber = postsNumber;
	}
	public String getUsersName() {
		return usersName;
	}
	public void setUsersName(String usersName) {
		this.usersName = usersName;
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
	
	
	

	

}
