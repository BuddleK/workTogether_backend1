package com.wt.app.dto;

public class CareMessageReturnDTO {
//	-- 쪽지
//	CREATE TABLE tbl_message (
//	   message_number NUMBER PRIMARY KEY,
//	   care_number NUMBER NOT NULL,
//	   normal_number NUMBER NOT NULL,
//	   MESSAGE_CONTENTS VARCHAR2(4000) NOT NULL,
//	   MESSAGE_DATE DATE NOT NULL,
//	   IS_READ CHAR(1) DEFAULT 'N' CHECK (is_read IN ('Y', 'N')),
//	   CONSTRAINT FK_CARE FOREIGN KEY(CARE_number) REFERENCES TBL_CARE_USERS(CARE_number) ON DELETE CASCADE,
//	   CONSTRAINT FK_NORMAL FOREIGN KEY(NORMAL_number) REFERENCES TBL_CARE_USERS(CARE_number) ON DELETE CASCADE
//	);
	
	private int messageNumber;
	private int careNumber;
	private int normalNumber;
	private String MESSAGECONTENTS;
	private String MESSAGEDATE;
	private char ISREAD; //DEFAULT 'N' CHECK (is_read IN ('Y', 'N'))
	public int getMessageNumber() {
		return messageNumber;
	}
	public void setMessageNumber(int messageNumber) {
		this.messageNumber = messageNumber;
	}
	public int getCareNumber() {
		return careNumber;
	}
	public void setCareNumber(int careNumber) {
		this.careNumber = careNumber;
	}
	public int getNormalNumber() {
		return normalNumber;
	}
	public void setNormalNumber(int normalNumber) {
		this.normalNumber = normalNumber;
	}
	public String getMESSAGECONTENTS() {
		return MESSAGECONTENTS;
	}
	public void setMESSAGECONTENTS(String mESSAGECONTENTS) {
		MESSAGECONTENTS = mESSAGECONTENTS;
	}
	public String getMESSAGEDATE() {
		return MESSAGEDATE;
	}
	public void setMESSAGEDATE(String mESSAGEDATE) {
		MESSAGEDATE = mESSAGEDATE;
	}
	public char getISREAD() {
		return ISREAD;
	}
	public void setISREAD(char iSREAD) {
		ISREAD = iSREAD;
	}
	
	
	@Override
	public String toString() {
		return "CareMessageDTO [messageNumber=" + messageNumber + ", careNumber=" + careNumber + ", normalNumber="
				+ normalNumber + ", MESSAGECONTENTS=" + MESSAGECONTENTS + ", MESSAGEDATE=" + MESSAGEDATE + ", ISREAD="
				+ ISREAD + "]";
	}
}
