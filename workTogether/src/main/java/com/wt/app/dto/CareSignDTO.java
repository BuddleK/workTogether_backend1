package com.wt.app.dto;

public class CareSignDTO {
	private String usersId;
    private String usersPassword;
    private String usersType;
    private long usersNumber;
    private String usersName;
    private String usersEmail;
    private String usersPhone;
    private String usersPostsalCode;
    private String usersAddressLine1;
    private String usersAddressLine2;
    private String careIntroText;
    private String careAccept;
    private Long careCertificateFilesNum;
    private Long carePassbookFilesNum;
    private Long careProfilesPhotoNumber;
	public String getUsersId() {
		return usersId;
	}
	public void setUsersId(String usersId) {
		this.usersId = usersId;
	}
	public String getUsersPassword() {
		return usersPassword;
	}
	public void setUsersPassword(String usersPassword) {
		this.usersPassword = usersPassword;
	}
	public String getUsersType() {
		return usersType;
	}
	public void setUsersType(String usersType) {
		this.usersType = usersType;
	}
	public long getUsersNumber() {
		return usersNumber;
	}
	public void setUsersNumber(long usersNumber) {
		this.usersNumber = usersNumber;
	}
	public String getUsersName() {
		return usersName;
	}
	public void setUsersName(String usersName) {
		this.usersName = usersName;
	}
	public String getUsersEmail() {
		return usersEmail;
	}
	public void setUsersEmail(String usersEmail) {
		this.usersEmail = usersEmail;
	}
	public String getUsersPhone() {
		return usersPhone;
	}
	public void setUsersPhone(String usersPhone) {
		this.usersPhone = usersPhone;
	}
	public String getUsersPostsalCode() {
		return usersPostsalCode;
	}
	public void setUsersPostsalCode(String usersPostsalCode) {
		this.usersPostsalCode = usersPostsalCode;
	}
	public String getUsersAddressLine1() {
		return usersAddressLine1;
	}
	public void setUsersAddressLine1(String usersAddressLine1) {
		this.usersAddressLine1 = usersAddressLine1;
	}
	public String getUsersAddressLine2() {
		return usersAddressLine2;
	}
	public void setUsersAddressLine2(String usersAddressLine2) {
		this.usersAddressLine2 = usersAddressLine2;
	}
	public String getCareIntroText() {
		return careIntroText;
	}
	public void setCareIntroText(String careIntroText) {
		this.careIntroText = careIntroText;
	}
	public String getCareAccept() {
		return careAccept;
	}
	public void setCareAccept(String careAccept) {
		this.careAccept = careAccept;
	}
	public Long getCareCertificateFilesNum() {
		return careCertificateFilesNum;
	}
	public void setCareCertificateFilesNum(Long careCertificateFilesNum) {
		this.careCertificateFilesNum = careCertificateFilesNum;
	}
	public Long getCarePassbookFilesNum() {
		return carePassbookFilesNum;
	}
	public void setCarePassbookFilesNum(Long carePassbookFilesNum) {
		this.carePassbookFilesNum = carePassbookFilesNum;
	}
	public Long getCareProfilesPhotoNumber() {
		return careProfilesPhotoNumber;
	}
	public void setCareProfilesPhotoNumber(Long careProfilesPhotoNumber) {
		this.careProfilesPhotoNumber = careProfilesPhotoNumber;
	}
	@Override
	public String toString() {
		return "CareSignDTO [usersId=" + usersId + ", usersPassword=" + usersPassword + ", usersType=" + usersType
				+ ", usersNumber=" + usersNumber + ", usersName=" + usersName + ", usersEmail=" + usersEmail
				+ ", usersPhone=" + usersPhone + ", usersPostsalCode=" + usersPostsalCode + ", usersAddressLine1="
				+ usersAddressLine1 + ", usersAddressLine2=" + usersAddressLine2 + ", careIntroText=" + careIntroText
				+ ", careAccept=" + careAccept + ", careCertificateFilesNum=" + careCertificateFilesNum
				+ ", carePassbookFilesNum=" + carePassbookFilesNum + ", careProfilesPhotoNumber="
				+ careProfilesPhotoNumber + "]";
	}

    
	
	
}
