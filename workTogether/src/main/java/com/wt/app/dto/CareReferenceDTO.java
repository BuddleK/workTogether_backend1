package com.wt.app.dto;

public class CareReferenceDTO {
	
//	CREATE TABLE tbl_reference (
//		    reference_number NUMBER PRIMARY KEY,
//		    reference_users_number NUMBER NOT NULL,
//		    reference_title VARCHAR2(300) NOT NULL,
//		    reference_created_date DATE NOT NULL,
//		    reference_content VARCHAR2(300) NOT NULL,
//		    reference_answered_yn CHAR(1) DEFAULT 'N' CHECK (reference_answered_yn IN ('Y', 'N')),
//		    CONSTRAINT fk_ref_users FOREIGN KEY (reference_users_number) REFERENCES tbl_users(users_number) ON DELETE CASCADE
//		);
	
	private int referenceNumber;
	private int referenceUsersNumber;
	private String referenceTitle;
	private String referenceCreatedDate;
	private char referenceAnsweredYN;
	public int getReferenceNumber() {
		return referenceNumber;
	}
	public void setReferenceNumber(int referenceNumber) {
		this.referenceNumber = referenceNumber;
	}
	public int getReferenceUsersNumber() {
		return referenceUsersNumber;
	}
	public void setReferenceUsersNumber(int referenceUsersNumber) {
		this.referenceUsersNumber = referenceUsersNumber;
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
	public char getReferenceAnsweredYN() {
		return referenceAnsweredYN;
	}
	public void setReferenceAnsweredYN(char referenceAnsweredYN) {
		this.referenceAnsweredYN = referenceAnsweredYN;
	}
	
	
	@Override
	public String toString() {
		return "CareReferenceDTO [referenceNumber=" + referenceNumber + ", referenceUsersNumber=" + referenceUsersNumber
				+ ", referenceTitle=" + referenceTitle + ", referenceCreatedDate=" + referenceCreatedDate
				+ ", referenceAnsweredYN=" + referenceAnsweredYN + "]";

	}
	
	
}
