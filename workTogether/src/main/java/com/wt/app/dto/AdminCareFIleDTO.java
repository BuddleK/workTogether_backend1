package com.wt.app.dto;

public class AdminCareFIleDTO {
	private Integer fileNumber; // 각 파일 테이블 PK
	private String fileType;
	private String fileName;
	private String filePath;
	private Integer fileSizeBytes;
	private String createdDate;
	public Integer getFileNumber() {
		return fileNumber;
	}
	public void setFileNumber(Integer fileNumber) {
		this.fileNumber = fileNumber;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public Integer getFileSizeBytes() {
		return fileSizeBytes;
	}
	public void setFileSizeBytes(Integer fileSizeBytes) {
		this.fileSizeBytes = fileSizeBytes;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	@Override
	public String toString() {
		return "AdminCareFIleDTO [fileNumber=" + fileNumber + ", fileType=" + fileType + ", fileName=" + fileName
				+ ", filePath=" + filePath + ", fileSizeBytes=" + fileSizeBytes + ", createdDate=" + createdDate + "]";
	}
	
	
}
