package com.wt.app.dto;

public class CareCareerRowDTO {
	
	private Integer usersNumber;
    private Integer number;
    private String name;
    private String userId;
    private String date;
    private String status;
	public Integer getUsersNumber() {
		return usersNumber;
	}
	public void setUsersNumber(Integer usersNumber) {
		this.usersNumber = usersNumber;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
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
		return "CareCareerRowDTO [usersNumber=" + usersNumber + ", number=" + number + ", name=" + name + ", userId="
				+ userId + ", date=" + date + ", status=" + status + "]";
	}
	
	
	
}
