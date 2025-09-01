package com.wt.app.dto;

public class NormalExitDTO {
	// 일반 유저 테이블
	private int usersNumber; // 일반 유저 번호

	public int getUsersNumber() {
		return usersNumber;
	}

	public void setUsersNumber(int usersNumber) {
		this.usersNumber = usersNumber;
	}

	@Override
	public String toString() {
		return "NormalExitDTO [usersNumber=" + usersNumber + "]";
	}

}
