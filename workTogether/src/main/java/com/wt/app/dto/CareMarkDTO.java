package com.wt.app.dto;


public class CareMarkDTO {
	
	private int rnum;

	private int favoritesNumber;
	private int usersNumber;
	private int favoritesShopsNumber;
	private String favoritesCreatedDate;

	private int shopsNumber;
	private String shopsName;
	private String shopsRoadAddress;
	private String shopsPhone;
	
	public int getRnum() {
		return rnum;
	}
	public void setRnum(int rnum) {
		this.rnum = rnum;
	}
	public int getFavoritesNumber() {
		return favoritesNumber;
	}
	public void setFavoritesNumber(int favoritesNumber) {
		this.favoritesNumber = favoritesNumber;
	}
	public int getUsersNumber() {
		return usersNumber;
	}
	public void setUsersNumber(int usersNumber) {
		this.usersNumber = usersNumber;
	}
	public int getFavoritesShopsNumber() {
		return favoritesShopsNumber;
	}
	public void setFavoritesShopsNumber(int favoritesShopsNumber) {
		this.favoritesShopsNumber = favoritesShopsNumber;
	}
	public String getFavoritesCreatedDate() {
		return favoritesCreatedDate;
	}
	public void setFavoritesCreatedDate(String favoritesCreatedDate) {
		this.favoritesCreatedDate = favoritesCreatedDate;
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
	public String getShopsRoadAddress() {
		return shopsRoadAddress;
	}
	public void setShopsRoadAddress(String shopsRoadAddress) {
		this.shopsRoadAddress = shopsRoadAddress;
	}
	public String getShopsPhone() {
		return shopsPhone;
	}
	public void setShopsPhone(String shopsPhone) {
		this.shopsPhone = shopsPhone;
	}
	@Override
	public String toString() {
		return "CareMarkDTO [rnum=" + rnum + ", favoritesNumber=" + favoritesNumber + ", usersNumber=" + usersNumber
				+ ", favoritesShopsNumber=" + favoritesShopsNumber + ", favoritesCreatedDate=" + favoritesCreatedDate
				+ ", shopsNumber=" + shopsNumber + ", shopsName=" + shopsName + ", shopsRoadAddress=" + shopsRoadAddress
				+ ", shopsPhone=" + shopsPhone + "]";
	}

}
