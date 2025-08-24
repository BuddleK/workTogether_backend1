package com.wt.app.dto;

public class FileNoticeDTO {
	private Integer noticeFilesNumber;
	private String noticeFilesType;
	private String noticeFilesName;
	private String noticeFilesPath;
	private Long noticeFilesSizeBytes;
	private String createdDate;
	public Integer getNoticeFilesNumber() {
		return noticeFilesNumber;
	}
	public void setNoticeFilesNumber(Integer noticeFilesNumber) {
		this.noticeFilesNumber = noticeFilesNumber;
	}
	public String getNoticeFilesType() {
		return noticeFilesType;
	}
	public void setNoticeFilesType(String noticeFilesType) {
		this.noticeFilesType = noticeFilesType;
	}
	public String getNoticeFilesName() {
		return noticeFilesName;
	}
	public void setNoticeFilesName(String noticeFilesName) {
		this.noticeFilesName = noticeFilesName;
	}
	public String getNoticeFilesPath() {
		return noticeFilesPath;
	}
	public void setNoticeFilesPath(String noticeFilesPath) {
		this.noticeFilesPath = noticeFilesPath;
	}
	public Long getNoticeFilesSizeBytes() {
		return noticeFilesSizeBytes;
	}
	public void setNoticeFilesSizeBytes(Long noticeFilesSizeBytes) {
		this.noticeFilesSizeBytes = noticeFilesSizeBytes;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	@Override
	public String toString() {
		return "FileNoticeDTO [noticeFilesNumber=" + noticeFilesNumber + ", noticeFilesType=" + noticeFilesType
				+ ", noticeFilesName=" + noticeFilesName + ", noticeFilesPath=" + noticeFilesPath
				+ ", noticeFilesSizeBytes=" + noticeFilesSizeBytes + ", createdDate=" + createdDate + "]";
	}
	
}
