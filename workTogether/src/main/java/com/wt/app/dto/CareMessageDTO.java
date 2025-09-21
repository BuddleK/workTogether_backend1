package com.wt.app.dto;

public class CareMessageDTO {
	//MESSAGE_NUMBER, CARE_NUMBER, NORMAL_NUMBER, SENDER_TYPE, MESSAGE_CONTENTS, MESSAGE_DATE, IS_READ
	
	private int messageNumber;
	private int careNumber;
	private int normalNumber;
	private String senderType;
	private String messageContents;
	private String messageDate;
	private String isRead;
	private String usersName;
	private String usersId;
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
	public String getSenderType() {
		return senderType;
	}
	public void setSenderType(String senderType) {
		this.senderType = senderType;
	}
	public String getMessageDate() {
		return messageDate;
	}
	public void setMessageDate(String messageDate) {
		this.messageDate = messageDate;
	}
	public String getIsRead() {
		return isRead;
	}
	public void setIsRead(String isRead) {
		this.isRead = isRead;
	}

	@Override
	public String toString() {
		return "CareMessageDTO [messageNumber=" + messageNumber + ", careNumber=" + careNumber + ", normalNumber="
				+ normalNumber + ", senderType=" + senderType + ", messageDate=" + messageDate + ", messageContents=" + messageContents
				+ ", isRead=" + isRead + "]";
	}
	public String getUsersName() {
		return usersName;
	}
	public void setUsersName(String usersName) {
		this.usersName = usersName;
	}
	public String getMessageContents() {
		return messageContents;
	}
	public void setMessageContents(String messageContents) {
		this.messageContents = messageContents;
	}
	public String getUsersId() {
		return usersId;
	}
	public void setUsersId(String usersId) {
		this.usersId = usersId;
	}
    
}
