package com.wt.app.dto;

public class CareMessageDTO {
	private int messageNumber;
	private int careNumber;
	private int normalNumber;
	private char senderType;
	private String messageContent;
	private String messageDate;
	private char isRead;

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

	public char getSenderType() {
		return senderType;
	}

	public void setSenderType(char senderType) {
		this.senderType = senderType;
	}

	public String getMessageContent() {
		return messageContent;
	}

	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}

	public String getMessageDate() {
		return messageDate;
	}

	public void setMessageDate(String messageDate) {
		this.messageDate = messageDate;
	}

	public char getIsRead() {
		return isRead;
	}

	public void setIsRead(char isRead) {
		this.isRead = isRead;
	}

	@Override
	public String toString() {
		return "NormalMessageDTO [messageNumber=" + messageNumber + ", careNumber=" + careNumber + ", normalNumber="
				+ normalNumber + ", senderType=" + senderType + ", messageContent=" + messageContent + ", messageDate="
				+ messageDate + ", isRead=" + isRead + "]";
	}

}
