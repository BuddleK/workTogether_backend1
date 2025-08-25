package com.wt.app.dto;

public class LicenseModifyDTO {
	private Integer licenseModifyNumber; // LICENSE_MODIFY_NUMBER (PK)
	private Integer usersNumber; // USERS_NUMBER
	private Integer licenseFilesNumber; // LICENSE_FILES_NUMBER (원본 파일 PK)
	private String licenseFilesType; // LICENSE_FILES_TYPE
	private String licenseFilesName; // LICENSE_FILES_NAME
	private String licenseFilesPath; // LICENSE_FILES_PATH
	private Long licenseFilesSizeBytes; // LICENSE_FILES_SIZE_BYTES
	private String licenseCreatedDate; // LICENSE_CREATED_DATE (문자열로 수신)

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
