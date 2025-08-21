package com.wt.app.dto;

public class NormalFavoriteListDTO {
	// 가게 찜 테이블
	private int favoritesNumber; // 찜 번호
	private int userNumber;	// 전체 유저 번호
	private int shopsNumber; // 가게 번호
	private int createdDate; // 생성 일

	// 가게 테이블
	private String shopsName; // 가게 이름
	private String shopsRoadAddr; // 가게 도로명 주소
	private String shopsPhone; // 가게 폰번호

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
