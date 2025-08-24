package com.wt.app.dto;

public class AccountModifyDTO {
	private Integer accountModifyNumber;
	private Integer usersNumber;
	private Integer accountFilesNumber;

	private String accountFilesType;
	private String accountFilesName;
	private String accountFilesPath;
	private Long accountFilesSizeBytes;

	private String accountCreatedDate;

	public Integer getAccountModifyNumber() {
		return accountModifyNumber;
	}

	public void setAccountModifyNumber(Integer accountModifyNumber) {
		this.accountModifyNumber = accountModifyNumber;
	}

	public Integer getUsersNumber() {
		return usersNumber;
	}

	public void setUsersNumber(Integer usersNumber) {
		this.usersNumber = usersNumber;
	}

	public Integer getAccountFilesNumber() {
		return accountFilesNumber;
	}

	public void setAccountFilesNumber(Integer accountFilesNumber) {
		this.accountFilesNumber = accountFilesNumber;
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

	public Long getAccountFilesSizeBytes() {
		return accountFilesSizeBytes;
	}

	public void setAccountFilesSizeBytes(Long accountFilesSizeBytes) {
		this.accountFilesSizeBytes = accountFilesSizeBytes;
	}

	public String getAccountCreatedDate() {
		return accountCreatedDate;
	}

	public void setAccountCreatedDate(String accountCreatedDate) {
		this.accountCreatedDate = accountCreatedDate;
	}

	@Override
	public String toString() {
		return "AccountModifyDTO [accountModifyNumber=" + accountModifyNumber + ", usersNumber=" + usersNumber
				+ ", accountFilesNumber=" + accountFilesNumber + ", accountFilesType=" + accountFilesType
				+ ", accountFilesName=" + accountFilesName + ", accountFilesPath=" + accountFilesPath
				+ ", accountFilesSizeBytes=" + accountFilesSizeBytes + ", accountCreatedDate=" + accountCreatedDate
				+ "]";
	}
	
}
