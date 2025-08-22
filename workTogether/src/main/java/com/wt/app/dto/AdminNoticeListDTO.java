package com.wt.app.dto;

public class AdminNoticeListDTO {
	private int noticeNumber;
	private String noticeTitle;
	private String adminNumber;
	private int noticeViewCount;
	private String noticeCreatedDate;

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

	public String getAdminNumber() {
		return adminNumber;
	}

	public void setAdminNumber(String adminNumber) {
		this.adminNumber = adminNumber;
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

	@Override
	public String toString() {
		return "AdminNoticeListDTO [noticeNumber=" + noticeNumber + ", noticeTitle=" + noticeTitle + ", adminNumber="
				+ adminNumber + ", noticeViewCount=" + noticeViewCount + ", noticeCreatedDate=" + noticeCreatedDate
				+ "]";
	}

}
