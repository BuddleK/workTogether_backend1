package com.wt.app.dto;

public class AdminPointRefundDTO {
	private int refundNumber;
	private int usersNumber;
	private String usersId; // 조회용
	private String usersName; // 조회용
	private int refundPoints;
	private String requestDate;
	private String status; // P/A/R
	private String processedDate;

	public int getRefundNumber() {
		return refundNumber;
	}

	public void setRefundNumber(int refundNumber) {
		this.refundNumber = refundNumber;
	}

	public int getUsersNumber() {
		return usersNumber;
	}

	public void setUsersNumber(int usersNumber) {
		this.usersNumber = usersNumber;
	}

	public String getUsersId() {
		return usersId;
	}

	public void setUsersId(String usersId) {
		this.usersId = usersId;
	}

	public String getUsersName() {
		return usersName;
	}

	public void setUsersName(String usersName) {
		this.usersName = usersName;
	}

	public int getRefundPoints() {
		return refundPoints;
	}

	public void setRefundPoints(int refundPoints) {
		this.refundPoints = refundPoints;
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

	@Override
	public String toString() {
		return "AdminPointRefundDTO [refundNumber=" + refundNumber + ", usersNumber=" + usersNumber + ", usersId="
				+ usersId + ", usersName=" + usersName + ", refundPoints=" + refundPoints + ", requestDate="
				+ requestDate + ", status=" + status + ", processedDate=" + processedDate + "]";
	}

}
