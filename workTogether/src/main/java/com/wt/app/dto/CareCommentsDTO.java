package com.wt.app.dto;

public class CareCommentsDTO {
	private int commentsNumber;
	private int normalNumber;
	private int careNumber;
	private String commentsContent;
	private String commentsCreatedDate;
	private String commentsUpdatedDate;
	public int getCommentsNumber() {
		return commentsNumber;
	}
	public void setCommentsNumber(int commentsNumber) {
		this.commentsNumber = commentsNumber;
	}
	public int getNormalNumber() {
		return normalNumber;
	}
	public void setNormalNumber(int normalNumber) {
		this.normalNumber = normalNumber;
	}
	public int getCareNumber() {
		return careNumber;
	}
	public void setCareNumber(int careNumber) {
		this.careNumber = careNumber;
	}
	public String getCommentsContent() {
		return commentsContent;
	}
	public void setCommentsContent(String commentsContent) {
		this.commentsContent = commentsContent;
	}
	public String getCommentsCreatedDate() {
		return commentsCreatedDate;
	}
	public void setCommentsCreatedDate(String commentsCreatedDate) {
		this.commentsCreatedDate = commentsCreatedDate;
	}
	public String getCommentsUpdatedDate() {
		return commentsUpdatedDate;
	}
	public void setCommentsUpdatedDate(String commentsUpdatedDate) {
		this.commentsUpdatedDate = commentsUpdatedDate;
	}
	@Override
	public String toString() {
		return "CommentsDTO [commentsNumber=" + commentsNumber + ", normalNumber=" + normalNumber + ", careNumber="
				+ careNumber + ", commentsContent=" + commentsContent + ", commentsCreatedDate=" + commentsCreatedDate
				+ ", commentsUpdatedDate=" + commentsUpdatedDate + "]";
	}
	
	
	
	
}
