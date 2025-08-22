package com.wt.app.dto;

public class AdminReferenceListDTO {
	private int referenceNumber;
	private String referenceTitle;
	
	private int userNumber;
	private String userName;
	
	private String referenceCreatedDate;
	private boolean answeredYn;

	public int getReferenceNumber() {
		return referenceNumber;
	}

	public void setReferenceNumber(int referenceNumber) {
		this.referenceNumber = referenceNumber;
	}

	public String getReferenceTitle() {
		return referenceTitle;
	}

	public void setReferenceTitle(String referenceTitle) {
		this.referenceTitle = referenceTitle;
	}

	public int getUserNumber() {
		return userNumber;
	}

	public void setUserNumber(int userNumber) {
		this.userNumber = userNumber;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getReferenceCreatedDate() {
		return referenceCreatedDate;
	}

	public void setReferenceCreatedDate(String referenceCreatedDate) {
		this.referenceCreatedDate = referenceCreatedDate;
	}

	public boolean isAnsweredYn() {
		return answeredYn;
	}

	public void setAnsweredYn(boolean answeredYn) {
		this.answeredYn = answeredYn;
	}

	@Override
	public String toString() {
		return "AdminReferenceListDTO [referenceNumber=" + referenceNumber + ", referenceTitle=" + referenceTitle
				+ ", userNumber=" + userNumber + ", userName=" + userName + ", referenceCreatedDate="
				+ referenceCreatedDate + ", answeredYn=" + answeredYn + "]";
	}

}
