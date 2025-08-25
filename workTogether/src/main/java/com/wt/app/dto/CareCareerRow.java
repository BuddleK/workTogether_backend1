package com.wt.app.dto;

public class CareCareerRow {
	private Long number;
	private String name;
	private String userId;
	private String date;
	private String status;
	public Long getNumber() {
		return number;
	}
	public void setNumber(Long number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "CareCareerRow [number=" + number + ", name=" + name + ", userId=" + userId + ", date=" + date
				+ ", status=" + status + "]";
	}
	
}
