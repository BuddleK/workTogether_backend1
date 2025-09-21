package com.wt.app.dto;

public class AdminDongDTO {

	private String shopsAdminDong;

	public AdminDongDTO() {
	}

	public AdminDongDTO(String shopsAdminDong) {
		this.shopsAdminDong = shopsAdminDong;
	}

	public String getShopsAdminDong() {
		return shopsAdminDong;
	}

	public void setShopsAdminDong(String shopsAdminDong) {
		this.shopsAdminDong = shopsAdminDong;
	}

	@Override
	public String toString() {
		return "AdminDongListDTO [shopsAdminDong=" + shopsAdminDong + "]";
	}
}
