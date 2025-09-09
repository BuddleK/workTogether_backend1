package com.wt.app.dto;

public class PostsListDTO {
	
	private int rnum;
	private int postsNumber;
	private String postsTitle;
	private int usersNumber;
	private String usersName;
	private int postsViewCount;
	private String postsCreatedDate;
	
	
	public int getRnum() {
		return rnum;
	}
	public void setRnum(int rnum) {
		this.rnum = rnum;
	}
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
	@Override
	public String toString() {
		return "PostsListDTO [rnum=" + rnum + ", postsNumber=" + postsNumber + ", postsTitle=" + postsTitle
				+ ", usersNumber=" + usersNumber + ", usersName=" + usersName + ", postsViewCount=" + postsViewCount
				+ ", postsCreatedDate=" + postsCreatedDate + "]";
	}
	
	
}
