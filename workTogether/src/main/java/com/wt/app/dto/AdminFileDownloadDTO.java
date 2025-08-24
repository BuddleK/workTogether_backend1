package com.wt.app.dto;

public class AdminFileDownloadDTO {
	private String fileCategory;
	private int fileNumber;
	private String fileName;
	private String filePath;
	private String fileType;
	private int fileSizeBytes; 
	private String createdDate;
	public String getFileCategory() {
		return fileCategory;
	}
	public void setFileCategory(String fileCategory) {
		this.fileCategory = fileCategory;
	}
	public int getFileNumber() {
		return fileNumber;
	}
	public void setFileNumber(int fileNumber) {
		this.fileNumber = fileNumber;
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
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public int getFileSizeBytes() {
		return fileSizeBytes;
	}
	public void setFileSizeBytes(int fileSizeBytes) {
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
		return "AdminFileDownloadDTO [fileCategory=" + fileCategory + ", fileNumber=" + fileNumber + ", fileName="
				+ fileName + ", filePath=" + filePath + ", fileType=" + fileType + ", fileSizeBytes=" + fileSizeBytes
				+ ", createdDate=" + createdDate + "]";
	}
	
	
}
