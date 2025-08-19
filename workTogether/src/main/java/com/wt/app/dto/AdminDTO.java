package com.wt.app.dto;

public class AdminDTO {
	
    private int adminNumber;
    private String adminId;
    private String adminName;
    private String adminPassword;
    
  
    public int getAdminNumber() {
		return adminNumber;
	}
    
	public void setAdminNumber(int adminNumber) {
		this.adminNumber = adminNumber;
	}

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	@Override
	public String toString() {
		return "AdminDTO [adminNumber=" + adminNumber + ", adminId=" + adminId + ", adminName=" + adminName
				+ ", adminPassword=" + adminPassword + "]";
	}
    
    
}
