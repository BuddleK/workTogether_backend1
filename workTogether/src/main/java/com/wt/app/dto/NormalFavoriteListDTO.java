package com.wt.app.dto;

public class NormalFavoriteListDTO {
	// 가게 찜 테이블
	private int favoritesNumber; // 찜 번호
	private int usersNumber; // 전체 유저 번호
	private int shopsNumber; // 가게 번호
	private String favoriteCreatedDate; // 생성 일

	// 가게 테이블
	private String shopsName; // 가게 이름
	private String shopsRoadAddress; // 가게 도로명 주소
	private String shopsPhone; // 가게 폰번호

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

	public int getShopsNumber() {
		return shopsNumber;
	}

	public void setShopsNumber(int shopsNumber) {
		this.shopsNumber = shopsNumber;
	}

	public String getFavoriteCreatedDate() {
		return favoriteCreatedDate;
	}

	public void setFavoriteCreatedDate(String favoriteCreatedDate) {
		this.favoriteCreatedDate = favoriteCreatedDate;
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
		return "NormalFavoriteListDTO [favoritesNumber=" + favoritesNumber + ", usersNumber=" + usersNumber
				+ ", shopsNumber=" + shopsNumber + ", favoriteCreatedDate=" + favoriteCreatedDate + ", shopsName="
				+ shopsName + ", shopsRoadAddress=" + shopsRoadAddress + ", shopsPhone=" + shopsPhone + "]";
	}

}
