package com.wt.app.dto;

public class MarkerDTO {

//	가게번호
//	가게이름
//	지점명
//	도로명주소
//	영업시간
//	전화번호
//	테이크아웃 여부
//	가게 설명

	private int shopsNumber;
	private String shopsName;
	private String shopsBranchName;
	private String shopsRoadAddress;
	private String shopsWorkingHours;
	private String shopsPhone;
	private String shopsTakeout;
	private String shopsIntroText;

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

	public String getShopsBranchName() {
		return shopsBranchName;
	}

	public void setShopsBranchName(String shopsBranchName) {
		this.shopsBranchName = shopsBranchName;
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
		return "MarkerDTO [shopsNumber=" + shopsNumber + ", shopsName=" + shopsName + ", shopsBranchName="
				+ shopsBranchName + ", shopsRoadAddress=" + shopsRoadAddress + ", shopsWorkingHours="
				+ shopsWorkingHours + ", shopsPhone=" + shopsPhone + ", shopsTakeout=" + shopsTakeout
				+ ", shopsIntroText=" + shopsIntroText + "]";
	}

}
