package com.wt.app.dto;

public class NormalFavoriteListDTO {
	private int favoritesNumber;
	private int userNumber;
	private int shopsNumber;
	private int createdDate;

	private String shopsName;
	private String shopsRoadAddr;
	private String shopsPhone;

	public int getFavoritesNumber() {
		return favoritesNumber;
	}

	public void setFavoritesNumber(int favoritesNumber) {
		this.favoritesNumber = favoritesNumber;
	}

	public int getUserNumber() {
		return userNumber;
	}

	public void setUserNumber(int userNumber) {
		this.userNumber = userNumber;
	}

	public int getShopsNumber() {
		return shopsNumber;
	}

	public void setShopsNumber(int shopsNumber) {
		this.shopsNumber = shopsNumber;
	}

	public int getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(int createdDate) {
		this.createdDate = createdDate;
	}

	public String getShopsName() {
		return shopsName;
	}

	public void setShopsName(String shopsName) {
		this.shopsName = shopsName;
	}

	public String getShopsRoadAddr() {
		return shopsRoadAddr;
	}

	public void setShopsRoadAddr(String shopsRoadAddr) {
		this.shopsRoadAddr = shopsRoadAddr;
	}

	public String getShopsPhone() {
		return shopsPhone;
	}

	public void setShopsPhone(String shopsPhone) {
		this.shopsPhone = shopsPhone;
	}

	@Override
	public String toString() {
		return "NormalFavoriteListDTO [favoritesNumber=" + favoritesNumber + ", userNumber=" + userNumber
				+ ", shopsNumber=" + shopsNumber + ", createdDate=" + createdDate + ", shopsName=" + shopsName
				+ ", shopsRoadAddr=" + shopsRoadAddr + ", shopsPhone=" + shopsPhone + "]";
	}

}
