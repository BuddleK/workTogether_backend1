package com.wt.app.dto;

public class CareUsersDTO {
	private Long usersNumber;
    private String careIntroText;
    private Long careCertificateFilesNum;
    private Long carePassbookFilesNum;
    private Long careProfilesPhotoNumber;
    private String careAccept;
	@Override
	public String toString() {
		return "CareUsersDTO [usersNumber=" + usersNumber + ", careIntroText=" + careIntroText
				+ ", careCertificateFilesNum=" + careCertificateFilesNum + ", carePassbookFilesNum="
				+ carePassbookFilesNum + ", careProfilesPhotoNumber=" + careProfilesPhotoNumber + ", careAccept="
				+ careAccept + "]";
	}
	public Long getUsersNumber() {
		return usersNumber;
	}
	public void setUsersNumber(Long usersNumber) {
		this.usersNumber = usersNumber;
	}
	public String getCareIntroText() {
		return careIntroText;
	}
	public void setCareIntroText(String careIntroText) {
		this.careIntroText = careIntroText;
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
	public String getCareAccept() {
		return careAccept;
	}
	public void setCareAccept(String careAccept) {
		this.careAccept = careAccept;
	} 
    
	
    
    
}
