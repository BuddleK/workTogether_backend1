package com.wt.app.dto;

public class MarkerDTO {

//	가게번호
//	가게이름
//  위도
//  경도
	private int rnum;
	private int shopsNumber;
	private String shopsName;
	private String shopsLatitude;
	private String shopsLongitude;
	
	private String shopsRoadAddress;
	private String shopsWorkingHours;
	private String shopsPhone;
	private String shopsTakeout;
	private String shopsIntroText;
	public int getRnum() {
		return rnum;
	}
	public void setRnum(int rnum) {
		this.rnum = rnum;
	}
	public int getShopsNumber() {
		return shopsNumber;
	}
	public void setShopsNumber(int shopsNumber) {
		this.shopsNumber = shopsNumber;
	}
	public String getShopsName() {
		return shopsName;
	}
	public void setShopsName(String shopsName) {
		this.shopsName = shopsName;
	}
	public String getShopsLatitude() {
		return shopsLatitude;
	}
	public void setShopsLatitude(String shopsLatitude) {
		this.shopsLatitude = shopsLatitude;
	}
	public String getShopsLongitude() {
		return shopsLongitude;
	}
	public void setShopsLongitude(String shopsLongitude) {
		this.shopsLongitude = shopsLongitude;
	}
	public String getShopsRoadAddress() {
		return shopsRoadAddress;
	}
	public void setShopsRoadAddress(String shopsRoadAddress) {
		this.shopsRoadAddress = shopsRoadAddress;
	}
	public String getShopsWorkingHours() {
		return shopsWorkingHours;
	}
	public void setShopsWorkingHours(String shopsWorkingHours) {
		this.shopsWorkingHours = shopsWorkingHours;
	}
	public String getShopsPhone() {
		return shopsPhone;
	}
	public void setShopsPhone(String shopsPhone) {
		this.shopsPhone = shopsPhone;
	}
	public String getShopsTakeout() {
		return shopsTakeout;
	}
	public void setShopsTakeout(String shopsTakeout) {
		this.shopsTakeout = shopsTakeout;
	}
	public String getShopsIntroText() {
		return shopsIntroText;
	}
	public void setShopsIntroText(String shopsIntroText) {
		this.shopsIntroText = shopsIntroText;
	}
	@Override
	public String toString() {
		return "MarkerDTO [rnum=" + rnum + ", shopsNumber=" + shopsNumber + ", shopsName=" + shopsName
				+ ", shopsLatitude=" + shopsLatitude + ", shopsLongitude=" + shopsLongitude + ", shopsRoadAddress="
				+ shopsRoadAddress + ", shopsWorkingHours=" + shopsWorkingHours + ", shopsPhone=" + shopsPhone
				+ ", shopsTakeout=" + shopsTakeout + ", shopsIntroText=" + shopsIntroText + "]";
	}

	
}
