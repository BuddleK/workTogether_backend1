package com.wt.app.dto;

public class ReferenceDTO {
//    reference_number NUMBER PRIMARY KEY,
//    reference_users_number NUMBER NOT NULL,
//    reference_title VARCHAR2(300) NOT NULL,
//    reference_created_date DATE NOT NULL,
//    reference_content VARCHAR2(300) NOT NULL,
//    reference_answered_yn CHAR(1) DEFAULT 'N' CHECK (reference_answered_yn IN ('Y', 'N'))
	int referenceNumber;
	int userNumber;
	int referenceTitle;
	String createdDate;
	String referenceContent;
	char answerd_yn;

	public int getReferenceNumber() {
		return referenceNumber;
	}

	public void setReferenceNumber(int referenceNumber) {
		this.referenceNumber = referenceNumber;
	}

	public int getUserNumber() {
		return userNumber;
	}

	public void setUserNumber(int userNumber) {
		this.userNumber = userNumber;
	}

	public int getReferenceTitle() {
		return referenceTitle;
	}

	public void setReferenceTitle(int referenceTitle) {
		this.referenceTitle = referenceTitle;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getReferenceContent() {
		return referenceContent;
	}

	public void setReferenceContent(String referenceContent) {
		this.referenceContent = referenceContent;
	}

	public char getAnswerd_yn() {
		return answerd_yn;
	}

	public void setAnswerd_yn(char answerd_yn) {
		this.answerd_yn = answerd_yn;
	}

	@Override
	public String toString() {
		return "ReferenceDTO [referenceNumber=" + referenceNumber + ", userNumber=" + userNumber + ", referenceTitle="
				+ referenceTitle + ", createdDate=" + createdDate + ", referenceContent=" + referenceContent
				+ ", answerd_yn=" + answerd_yn + "]";
	}

}
