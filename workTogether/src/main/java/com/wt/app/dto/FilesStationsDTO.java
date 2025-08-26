package com.wt.app.dto;

public class FilesStationsDTO {
	private int stationsFilesNumber;
	private String stationsFilesType;
	private String stationsFilesName;
	private String stationsFilesPath;
	private int stationsFilesSizeBytes;
	private String stationsCreatedDate;

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
		return "FilesStationsDTO [stationsFilesNumber=" + stationsFilesNumber + ", stationsFilesType="
				+ stationsFilesType + ", stationsFilesName=" + stationsFilesName + ", stationsFilesPath="
				+ stationsFilesPath + ", stationsFilesSizeBytes=" + stationsFilesSizeBytes + ", stationsCreatedDate="
				+ stationsCreatedDate + "]";
	}

}
