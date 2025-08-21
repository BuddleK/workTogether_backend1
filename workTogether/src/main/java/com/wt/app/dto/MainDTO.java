package com.wt.app.dto;

public class MainDTO {
//	-- 회원
//	CREATE TABLE tbl_users (
//	    users_number NUMBER,
//	    users_id VARCHAR2(30) NOT NULL UNIQUE,
//	    users_password VARCHAR2(255) NOT NULL,
//	    users_type CHAR(1) CHECK (users_type IN ('C', 'N')) NOT NULL,
//	    users_created_date DATE DEFAULT sysdate,
//	    users_updated_date DATE DEFAULT sysdate,
//	    users_point number default 0,
//	    CONSTRAINT pk_tbl_users PRIMARY KEY (users_number)
//	);
//	
//	CREATE TABLE tbl_normal_users (
//		    normal_number NUMBER,
//		    users_name VARCHAR2(50) NOT NULL,
//		    users_email VARCHAR2(255) NOT NULL UNIQUE,
//		    users_phone VARCHAR2(30) NOT NULL,
//		    users_postsal_code VARCHAR2(10) NOT NULL,
//		    users_address_line1 VARCHAR2(255) NOT NULL,
//		    users_address_line2 VARCHAR2(255) NOT NULL,
//		    normal_users_level CHAR(1) NOT NULL CHECK (normal_users_level IN ('1', '2', '3', '4')),
//		    users_number NUMBER NOT NULL UNIQUE,
//		    CONSTRAINT pk_normal_users PRIMARY KEY(normal_number),
//		    CONSTRAINT fk_normal_users FOREIGN KEY (users_number) REFERENCES tbl_users (users_number) ON DELETE CASCADE
//		);
//
//		-- 돌봄 회원
//		CREATE TABLE tbl_care_users (
//		    care_number NUMBER,
//		    users_name VARCHAR2(50) NOT NULL,
//		    users_email VARCHAR2(255) NOT NULL UNIQUE,
//		    users_phone VARCHAR2(30) NOT NULL,
//		    users_postsal_code VARCHAR2(10) NOT NULL,
//		    users_address_line1 VARCHAR2(255) NOT NULL,
//		    users_address_line2 VARCHAR2(255) NOT NULL,
//		    care_intro_text VARCHAR2(150),
//		    care_certificate_files_num NUMBER NOT NULL,
//		    care_passbook_files_num NUMBER NOT NULL,
//		    care_profiles_photo_number NUMBER,
//		    care_accept CHAR(1) DEFAULT 'N' CHECK (care_accept IN ('Y', 'N')),
//		    users_number NUMBER NOT NULL UNIQUE,
//		    CONSTRAINT pk_care_users PRIMARY KEY(care_number),
//		    CONSTRAINT fk_care_users FOREIGN KEY (users_number) REFERENCES tbl_users (users_number),
//		    CONSTRAINT fk_care_cert_files FOREIGN KEY (care_certificate_files_num) REFERENCES tbl_files_license(license_files_number) ON DELETE CASCADE,
//		    CONSTRAINT fk_care_passbook_files FOREIGN KEY (care_passbook_files_num) REFERENCES tbl_files_account(account_files_number) ON DELETE CASCADE,
//		    CONSTRAINT fk_care_profiles_photo FOREIGN KEY (care_profiles_photo_number) REFERENCES tbl_files_profiles(profiles_files_number) ON DELETE CASCADE
//		);
//		
//	-- 날짜
//	CREATE TABLE tbl_day (
//	    care_number NUMBER PRIMARY KEY,
//	    day_monday CHAR(1) DEFAULT 'N' CHECK (day_monday IN ('Y', 'N')),
//	    day_tuesday CHAR(1) DEFAULT 'N' CHECK (day_tuesday IN ('Y', 'N')),
//	    day_wednesday CHAR(1) DEFAULT 'N' CHECK (day_wednesday IN ('Y', 'N')),
//	    day_thursday CHAR(1) DEFAULT 'N' CHECK (day_thursday IN ('Y', 'N')),
//	    day_friday CHAR(1) DEFAULT 'N' CHECK (day_friday IN ('Y', 'N')),
//	    day_saturday CHAR(1) DEFAULT 'N' CHECK (day_saturday IN ('Y', 'N')),
//	    day_sunday CHAR(1) DEFAULT 'N' CHECK (day_sunday IN ('Y', 'N')),
//	    CONSTRAINT fk_day_care FOREIGN KEY (care_number) REFERENCES tbl_care_users(care_number) ON DELETE CASCADE
//	);
//	
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
//	
//	-- 뉴스 베너
//	CREATE TABLE tbl_news_banners (
//	    banner_news_number NUMBER PRIMARY KEY,
//	    admin_number NUMBER NOT NULL,
//	    banner_image_files_number NUMBER,
//	    banner_title VARCHAR2(300) NOT NULL,
//	    banner_content VARCHAR2(4000),
//	    banner_link_url VARCHAR2(1000) NOT NULL,
//	    banner_created_date DATE NOT NULL,
//	    banner_updated_date DATE,
//	    CONSTRAINT fk_banner_admin FOREIGN KEY (admin_number) REFERENCES tbl_admin(admin_number) ON DELETE CASCADE,
//	    CONSTRAINT fk_banner_image FOREIGN KEY (banner_image_files_number) REFERENCES tbl_files_banner(banner_files_number) ON DELETE CASCADE
//	);
//	
//	-- 게시글
//	CREATE TABLE tbl_posts (
//	    posts_number NUMBER PRIMARY KEY,
//	    posts_title VARCHAR2(300) NOT NULL,
//	    users_number NUMBER NOT NULL,
//	    posts_content VARCHAR2(4000) NOT NULL,
//	    posts_view_count NUMBER DEFAULT 0 NOT NULL,
//	    posts_created_date DATE NOT NULL,
//	    posts_updated_date DATE,
//	    posts_report_count NUMBER DEFAULT 0 NOT NULL,
//	    CONSTRAINT fk_posts_users FOREIGN KEY (users_number) REFERENCES tbl_users(users_number) ON DELETE CASCADE
//	);
	
	private int banner_news_number;
	private int banner_image_files_number;
	private String banner_title;
	private String banner_link_url;
	
	private int posts_number;
	private String posts_title;
	private int users_number;
	private String users_name;
	private String posts_created_date;
	
//지도 api
	
	private int care_number;
	private int care_profiles_photo_number;
	private String care_intro_text;

	private int favorites_shops_number;
	private String shops_name;
	public int getBanner_news_number() {
		return banner_news_number;
	}
	public void setBanner_news_number(int banner_news_number) {
		this.banner_news_number = banner_news_number;
	}
	public int getBanner_image_files_number() {
		return banner_image_files_number;
	}
	public void setBanner_image_files_number(int banner_image_files_number) {
		this.banner_image_files_number = banner_image_files_number;
	}
	public String getBanner_title() {
		return banner_title;
	}
	public void setBanner_title(String banner_title) {
		this.banner_title = banner_title;
	}
	public String getBanner_link_url() {
		return banner_link_url;
	}
	public void setBanner_link_url(String banner_link_url) {
		this.banner_link_url = banner_link_url;
	}
	public int getPosts_number() {
		return posts_number;
	}
	public void setPosts_number(int posts_number) {
		this.posts_number = posts_number;
	}
	public String getPosts_title() {
		return posts_title;
	}
	public void setPosts_title(String posts_title) {
		this.posts_title = posts_title;
	}
	public int getUsers_number() {
		return users_number;
	}
	public void setUsers_number(int users_number) {
		this.users_number = users_number;
	}
	public String getUsers_name() {
		return users_name;
	}
	public void setUsers_name(String users_name) {
		this.users_name = users_name;
	}
	public String getPosts_created_date() {
		return posts_created_date;
	}
	public void setPosts_created_date(String posts_created_date) {
		this.posts_created_date = posts_created_date;
	}
	public int getCare_number() {
		return care_number;
	}
	public void setCare_number(int care_number) {
		this.care_number = care_number;
	}
	public int getCare_profiles_photo_number() {
		return care_profiles_photo_number;
	}
	public void setCare_profiles_photo_number(int care_profiles_photo_number) {
		this.care_profiles_photo_number = care_profiles_photo_number;
	}
	public String getCare_intro_text() {
		return care_intro_text;
	}
	public void setCare_intro_text(String care_intro_text) {
		this.care_intro_text = care_intro_text;
	}
	public int getFavorites_shops_number() {
		return favorites_shops_number;
	}
	public void setFavorites_shops_number(int favorites_shops_number) {
		this.favorites_shops_number = favorites_shops_number;
	}
	public String getShops_name() {
		return shops_name;
	}
	public void setShops_name(String shops_name) {
		this.shops_name = shops_name;
	}
	@Override
	public String toString() {
		return "MainDTO [banner_news_number=" + banner_news_number + ", banner_image_files_number="
				+ banner_image_files_number + ", banner_title=" + banner_title + ", banner_link_url=" + banner_link_url
				+ ", posts_number=" + posts_number + ", posts_title=" + posts_title + ", users_number=" + users_number
				+ ", users_name=" + users_name + ", posts_created_date=" + posts_created_date + ", care_number="
				+ care_number + ", care_profiles_photo_number=" + care_profiles_photo_number + ", care_intro_text="
				+ care_intro_text + ", favorites_shops_number=" + favorites_shops_number + ", shops_name=" + shops_name
				+ "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
