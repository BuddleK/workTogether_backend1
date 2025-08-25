package com.wt.app.dto;

public class PostReplyDTO {
	private int replyNumber;
	private int postsNumber;
	private int usersNumber;
	private String replyContent;
	private String replyCreatedDate;
	private String replyUpdatedDate;
	private String usersType;
	private String usersName;
	public int getReplyNumber() {
		return replyNumber;
	}
	public void setReplyNumber(int replyNumber) {
		this.replyNumber = replyNumber;
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
	public String getReplyContent() {
		return replyContent;
	}
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	public String getReplyCreatedDate() {
		return replyCreatedDate;
	}
	public void setReplyCreatedDate(String replyCreatedDate) {
		this.replyCreatedDate = replyCreatedDate;
	}
	public String getReplyUpdatedDate() {
		return replyUpdatedDate;
	}
	public void setReplyUpdatedDate(String replyUpdatedDate) {
		this.replyUpdatedDate = replyUpdatedDate;
	}
	public String getUsersType() {
		return usersType;
	}
	public void setUsersType(String usersType) {
		this.usersType = usersType;
	}
	public String getUsersName() {
		return usersName;
	}
	public void setUsersName(String usersName) {
		this.usersName = usersName;
	}
	@Override
	public String toString() {
		return "PostReplyDTO [replyNumber=" + replyNumber + ", postsNumber=" + postsNumber + ", usersNumber="
				+ usersNumber + ", replyContent=" + replyContent + ", replyCreatedDate=" + replyCreatedDate
				+ ", replyUpdatedDate=" + replyUpdatedDate + ", usersType=" + usersType + ", usersName=" + usersName
				+ "]";
	}
	
	
	
	
	
	
	
}
