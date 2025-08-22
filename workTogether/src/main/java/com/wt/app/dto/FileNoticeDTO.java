package com.wt.app.dto;

public class FileNoticeDTO {
	private Integer FilesNumber; //파일 번호
    private String FilesType; // 유형
    private String FilesName; // 파일 이름
    private String FilesPath; // png나 jsp
    private Long FilesSizeBytes; // 파일 크기
    private String CreatedDate; // 생성날짜
	public Integer getFilesNumber() {
		return FilesNumber;
	}
	public void setFilesNumber(Integer filesNumber) {
		FilesNumber = filesNumber;
	}
	public String getFilesType() {
		return FilesType;
	}
	public void setFilesType(String filesType) {
		FilesType = filesType;
	}
	public String getFilesName() {
		return FilesName;
	}
	public void setFilesName(String filesName) {
		FilesName = filesName;
	}
	public String getFilesPath() {
		return FilesPath;
	}
	public void setFilesPath(String filesPath) {
		FilesPath = filesPath;
	}
	public Long getFilesSizeBytes() {
		return FilesSizeBytes;
	}
	public void setFilesSizeBytes(Long filesSizeBytes) {
		FilesSizeBytes = filesSizeBytes;
	}
	public String getCreatedDate() {
		return CreatedDate;
	}
	public void setCreatedDate(String createdDate) {
		CreatedDate = createdDate;
	}
	@Override
	public String toString() {
		return "FileNoticeDTO [FilesNumber=" + FilesNumber + ", FilesType=" + FilesType + ", FilesName=" + FilesName
				+ ", FilesPath=" + FilesPath + ", FilesSizeBytes=" + FilesSizeBytes + ", CreatedDate=" + CreatedDate
				+ "]";
	}

    
}
