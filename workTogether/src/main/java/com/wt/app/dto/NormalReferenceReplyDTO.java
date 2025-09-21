package com.wt.app.dto;

public class NormalReferenceReplyDTO {
	private int replyReferenceReplyNumber;
	private int referenceNumber;
	private int adminNumber;
	private String replyContent;
	private String replyCreatedDate;
	private String replyUpdatedDate;
	private String adminName;

	public int getReplyReferenceReplyNumber() {
		return replyReferenceReplyNumber;
	}

	public void setReplyReferenceReplyNumber(int replyReferenceReplyNumber) {
		this.replyReferenceReplyNumber = replyReferenceReplyNumber;
	}

	public int getReferenceNumber() {
		return referenceNumber;
	}

	public void setReferenceNumber(int referenceNumber) {
		this.referenceNumber = referenceNumber;
	}

	public int getAdminNumber() {
		return adminNumber;
	}

	public void setAdminNumber(int adminNumber) {
		this.adminNumber = adminNumber;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public String getReplyCreatedDate() {
		return replyCreatedDate;
	}

	public void setReplyCreatedDate(String replyCreatedDate) {
		this.replyCreatedDate = replyCreatedDate;
	}

	public String getReplyUpdatedDate() {
		return replyUpdatedDate;
	}

	public void setReplyUpdatedDate(String replyUpdatedDate) {
		this.replyUpdatedDate = replyUpdatedDate;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	@Override
	public String toString() {
		return "NormalReferenceReplyDTO [replyReferenceReplyNumber=" + replyReferenceReplyNumber + ", referenceNumber="
				+ referenceNumber + ", adminNumber=" + adminNumber + ", replyContent=" + replyContent
				+ ", replyCreatedDate=" + replyCreatedDate + ", replyUpdatedDate=" + replyUpdatedDate + ", adminName="
				+ adminName + "]";
	}

}
