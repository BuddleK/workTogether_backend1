package com.wt.app.dto;

public class NormalMessageDTO {
	// 쪽지 테이블
	private int messageNumber; // 쪽지 번호
	private int careNumber; // 돌봄 회원 번호
	private int normalNumber; // 일반 회원 번호
	private String messageContent; // 쪽지 내용
	private String messageDate; // 쪽지 날짜
	private String isRead; // 읽음 여부

	private String senderType; // 보낸 쪽지/받은 쪽지

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

	public String getIsRead() {
		return isRead;
	}

	public void setIsRead(String isRead) {
		this.isRead = isRead;
	}

	public String getSenderType() {
		return senderType;
	}

	public void setSenderType(String senderType) {
		this.senderType = senderType;
	}

	@Override
	public String toString() {
		return "NormalMessageDTO [messageNumber=" + messageNumber + ", careNumber=" + careNumber + ", normalNumber="
				+ normalNumber + ", messageContent=" + messageContent + ", messageDate=" + messageDate + ", isRead="
				+ isRead + ", senderType=" + senderType + "]";
	}

}
