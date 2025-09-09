package com.wt.app.dto;

public class AdminNoticeListDTO {
	// 공지 테이블
	private int noticeNumber; // 공지 번호
	private String noticeTitle; // 공지 제목
	private String adminNumber; // 관리자 번호
	private String adminName;	// 관리자 이름
	private int noticeViewCount; // 공지 조회 수
	private String noticeCreatedDate; // 공지 생성 일
	// 공지 상세에 보이는 부분
	private String noticeContent; // 공지 내용

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

	public String getNoticeContent() {
		return noticeContent;
	}

	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}

	@Override
	public String toString() {
		return "AdminNoticeListDTO [noticeNumber=" + noticeNumber + ", noticeTitle=" + noticeTitle + ", adminNumber="
				+ adminNumber + ", adminName=" + adminName + ", noticeViewCount=" + noticeViewCount
				+ ", noticeCreatedDate=" + noticeCreatedDate + ", noticeContent=" + noticeContent + "]";
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

}
