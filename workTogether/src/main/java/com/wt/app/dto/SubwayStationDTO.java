package com.wt.app.dto;

import java.util.List;

public class SubwayStationDTO<T> {
//  stations_id NUMBER PRIMARY KEY,
//  line_number NUMBER NOT NULL,
//  stations_name VARCHAR2(100) NOT NULL,
//  stations_address VARCHAR2(100) NOT NULL,
//  stations_photo_id NUMBER,
	int stationsId;
	int lineNumber;
	String stationsName;
	String stationsAddress;
	List<T> stationsPhoto;
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
