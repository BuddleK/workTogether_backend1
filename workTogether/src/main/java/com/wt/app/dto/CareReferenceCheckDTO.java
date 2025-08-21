package com.wt.app.dto;

public class CareReferenceCheckDTO {
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
//
//	-- 문의 답변
//	CREATE TABLE tbl_reference_reply (
//	    reply_reference_reply_number NUMBER PRIMARY KEY,
//	    reference_number NUMBER NOT NULL,
//	    admin_number NUMBER NOT NULL,
//	    reply_content VARCHAR2(2000) NOT NULL,
//	    reply_created_date DATE NOT NULL,
//	    reply_updated_date DATE,
//	    CONSTRAINT fk_refreply_ref FOREIGN KEY (reference_number) REFERENCES tbl_reference(reference_number) ON DELETE CASCADE,
//	    CONSTRAINT fk_refreply_admin FOREIGN KEY (admin_number) REFERENCES tbl_admin(admin_number) ON DELETE CASCADE
//	);

	private int referenceNumber;
	private int referenceUsers;
	private String referenceTitle;
	private String referenceCreated;
	private String referenceContent;
	private int reply_referenceReplyNumber;
	private int adminNumber;
	private String replyContent;
	private String replyCreatedDate;
	private String replyUpdatedDate;

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

	public String getReferenceCreated() {
		return referenceCreated;
	}

	public void setReferenceCreated(String referenceCreated) {
		this.referenceCreated = referenceCreated;
	}

	public String getReferenceContent() {
		return referenceContent;
	}

	public void setReferenceContent(String referenceContent) {
		this.referenceContent = referenceContent;
	}

	public int getReply_referenceReplyNumber() {
		return reply_referenceReplyNumber;
	}

	public void setReply_referenceReplyNumber(int reply_referenceReplyNumber) {
		this.reply_referenceReplyNumber = reply_referenceReplyNumber;
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

	@Override
	public String toString() {
		return "CareReferenceCheckDTO [referenceNumber=" + referenceNumber + ", referenceUsers=" + referenceUsers
				+ ", referenceTitle=" + referenceTitle + ", referenceCreated=" + referenceCreated
				+ ", referenceContent=" + referenceContent + ", reply_referenceReplyNumber="
				+ reply_referenceReplyNumber + ", adminNumber=" + adminNumber + ", replyContent=" + replyContent
				+ ", replyCreatedDate=" + replyCreatedDate + ", replyUpdatedDate=" + replyUpdatedDate + "]";
	}

}
