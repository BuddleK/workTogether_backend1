package com.wt.app.dto;

public class CareCareerRowDTO {

	private Integer accountModifyNumber;
	private Integer usersNumber;
	private String usersName; // ← 추가
	private String usersId; // ← 추가
	private String accountCreatedDate; // ← 추가 (TO_CHAR로 문자열 받음)
	private String reviewStatus;
	private Integer accountFilesNumber;
	private String  accountFilesName;
	private String  accountFilesType;
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
	public String getUsersName() {
		return usersName;
	}
	public void setUsersName(String usersName) {
		this.usersName = usersName;
	}
	public String getUsersId() {
		return usersId;
	}
	public void setUsersId(String usersId) {
		this.usersId = usersId;
	}
	public String getAccountCreatedDate() {
		return accountCreatedDate;
	}
	public void setAccountCreatedDate(String accountCreatedDate) {
		this.accountCreatedDate = accountCreatedDate;
	}
	public String getReviewStatus() {
		return reviewStatus;
	}
	public void setReviewStatus(String reviewStatus) {
		this.reviewStatus = reviewStatus;
	}
	public Integer getAccountFilesNumber() {
		return accountFilesNumber;
	}
	public void setAccountFilesNumber(Integer accountFilesNumber) {
		this.accountFilesNumber = accountFilesNumber;
	}
	public String getAccountFilesName() {
		return accountFilesName;
	}
	public void setAccountFilesName(String accountFilesName) {
		this.accountFilesName = accountFilesName;
	}
	public String getAccountFilesType() {
		return accountFilesType;
	}
	public void setAccountFilesType(String accountFilesType) {
		this.accountFilesType = accountFilesType;
	}
	@Override
	public String toString() {
		return "CareCareerRowDTO [accountModifyNumber=" + accountModifyNumber + ", usersNumber=" + usersNumber
				+ ", usersName=" + usersName + ", usersId=" + usersId + ", accountCreatedDate=" + accountCreatedDate
				+ ", reviewStatus=" + reviewStatus + ", accountFilesNumber=" + accountFilesNumber
				+ ", accountFilesName=" + accountFilesName + ", accountFilesType=" + accountFilesType + "]";
	}
	
}
