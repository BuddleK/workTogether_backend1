package com.wt.app.dto;

public class LicenseModifyDTO {
	private Integer licenseModifyNumber;
	private Integer usersNumber;
	private Integer licenseFilesNumber;

	private String licenseFilesType;
	private String licenseFilesName;
	private String licenseFilesPath;
	private Long licenseFilesSizeBytes;
	private String licenseCreatedDate;
	public Integer getLicenseModifyNumber() {
		return licenseModifyNumber;
	}
	public void setLicenseModifyNumber(Integer licenseModifyNumber) {
		this.licenseModifyNumber = licenseModifyNumber;
	}
	public Integer getUsersNumber() {
		return usersNumber;
	}
	public void setUsersNumber(Integer usersNumber) {
		this.usersNumber = usersNumber;
	}
	public Integer getLicenseFilesNumber() {
		return licenseFilesNumber;
	}
	public void setLicenseFilesNumber(Integer licenseFilesNumber) {
		this.licenseFilesNumber = licenseFilesNumber;
	}
	public String getLicenseFilesType() {
		return licenseFilesType;
	}
	public void setLicenseFilesType(String licenseFilesType) {
		this.licenseFilesType = licenseFilesType;
	}
	public String getLicenseFilesName() {
		return licenseFilesName;
	}
	public void setLicenseFilesName(String licenseFilesName) {
		this.licenseFilesName = licenseFilesName;
	}
	public String getLicenseFilesPath() {
		return licenseFilesPath;
	}
	public void setLicenseFilesPath(String licenseFilesPath) {
		this.licenseFilesPath = licenseFilesPath;
	}
	public Long getLicenseFilesSizeBytes() {
		return licenseFilesSizeBytes;
	}
	public void setLicenseFilesSizeBytes(Long licenseFilesSizeBytes) {
		this.licenseFilesSizeBytes = licenseFilesSizeBytes;
	}
	public String getLicenseCreatedDate() {
		return licenseCreatedDate;
	}
	public void setLicenseCreatedDate(String licenseCreatedDate) {
		this.licenseCreatedDate = licenseCreatedDate;
	}
	@Override
	public String toString() {
		return "LicenseModifyDTO [licenseModifyNumber=" + licenseModifyNumber + ", usersNumber=" + usersNumber
				+ ", licenseFilesNumber=" + licenseFilesNumber + ", licenseFilesType=" + licenseFilesType
				+ ", licenseFilesName=" + licenseFilesName + ", licenseFilesPath=" + licenseFilesPath
				+ ", licenseFilesSizeBytes=" + licenseFilesSizeBytes + ", licenseCreatedDate=" + licenseCreatedDate
				+ "]";
	}
	
}
