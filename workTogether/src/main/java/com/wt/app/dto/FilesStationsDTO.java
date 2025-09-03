package com.wt.app.dto;

public class FilesStationsDTO {
	private int stationsFilesNumber;
	private int stationsId;
	private String stationsFilesType;
	private String stationsFilesName;
	private String stationsFilesPath;
	private int stationsFilesSizeBytes;
	private String stationsCreatedDate;
	private int lineNumber;
	
	public int getStationsId() {
		return stationsId;
	}

	public void setStationsId(int stationsId) {
		this.stationsId = stationsId;
	}

	public int getLineNumber() {
		return lineNumber;
	}

	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}

	public int getStationsFilesNumber() {
		return stationsFilesNumber;
	}

	public void setStationsFilesNumber(int stationsFilesNumber) {
		this.stationsFilesNumber = stationsFilesNumber;
	}

	public String getStationsFilesType() {
		return stationsFilesType;
	}

	public void setStationsFilesType(String stationsFilesType) {
		this.stationsFilesType = stationsFilesType;
	}

	public String getStationsFilesName() {
		return stationsFilesName;
	}

	public void setStationsFilesName(String stationsFilesName) {
		this.stationsFilesName = stationsFilesName;
	}

	public String getStationsFilesPath() {
		return stationsFilesPath;
	}

	public void setStationsFilesPath(String stationsFilesPath) {
		this.stationsFilesPath = stationsFilesPath;
	}

	public int getStationsFilesSizeBytes() {
		return stationsFilesSizeBytes;
	}

	public void setStationsFilesSizeBytes(int stationsFilesSizeBytes) {
		this.stationsFilesSizeBytes = stationsFilesSizeBytes;
	}

	public String getStationsCreatedDate() {
		return stationsCreatedDate;
	}

	public void setStationsCreatedDate(String stationsCreatedDate) {
		this.stationsCreatedDate = stationsCreatedDate;
	}

	@Override
	public String toString() {
		return "FilesStationsDTO [stationsFilesNumber=" + stationsFilesNumber + ", stationsId=" + stationsId
				+ ", stationsFilesType=" + stationsFilesType + ", stationsFilesName=" + stationsFilesName
				+ ", stationsFilesPath=" + stationsFilesPath + ", stationsFilesSizeBytes=" + stationsFilesSizeBytes
				+ ", stationsCreatedDate=" + stationsCreatedDate + ", lineNumber=" + lineNumber + "]";
	}

}
