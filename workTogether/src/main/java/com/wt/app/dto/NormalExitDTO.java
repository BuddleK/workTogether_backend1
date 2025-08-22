package com.wt.app.dto;

public class NormalExitDTO {
	// 일반 유저 테이블
	private int normalNumber; // 일반 유저 번호

	public int getNormalNumber() {
		return normalNumber;
	}

	public void setNormalNumber(int normalNumber) {
		this.normalNumber = normalNumber;
	}

	@Override
	public String toString() {
		return "NormalExitDTO [normalNumber=" + normalNumber + "]";
	}

}
