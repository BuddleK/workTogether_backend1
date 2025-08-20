package com.wt.app.dto;

public class CareUsersDTO {
	private int careNumber;
    private int usersNumber;
    private String careIntroText;
    private int careCertificateFilesNum;
    private int carePassbookFilesNum;
    private int careProfilesPhotoNumber;
    private String careAccept;
    
    
	public int getCareNumber() {
		return careNumber;
	}
	public void setCareNumber(int careNumber) {
		this.careNumber = careNumber;
	}
	public int getUsersNumber() {
		return usersNumber;
	}
	public void setUsersNumber(int usersNumber) {
		this.usersNumber = usersNumber;
	}
	public String getCareIntroText() {
		return careIntroText;
	}
	public void setCareIntroText(String careIntroText) {
		this.careIntroText = careIntroText;
	}
	public int getCareCertificateFilesNum() {
		return careCertificateFilesNum;
	}
	public void setCareCertificateFilesNum(int careCertificateFilesNum) {
		this.careCertificateFilesNum = careCertificateFilesNum;
	}
	public int getCarePassbookFilesNum() {
		return carePassbookFilesNum;
	}
	public void setCarePassbookFilesNum(int carePassbookFilesNum) {
		this.carePassbookFilesNum = carePassbookFilesNum;
	}
	public int getCareProfilesPhotoNumber() {
		return careProfilesPhotoNumber;
	}
	public void setCareProfilesPhotoNumber(int careProfilesPhotoNumber) {
		this.careProfilesPhotoNumber = careProfilesPhotoNumber;
	}
	public String getCareAccept() {
		return careAccept;
	}
	public void setCareAccept(String careAccept) {
		this.careAccept = careAccept;
	}
	
	@Override
	public String toString() {
		return "CareUsersDTO [careNumber=" + careNumber + ", usersNumber=" + usersNumber + ", careIntroText="
				+ careIntroText + ", careCertificateFilesNum=" + careCertificateFilesNum + ", carePassbookFilesNum="
				+ carePassbookFilesNum + ", careProfilesPhotoNumber=" + careProfilesPhotoNumber + ", careAccept="
				+ careAccept + "]";
	}
	
}
