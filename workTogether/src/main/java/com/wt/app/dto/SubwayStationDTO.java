package com.wt.app.dto;

import java.util.List;

public class SubwayStationDTO {
	private int stationsId;
	private int lineNumber;
	private String stationsName;
	private String stationsAddress;
//	private List<T> stationsPhoto;

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

	public List<T> getStationsPhoto() {
		return stationsPhoto;
	}

	public void setStationsPhoto(List<T> stationsPhoto) {
		this.stationsPhoto = stationsPhoto;
	}

	@Override
	public String toString() {
		return "SubwayStationDTO [stationsId=" + stationsId + ", lineNumber=" + lineNumber + ", stationsName="
				+ stationsName + ", stationsAddress=" + stationsAddress + ", stationsPhoto=" + stationsPhoto + "]";
	}

}
