package com.wt.app.dto;

public class NormalReferenceListDTO {
	int referenceNumber;
	int usersNumber;

	String usersName;
	String referenceTitle;
	String referenceCreatedDate;
	boolean answeredYn;

	public int getReferenceNumber() {
		return referenceNumber;
	}

	public void setReferenceNumber(int referenceNumber) {
		this.referenceNumber = referenceNumber;
	}

	public int getUsersNumber() {
		return usersNumber;
	}

	public void setUsersNumber(int usersNumber) {
		this.usersNumber = usersNumber;
	}

	public String getUsersName() {
		return usersName;
	}

	public void setUsersName(String usersName) {
		this.usersName = usersName;
	}

	public String getReferenceTitle() {
		return referenceTitle;
	}

	public void setReferenceTitle(String referenceTitle) {
		this.referenceTitle = referenceTitle;
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
		return "NormalReferenceListDTO [referenceNumber=" + referenceNumber + ", usersNumber=" + usersNumber
				+ ", usersName=" + usersName + ", referenceTitle=" + referenceTitle + ", referenceCreatedDate="
				+ referenceCreatedDate + ", answeredYn=" + answeredYn + "]";
	}

}
