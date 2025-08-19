package com.wt.app.dto;

public class MessageDTO {
	private int messageNumber;
	private int careNumber;
	private int normalNumber;
	private String messageContents;
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
	public char getIsRead() {
		return isRead;
	}
	public void setIsRead(char isRead) {
		this.isRead = isRead;
	}
	@Override
	public String toString() {
		return "MessageDTO [messageNumber=" + messageNumber + ", careNumber=" + careNumber + ", normalNumber="
				+ normalNumber + ", messageContents=" + messageContents + ", messageDate=" + messageDate + ", isRead="
				+ isRead + "]";
	}
	
	
	
}
