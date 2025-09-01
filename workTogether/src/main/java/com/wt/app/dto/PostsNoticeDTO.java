package com.wt.app.dto;

public class PostsNoticeDTO {
	private int rnum;
	private int noticeNumber;
	private String noticeTitle;
	private int adminNumber;
	private String adminName;
	private String noticeContent;
	private int noticeViewCount;
	private String noticeCreatedDate;
	private String noticeUpdatedDate;
	private int filesNumber;
	public int getRnum() {
		return rnum;
	}
	public void setRnum(int rnum) {
		this.rnum = rnum;
	}
	public int getNoticeNumber() {
		return noticeNumber;
	}
	public void setNoticeNumber(int noticeNumber) {
		this.noticeNumber = noticeNumber;
	}
	public String getNoticeTitle() {
		return noticeTitle;
	}
	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}
	public int getAdminNumber() {
		return adminNumber;
	}
	public void setAdminNumber(int adminNumber) {
		this.adminNumber = adminNumber;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getNoticeContent() {
		return noticeContent;
	}
	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}
	public int getNoticeViewCount() {
		return noticeViewCount;
	}
	public void setNoticeViewCount(int noticeViewCount) {
		this.noticeViewCount = noticeViewCount;
	}
	public String getNoticeCreatedDate() {
		return noticeCreatedDate;
	}
	public void setNoticeCreatedDate(String noticeCreatedDate) {
		this.noticeCreatedDate = noticeCreatedDate;
	}
	public String getNoticeUpdatedDate() {
		return noticeUpdatedDate;
	}
	public void setNoticeUpdatedDate(String noticeUpdatedDate) {
		this.noticeUpdatedDate = noticeUpdatedDate;
	}
	public int getFilesNumber() {
		return filesNumber;
	}
	public void setFilesNumber(int filesNumber) {
		this.filesNumber = filesNumber;
	}
	@Override
	public String toString() {
		return "PostsNoticeDTO [rnum=" + rnum + ", noticeNumber=" + noticeNumber + ", noticeTitle=" + noticeTitle
				+ ", adminNumber=" + adminNumber + ", adminName=" + adminName + ", noticeContent=" + noticeContent
				+ ", noticeViewCount=" + noticeViewCount + ", noticeCreatedDate=" + noticeCreatedDate
				+ ", noticeUpdatedDate=" + noticeUpdatedDate + ", filesNumber=" + filesNumber + "]";
	}
}
