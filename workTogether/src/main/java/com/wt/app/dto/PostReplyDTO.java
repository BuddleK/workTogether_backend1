package com.wt.app.dto;

public class PostReplyDTO {
	private int replyNumber;
	private int postsNumber;
	private int usersNumber;
	private String replyContent;
	private String replyCreatedDate;
	private String replyUpdatedDate;
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
	@Override
	public String toString() {
		return "ReplyDTO [replyNumber=" + replyNumber + ", postsNumber=" + postsNumber + ", usersNumber=" + usersNumber
				+ ", replyContent=" + replyContent + ", replyCreatedDate=" + replyCreatedDate + ", replyUpdatedDate="
				+ replyUpdatedDate + "]";
	}
	
	
	
	
}
