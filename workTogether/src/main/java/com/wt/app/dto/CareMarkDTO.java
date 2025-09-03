package com.wt.app.dto;

import java.util.List;

public class CareMarkDTO {

//	-- 가게 찜
//	CREATE TABLE tbl_shops_favorites (
//	    favorites_number NUMBER PRIMARY KEY,
//	    users_number NUMBER NOT NULL,
//	    favorites_shops_number NUMBER NOT NULL,
//	    favorites_created_date DATE NOT NULL,
//	    CONSTRAINT fk_fav_users FOREIGN KEY (users_number) REFERENCES tbl_users(users_number) ON DELETE CASCADE,
//	    CONSTRAINT fk_fav_shops FOREIGN KEY (favorites_shops_number) REFERENCES tbl_shops(shops_number) ON DELETE CASCADE,
//	    CONSTRAINT uq_users_shops UNIQUE (users_number, favorites_shops_number)
//	);

//	-- 가게
//	CREATE TABLE tbl_shops (
//	    shops_number NUMBER PRIMARY KEY,
//	    shops_name VARCHAR2(200) NOT NULL,
//	    shops_branch_name VARCHAR2(200),
//	    shops_biz_mid_category VARCHAR2(100) NOT NULL,
//	    shops_road_address VARCHAR2(255),
//	    shops_admin_dong VARCHAR2(100) NOT NULL,
//	    shops_legal_dong VARCHAR2(100) NOT NULL,
//	    shops_latitude NUMBER(10, 6) NOT NULL,
//	    shops_longitude NUMBER(10, 6) NOT NULL,
//	    shops_phone VARCHAR2(30),
//	    shops_working_hours VARCHAR2(255),
//	    shops_floor_1f CHAR(1) DEFAULT 'N' CHECK (shops_floor_1f IN ('Y', 'N')),
//	    shops_ramp CHAR(1) DEFAULT 'N' CHECK (shops_ramp IN ('Y', 'N')),
//	    shops_entrance_step CHAR(1) DEFAULT 'N' CHECK (shops_entrance_step IN ('Y', 'N')),
//	    shops_entrance_threshold CHAR(1) DEFAULT 'N' CHECK (shops_entrance_threshold IN ('Y', 'N')),
//	    shops_toilet_step CHAR(1) DEFAULT 'N' CHECK (shops_toilet_step IN ('Y', 'N')),
//	    shops_toilet_threshold CHAR(1) DEFAULT 'N' CHECK (shops_toilet_threshold IN ('Y', 'N')),
//	    shops_disabled_toilet CHAR(1) DEFAULT 'N' CHECK (shops_disabled_toilet IN ('Y', 'N')),
//	    shops_elevator CHAR(1) DEFAULT 'N' CHECK (shops_elevator IN ('Y', 'N')),
//	    shops_parking CHAR(1) DEFAULT 'N' CHECK (shops_parking IN ('Y', 'N')),
//	    shops_disabled_parking CHAR(1) DEFAULT 'N' CHECK (shops_disabled_parking IN ('Y', 'N')),
//	    shops_takeout CHAR(1) DEFAULT 'N' CHECK (shops_takeout IN ('Y', 'N')),
//	    shops_intro_text VARCHAR2(2000)
//	);

	private int favoritesNumber;
	private int usersNumber;
	private int favoritesShopsNumber;
	private String favoritesCreatedDate;

	private String shopsName;
	private int shopsNumber;
	private String shopsRoadAddress;
	private String shopsPhone;
	private List<CareMarkDTO> rows;

	public int getShopsNumber() {
		return shopsNumber;
	}

	public void setShopsNumber(int shopsNumber) {
		this.shopsNumber = shopsNumber;
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

	public List<CareMarkDTO> getrows() {
		return rows;
	}

	public void setrows(List<CareMarkDTO> rows) {
		this.rows = rows;
	}

	@Override
	public String toString() {
		return "CareMarkDTO [shopsNumber =" + shopsNumber + ", favoritesNumber=" + favoritesNumber + ", usersNumber=" + usersNumber
				+ ", favoritesShopsNumber=" + favoritesShopsNumber + ", favoritesCreatedDate=" + favoritesCreatedDate
				+ ", shopsName=" + shopsName + ", shopsRoadAddress=" + shopsRoadAddress + ", shopsPhone=" + shopsPhone
				+ "]";
	}

}
