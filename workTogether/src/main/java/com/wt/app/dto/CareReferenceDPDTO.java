package com.wt.app.dto;

public class CareReferenceDPDTO {
	
//	-- 문의
//	CREATE TABLE tbl_reference (
//	    reference_number NUMBER PRIMARY KEY,
//	    reference_users_number NUMBER NOT NULL,
//	    reference_title VARCHAR2(300) NOT NULL,
//	    reference_created_date DATE NOT NULL,
//	    reference_content VARCHAR2(300) NOT NULL,
//	    reference_answered_yn CHAR(1) DEFAULT 'N' CHECK (reference_answered_yn IN ('Y', 'N')),
//	    CONSTRAINT fk_ref_users FOREIGN KEY (reference_users_number) REFERENCES tbl_users(users_number) ON DELETE CASCADE
//	);
	
	int referenceNumber;
	int referenceUsers;
	String referenceTitle;
	String referenceCreatedDate;
	String referenceContent;
	public int getReferenceNumber() {
		return referenceNumber;
	}
	public void setReferenceNumber(int referenceNumber) {
		this.referenceNumber = referenceNumber;
	}
	public int getReferenceUsers() {
		return referenceUsers;
	}
	public void setReferenceUsers(int referenceUsers) {
		this.referenceUsers = referenceUsers;
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
	public String getReferenceContent() {
		return referenceContent;
	}
	public void setReferenceContent(String referenceContent) {
		this.referenceContent = referenceContent;
	}
	
	@Override
	public String toString() {
		return "CareReferenceDPDTO [referenceNumber=" + referenceNumber + ", referenceUsers=" + referenceUsers
				+ ", referenceTitle=" + referenceTitle + ", referenceCreatedDate=" + referenceCreatedDate
				+ ", referenceContent=" + referenceContent + "]";
	}
	
	
	
	
}
