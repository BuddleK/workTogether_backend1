package com.wt.app.dto;

public class MessageSRDTO {
	private int messageNumber;
	private int  careNumber;
	private int normalNumber;
	private String senderType;
	private String messageContents;
	private String messageDate;
	private String isRead;
	
	private String usersNumber;
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

	public String getMessageContents() {
		return messageContents;
	}

	public void setMessageContents(String messageContents) {
		this.messageContents = messageContents;
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

	public String getUsersNumber() {
		return usersNumber;
	}

	public void setUsersNumber(String usersNumber) {
		this.usersNumber = usersNumber;
	}

	public String getUsersName() {
		return usersName;
	}

	public void setUsersName(String usersName) {
		this.usersName = usersName;
	}

	public String getUsersId() {
		return usersId;
	}

	public void setUserId(String userId) {
		this.usersId = userId;
	}

	@Override
	public String toString() {
		return "MessageSRDTO [messageNumber=" + messageNumber + ", careNumber=" + careNumber + ", normalNumber="
				+ normalNumber + ", senderType=" + senderType + ", messageContents=" + messageContents
				+ ", messageDate=" + messageDate + ", isRead=" + isRead + ", usersNumber=" + usersNumber
				+ ", usersName=" + usersName + ", usersId=" + usersId + "]";
	}
	
	
	
	
	
}
