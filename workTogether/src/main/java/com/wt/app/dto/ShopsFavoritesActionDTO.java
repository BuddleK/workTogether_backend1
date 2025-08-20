package com.wt.app.dto;

public class ShopsFavoritesActionDTO {
	private int favoritesNumber;
	private int userNumber;
	private int favoritesShopsNumber;
	private String favoritesCreatedDate;
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
	@Override
	public String toString() {
		return "ShopsFavorites [favoritesNumber=" + favoritesNumber + ", userNumber=" + userNumber
				+ ", favoritesShopsNumber=" + favoritesShopsNumber + ", favoritesCreatedDate=" + favoritesCreatedDate
				+ "]";
	}
	
	
	
}
