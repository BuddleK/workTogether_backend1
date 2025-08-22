package com.wt.app.dto;

public class NormalReferenceListDTO {
	// 문의 테이블
	private int referenceNumber; // 문의 번호
	private int usersNumber; // 전체 유저 번호
	private String usersName; // 유저 이름
	private String referenceTitle; // 문의 제목
	private String referenceCreatedDate; // 문의 생성 일
	private boolean answeredYn; // 답변여부

	public int getReferenceNumber() {
		return referenceNumber;
	}

	public void setReferenceNumber(int referenceNumber) {
		this.referenceNumber = referenceNumber;
	}

	public int getUsersNumber() {
		return usersNumber;
	}

	public void setUsersNumber(int usersNumber) {
		this.usersNumber = usersNumber;
	}

	public String getUsersName() {
		return usersName;
	}

	public void setUsersName(String usersName) {
		this.usersName = usersName;
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

	public boolean isAnsweredYn() {
		return answeredYn;
	}

	public void setAnsweredYn(boolean answeredYn) {
		this.answeredYn = answeredYn;
	}

	@Override
	public String toString() {
		return "NormalReferenceListDTO [referenceNumber=" + referenceNumber + ", usersNumber=" + usersNumber
				+ ", usersName=" + usersName + ", referenceTitle=" + referenceTitle + ", referenceCreatedDate="
				+ referenceCreatedDate + ", answeredYn=" + answeredYn + "]";
	}

}
