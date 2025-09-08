package com.wt.app.dto;

public class FilesAccountDTO {
	private int accountFilesNumber;
	private int usersNumber;
	private String accountFilesType;
	private String accountFilesName;
	private String accountFilesPath;
	private String accountFilesSizeBytes;
	private String accountCreateDate;
	
	public int getAccountFilesNumber() {
		return accountFilesNumber;
	}
	public void setAccountFilesNumber(int accountFilesNumber) {
		this.accountFilesNumber = accountFilesNumber;
	}
	public int getUsersNumber() {
		return usersNumber;
	}
	public void setUsersNumber(int usersNumber) {
		this.usersNumber = usersNumber;
	}
	public String getAccountFilesType() {
		return accountFilesType;
	}
	public void setAccountFilesType(String accountFilesType) {
		this.accountFilesType = accountFilesType;
	}
	public String getAccountFilesName() {
		return accountFilesName;
	}
	public void setAccountFilesName(String accountFilesName) {
		this.accountFilesName = accountFilesName;
	}
	public String getAccountFilesPath() {
		return accountFilesPath;
	}
	public void setAccountFilesPath(String accountFilesPath) {
		this.accountFilesPath = accountFilesPath;
	}
	public String getAccountFilesSizeBytes() {
		return accountFilesSizeBytes;
	}
	public void setAccountFilesSizeBytes(String accountFilesSizeBytes) {
		this.accountFilesSizeBytes = accountFilesSizeBytes;
	}
	public String getAccountCreateDate() {
		return accountCreateDate;
	}
	public void setAccountCreateDate(String accountCreateDate) {
		this.accountCreateDate = accountCreateDate;
	}
	@Override
	public String toString() {
		return "FilesAccountDTO [accountFilesNumber=" + accountFilesNumber + ", usersNumber=" + usersNumber
				+ ", accountFilesType=" + accountFilesType + ", accountFilesName=" + accountFilesName
				+ ", accountFilesPath=" + accountFilesPath + ", accountFilesSizeBytes=" + accountFilesSizeBytes
				+ ", accountCreateDate=" + accountCreateDate + "]";
	}
}
