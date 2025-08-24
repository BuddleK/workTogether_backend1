package com.wt.app.dto;

public class FilesLicenseDTO {
	private Integer licenseFilesNumber;      // LICENSE_FILES_NUMBER
    private String  licenseFilesType;        // LICENSE_FILES_TYPE (MIME)
    private String  licenseFilesName;        // LICENSE_FILES_NAME (원본명)
    private String  licenseFilesPath;        // LICENSE_FILES_PATH (웹 경로)
    private Long    licenseFilesSizeBytes;   // LICENSE_FILES_SIZE_BYTES
    private String  licenseCreatedDate;
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
		return "FilesLicenseDTO [licenseFilesNumber=" + licenseFilesNumber + ", licenseFilesType=" + licenseFilesType
				+ ", licenseFilesName=" + licenseFilesName + ", licenseFilesPath=" + licenseFilesPath
				+ ", licenseFilesSizeBytes=" + licenseFilesSizeBytes + ", licenseCreatedDate=" + licenseCreatedDate
				+ "]";
	}
	
	
}
