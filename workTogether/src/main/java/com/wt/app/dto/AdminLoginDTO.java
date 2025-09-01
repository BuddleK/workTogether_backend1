package com.wt.app.dto;

public class AdminLoginDTO {
	
    private int adminNumber; 		//관리자 번호
    private String adminId;			//관리자 아이디
    private String adminName;		//관리자 이름
    private String adminPassword;	//관리자 비밀번호
    
  
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
