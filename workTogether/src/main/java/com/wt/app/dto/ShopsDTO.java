package com.wt.app.dto;

public class ShopsDTO {
	private int shopsNumber;
	private String shopsBranchName;
	private String shopsBizMidCategory;
	private String shopsRoadAddress;
	private String shopsAdminDong;
	private String shopsLegalDong;
	private int shopsLatitude;
	private int shopsLongitude;
	private String shopsPhone;
	private String shopsWorkingHours;
	private char shopsFloor1f;
	private String shopsRamp;
	private char shopsEntranceStep;
	private char shopsEntranceThresshold;
	private char shopsToiletStep;
	private char shopsToiletThreshold;
	private char shopsDisabledToilet;
	private char shopsElevator;
	private char shops_parking;
	private char shopsDisabledParking;
	private char shopsTakeout ;
	private String shopsIntroText ;
    private int shopsFilesNumber;
    private String shopsFilesName;
    private String shopsFilesPath;
    private String shopsFilesType;
	
	private char isFavorite;
	
	
	
	
	public String getShopsFilesName() {
		return shopsFilesName;
	}
	public void setShopsFilesName(String shopsFilesName) {
		this.shopsFilesName = shopsFilesName;
	}
	public String getShopsFilesPath() {
		return shopsFilesPath;
	}
	public void setShopsFilesPath(String shopsFilesPath) {
		this.shopsFilesPath = shopsFilesPath;
	}
	public String getShopsFilesType() {
		return shopsFilesType;
	}
	public void setShopsFilesType(String shopsFilesType) {
		this.shopsFilesType = shopsFilesType;
	}
	public int getShopsFilesNumber() {
		return shopsFilesNumber;
	}
	public void setShopsFilesNumber(int shopsFilesNumber) {
		this.shopsFilesNumber = shopsFilesNumber;
	}
	public char getIsFavorite() {
		return isFavorite;
	}
	public void setIsFavorite(char isFavorite) {
		this.isFavorite = isFavorite;
	}
	public int getShopsNumber() {
		return shopsNumber;
	}
	public void setShopsNumber(int shopsNumber) {
		this.shopsNumber = shopsNumber;
	}
	public String getShopsBranchName() {
		return shopsBranchName;
	}
	public void setShopsBranchName(String shopsBranchName) {
		this.shopsBranchName = shopsBranchName;
	}
	public String getShopsBizMidCategory() {
		return shopsBizMidCategory;
	}
	public void setShopsBizMidCategory(String shopsBizMidCategory) {
		this.shopsBizMidCategory = shopsBizMidCategory;
	}
	public String getShopsRoadAddress() {
		return shopsRoadAddress;
	}
	public void setShopsRoadAddress(String shopsRoadAddress) {
		this.shopsRoadAddress = shopsRoadAddress;
	}
	public String getShopsAdminDong() {
		return shopsAdminDong;
	}
	public void setShopsAdminDong(String shopsAdminDong) {
		this.shopsAdminDong = shopsAdminDong;
	}
	public String getShopsLegalDong() {
		return shopsLegalDong;
	}
	public void setShopsLegalDong(String shopsLegalDong) {
		this.shopsLegalDong = shopsLegalDong;
	}
	public int getShopsLatitude() {
		return shopsLatitude;
	}
	public void setShopsLatitude(int shopsLatitude) {
		this.shopsLatitude = shopsLatitude;
	}
	public int getShopsLongitude() {
		return shopsLongitude;
	}
	public void setShopsLongitude(int shopsLongitude) {
		this.shopsLongitude = shopsLongitude;
	}
	public String getShopsPhone() {
		return shopsPhone;
	}
	public void setShopsPhone(String shopsPhone) {
		this.shopsPhone = shopsPhone;
	}
	public String getShopsWorkingHours() {
		return shopsWorkingHours;
	}
	public void setShopsWorkingHours(String shopsWorkingHours) {
		this.shopsWorkingHours = shopsWorkingHours;
	}
	public char getShopsFloor1f() {
		return shopsFloor1f;
	}
	public void setShopsFloor1f(char shopsFloor1f) {
		this.shopsFloor1f = shopsFloor1f;
	}
	public String getShopsRamp() {
		return shopsRamp;
	}
	public void setShopsRamp(String shopsRamp) {
		this.shopsRamp = shopsRamp;
	}
	public char getShopsEntranceStep() {
		return shopsEntranceStep;
	}
	public void setShopsEntranceStep(char shopsEntranceStep) {
		this.shopsEntranceStep = shopsEntranceStep;
	}
	public char getShopsEntranceThresshold() {
		return shopsEntranceThresshold;
	}
	public void setShopsEntranceThresshold(char shopsEntranceThresshold) {
		this.shopsEntranceThresshold = shopsEntranceThresshold;
	}
	public char getShopsToiletStep() {
		return shopsToiletStep;
	}
	public void setShopsToiletStep(char shopsToiletStep) {
		this.shopsToiletStep = shopsToiletStep;
	}
	public char getShopsToiletThreshold() {
		return shopsToiletThreshold;
	}
	public void setShopsToiletThreshold(char shopsToiletThreshold) {
		this.shopsToiletThreshold = shopsToiletThreshold;
	}
	public char getShopsDisabledToilet() {
		return shopsDisabledToilet;
	}
	public void setShopsDisabledToilet(char shopsDisabledToilet) {
		this.shopsDisabledToilet = shopsDisabledToilet;
	}
	public char getShopsElevator() {
		return shopsElevator;
	}
	public void setShopsElevator(char shopsElevator) {
		this.shopsElevator = shopsElevator;
	}
	public char getShops_parking() {
		return shops_parking;
	}
	public void setShops_parking(char shops_parking) {
		this.shops_parking = shops_parking;
	}
	public char getShopsDisabledParking() {
		return shopsDisabledParking;
	}
	public void setShopsDisabledParking(char shopsDisabledParking) {
		this.shopsDisabledParking = shopsDisabledParking;
	}
	public char getShopsTakeout() {
		return shopsTakeout;
	}
	public void setShopsTakeout(char shopsTakeout) {
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
		return "ShopsDTO [shopsNumber=" + shopsNumber + ", shopsBranchName=" + shopsBranchName
				+ ", shopsBizMidCategory=" + shopsBizMidCategory + ", shopsRoadAddress=" + shopsRoadAddress
				+ ", shopsAdminDong=" + shopsAdminDong + ", shopsLegalDong=" + shopsLegalDong + ", shopsLatitude="
				+ shopsLatitude + ", shopsLongitude=" + shopsLongitude + ", shopsPhone=" + shopsPhone
				+ ", shopsWorkingHours=" + shopsWorkingHours + ", shopsFloor1f=" + shopsFloor1f + ", shopsRamp="
				+ shopsRamp + ", shopsEntranceStep=" + shopsEntranceStep + ", shopsEntranceThresshold="
				+ shopsEntranceThresshold + ", shopsToiletStep=" + shopsToiletStep + ", shopsToiletThreshold="
				+ shopsToiletThreshold + ", shopsDisabledToilet=" + shopsDisabledToilet + ", shopsElevator="
				+ shopsElevator + ", shops_parking=" + shops_parking + ", shopsDisabledParking=" + shopsDisabledParking
				+ ", shopsTakeout=" + shopsTakeout + ", shopsIntroText=" + shopsIntroText + ", shopsFilesNumber="
				+ shopsFilesNumber + ", shopsFilesName=" + shopsFilesName + ", shopsFilesPath=" + shopsFilesPath
				+ ", shopsFilesType=" + shopsFilesType + ", isFavorite=" + isFavorite + "]";
	}
	
	
	
	
	
	
	
	
	
}
