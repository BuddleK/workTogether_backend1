package com.wt.app.dto;

public class FilesBannerDTO {
//	-- 파일 뉴스 베너
//	CREATE TABLE tbl_files_banner (
//	    banner_files_number NUMBER PRIMARY KEY,
//	    banner_files_type VARCHAR2(30) NOT NULL,
//	    banner_files_name VARCHAR2(255) NOT NULL,
//	    banner_files_path VARCHAR2(1000) NOT NULL,
//	    banner_files_size_bytes NUMBER,
//	    banner_created_date DATE NOT NULL
//	);
	private int bannerFilesNumber;
	private String bannerFilesType;
	private String bannerFilesName;
	private String bannerFilesPath;
	private int bannerFilesSizeBytes;
	private String bannerCreatedDate;
	public int getBannerFilesNumber() {
		return bannerFilesNumber;
	}
	public void setBannerFilesNumber(int bannerFilesNumber) {
		this.bannerFilesNumber = bannerFilesNumber;
	}
	public String getBannerFilesType() {
		return bannerFilesType;
	}
	public void setBannerFilesType(String bannerFilesType) {
		this.bannerFilesType = bannerFilesType;
	}
	public String getBannerFilesName() {
		return bannerFilesName;
	}
	public void setBannerFilesName(String bannerFilesName) {
		this.bannerFilesName = bannerFilesName;
	}
	public String getBannerFilesPath() {
		return bannerFilesPath;
	}
	public void setBannerFilesPath(String bannerFilesPath) {
		this.bannerFilesPath = bannerFilesPath;
	}
	public int getBannerFilesSizeBytes() {
		return bannerFilesSizeBytes;
	}
	public void setBannerFilesSizeBytes(int bannerFilesSizeBytes) {
		this.bannerFilesSizeBytes = bannerFilesSizeBytes;
	}
	public String getBannerCreatedDate() {
		return bannerCreatedDate;
	}
	public void setBannerCreatedDate(String bannerCreatedDate) {
		this.bannerCreatedDate = bannerCreatedDate;
	}
	@Override
	public String toString() {
		return "FilesBannerDTO [bannerFilesNumber=" + bannerFilesNumber + ", bannerFilesType=" + bannerFilesType
				+ ", bannerFilesName=" + bannerFilesName + ", bannerFilesPath=" + bannerFilesPath
				+ ", bannerFilesSizeBytes=" + bannerFilesSizeBytes + ", bannerCreatedDate=" + bannerCreatedDate + "]";
	}
}
