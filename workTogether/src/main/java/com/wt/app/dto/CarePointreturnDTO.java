package com.wt.app.dto;

public class CarePointreturnDTO {

	private int rnum;
    private Long pointReturnId;
    private Long usersNumber;
    private String usersId;
    private String usersName;
    private Long pointsAmount;
    private String bankName;
    private String accountNumber;
    private String requestedAt;
    private String refundedAt;
    private String status;
    private Long remainPoint;
	public Long getPointReturnId() {
		return pointReturnId;
	}
	public void setPointReturnId(Long pointReturnId) {
		this.pointReturnId = pointReturnId;
	}
	public Long getUsersNumber() {
		return usersNumber;
	}
	public void setUsersNumber(Long usersNumber) {
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
	public Long getPointsAmount() {
		return pointsAmount;
	}
	public void setPointsAmount(Long pointsAmount) {
		this.pointsAmount = pointsAmount;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getRequestedAt() {
		return requestedAt;
	}
	public void setRequestedAt(String requestedAt) {
		this.requestedAt = requestedAt;
	}
	public String getRefundedAt() {
		return refundedAt;
	}
	public void setRefundedAt(String refundedAt) {
		this.refundedAt = refundedAt;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Long getRemainPoint() {
		return remainPoint;
	}
	public void setRemainPoint(Long remainPoint) {
		this.remainPoint = remainPoint;
	}
	@Override
	public String toString() {
		return "CarePointreturnDTO [pointReturnId=" + pointReturnId + ", usersNumber=" + usersNumber + ", usersId="
				+ usersId + ", usersName=" + usersName + ", pointsAmount=" + pointsAmount + ", bankName=" + bankName
				+ ", accountNumber=" + accountNumber + ", requestedAt=" + requestedAt + ", refundedAt=" + refundedAt
				+ ", status=" + status + ", remainPoint=" + remainPoint + "]";
	}
	public int getRnum() {
		return rnum;
	}
	public void setRnum(int rnum) {
		this.rnum = rnum;
	}
    
	
	
}
