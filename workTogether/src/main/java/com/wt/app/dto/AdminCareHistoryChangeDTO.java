package com.wt.app.dto;

public class AdminCareHistoryChangeDTO {
	private int requestNumber;
	private int usersNumber;
	private String changeType;
	private String beforeValue;
	private String afterValue;
	private String requestDate;
	private String status;
	private String processedDate;
	private Integer adminNumber;

	public int getRequestNumber() {
		return requestNumber;
	}

	public void setRequestNumber(int requestNumber) {
		this.requestNumber = requestNumber;
	}

	public int getUsersNumber() {
		return usersNumber;
	}

	public void setUsersNumber(int usersNumber) {
		this.usersNumber = usersNumber;
	}

	public String getChangeType() {
		return changeType;
	}

	public void setChangeType(String changeType) {
		this.changeType = changeType;
	}

	public String getBeforeValue() {
		return beforeValue;
	}

	public void setBeforeValue(String beforeValue) {
		this.beforeValue = beforeValue;
	}

	public String getAfterValue() {
		return afterValue;
	}

	public void setAfterValue(String afterValue) {
		this.afterValue = afterValue;
	}

	public String getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(String requestDate) {
		this.requestDate = requestDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getProcessedDate() {
		return processedDate;
	}

	public void setProcessedDate(String processedDate) {
		this.processedDate = processedDate;
	}

	public Integer getAdminNumber() {
		return adminNumber;
	}

	public void setAdminNumber(Integer adminNumber) {
		this.adminNumber = adminNumber;
	}

	@Override
	public String toString() {
		return "AdminCareHistoryChangeDTO [requestNumber=" + requestNumber + ", usersNumber=" + usersNumber
				+ ", changeType=" + changeType + ", beforeValue=" + beforeValue + ", afterValue=" + afterValue
				+ ", requestDate=" + requestDate + ", status=" + status + ", processedDate=" + processedDate
				+ ", adminNumber=" + adminNumber + "]";
	}

}
