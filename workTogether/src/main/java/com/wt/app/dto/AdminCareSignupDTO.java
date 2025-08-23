package com.wt.app.dto;

public class AdminCareSignupDTO {
	 private int usersNumber;
	    private String usersId;
	    private String usersCreatedDate;

	    private String usersName;
	    private String usersEmail;
	    private String usersPhone;
	    private String usersPostsalCode;   // postsal 맞춤
	    private String usersAddressLine1;
	    private String usersAddressLine2;

	    private String careIntroText;
	    private int careCertificateFilesNum;
	    private int carePassbookFilesNum;
	    private Integer careProfilesPhotoNumber; // nullable
	    private String careAccept;               // 'Y'/'N'
		public int getUsersNumber() {
			return usersNumber;
		}
		public void setUsersNumber(int usersNumber) {
			this.usersNumber = usersNumber;
		}
		public String getUsersId() {
			return usersId;
		}
		public void setUsersId(String usersId) {
			this.usersId = usersId;
		}
		public String getUsersCreatedDate() {
			return usersCreatedDate;
		}
		public void setUsersCreatedDate(String usersCreatedDate) {
			this.usersCreatedDate = usersCreatedDate;
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
		public Integer getCareProfilesPhotoNumber() {
			return careProfilesPhotoNumber;
		}
		public void setCareProfilesPhotoNumber(Integer careProfilesPhotoNumber) {
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
			return "AdminCareSignupDTO [usersNumber=" + usersNumber + ", usersId=" + usersId + ", usersCreatedDate="
					+ usersCreatedDate + ", usersName=" + usersName + ", usersEmail=" + usersEmail + ", usersPhone="
					+ usersPhone + ", usersPostsalCode=" + usersPostsalCode + ", usersAddressLine1=" + usersAddressLine1
					+ ", usersAddressLine2=" + usersAddressLine2 + ", careIntroText=" + careIntroText
					+ ", careCertificateFilesNum=" + careCertificateFilesNum + ", carePassbookFilesNum="
					+ carePassbookFilesNum + ", careProfilesPhotoNumber=" + careProfilesPhotoNumber + ", careAccept="
					+ careAccept + "]";
		}

	    
}
