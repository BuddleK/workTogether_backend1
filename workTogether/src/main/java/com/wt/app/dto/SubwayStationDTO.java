package com.wt.app.dto;

import java.util.List;

public class SubwayStationDTO {
	private int stationsId;
	private int lineNumber;
	private String stationsName;
	private String stationsAddress;
	private List<FilesStationsDTO> stationsPhoto;
	private Double latitude;
    private Double longitude;
    private String lineName;
    private String stationsFilesName;
    private String stationsFilesPath;

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

	public String getStationsName() {
		return stationsName;
	}

	public void setStationsName(String stationsName) {
		this.stationsName = stationsName;
	}

	public String getStationsAddress() {
		return stationsAddress;
	}

	public void setStationsAddress(String stationsAddress) {
		this.stationsAddress = stationsAddress;
	}

	public List<FilesStationsDTO> getStationsPhoto() {
		return stationsPhoto;
	}

	public void setStationsPhoto(List<FilesStationsDTO> stationsPhoto) {
		this.stationsPhoto = stationsPhoto;
	}

	
	@Override
	public String toString() {
		return "SubwayStationDTO [stationsId=" + stationsId + ", lineNumber=" + lineNumber + ", stationsName="
				+ stationsName + ", stationsAddress=" + stationsAddress + ", latitude=" + latitude + ", longitude=" + longitude + ", stationsPhoto=" + stationsPhoto + "]";
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public String getLineName() {
		return lineName;
	}

	public void setLineName(String lineName) {
		this.lineName = lineName;
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

}
