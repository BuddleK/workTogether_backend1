package com.wt.app.dto;

public class NormalPostsListDTO {
	private int postsNumber;
	private int userNumber;
	private String postsTitle;
	private String postsCreatedDate;

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
