package com.wt.app.dto;

public class AdminReferenceListDTO {
	//문의 테이블
	private int referenceNumber; // 문의 번호
	private String referenceTitle; // 문의 제목
	//전체 유저 테이블
	private int userNumber; // 유저 번호
	private String userName; // 일반 or 돌봄 유저 이름
	//문의 테이블
	private String referenceCreatedDate; // 문의 생성 일
	private boolean answeredYn; // 답변 유무

	public int getReferenceNumber() {
		return referenceNumber;
	}

	public void setReferenceNumber(int referenceNumber) {
		this.referenceNumber = referenceNumber;
	}

	public String getReferenceTitle() {
		return referenceTitle;
	}

	public void setReferenceTitle(String referenceTitle) {
		this.referenceTitle = referenceTitle;
	}

	public int getUserNumber() {
		return userNumber;
	}

	public void setUserNumber(int userNumber) {
		this.userNumber = userNumber;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getReferenceCreatedDate() {
		return referenceCreatedDate;
	}

	public void setReferenceCreatedDate(String referenceCreatedDate) {
		this.referenceCreatedDate = referenceCreatedDate;
	}

	public boolean isAnsweredYn() {
		return answeredYn;
	}

	public void setAnsweredYn(boolean answeredYn) {
		this.answeredYn = answeredYn;
	}

	@Override
	public String toString() {
		return "AdminReferenceListDTO [referenceNumber=" + referenceNumber + ", referenceTitle=" + referenceTitle
				+ ", userNumber=" + userNumber + ", userName=" + userName + ", referenceCreatedDate="
				+ referenceCreatedDate + ", answeredYn=" + answeredYn + "]";
	}

}
