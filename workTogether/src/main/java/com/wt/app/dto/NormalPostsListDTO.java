package com.wt.app.dto;

public class NormalPostsListDTO {
	// 게시물 테이블
	private int postsNumber; // 게시판 번호
	private int userNumber; // 전체 유저 번호
	private String postsTitle; // 게시판 제목
	private String postsCreatedDate; // 게시판 생성 일

	public int getPostsNumber() {
		return postsNumber;
	}

	public void setPostsNumber(int postsNumber) {
		this.postsNumber = postsNumber;
	}

	public int getUserNumber() {
		return userNumber;
	}

	public void setUserNumber(int userNumber) {
		this.userNumber = userNumber;
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
		return "NormalPostsListDTO [postsNumber=" + postsNumber + ", userNumber=" + userNumber + ", postsTitle="
				+ postsTitle + ", postsCreatedDate=" + postsCreatedDate + "]";
	}

}
