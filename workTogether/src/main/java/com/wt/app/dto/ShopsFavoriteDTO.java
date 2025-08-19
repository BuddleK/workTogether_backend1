package com.wt.app.dto;

public class ShopsFavoriteDTO {
//    favorites_number NUMBER PRIMARY KEY,
//    users_number NUMBER NOT NULL,
//    favorites_shops_number NUMBER NOT NULL,
//    favorites_created_date DATE NOT NULL
	int favoritesNumber;
	int userNumber;
	int shopsNumber;
	int createdDate;

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

	@Override
	public String toString() {
		return "ShopsFavoriteDTO [favoritesNumber=" + favoritesNumber + ", userNumber=" + userNumber + ", shopsNumber="
				+ shopsNumber + ", createdDate=" + createdDate + "]";
	}

}
