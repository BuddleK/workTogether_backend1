package com.wt.app.dto;

public class CareHeartDTO {
	 private int heartsNormalNumber;
	 private int heartsCareNumber;
	public int getHeartsNormalNumber() {
		return heartsNormalNumber;
	}
	public void setHeartsNormalNumber(int heartsNormalNumber) {
		this.heartsNormalNumber = heartsNormalNumber;
	}
	public int getHeartsCareNumber() {
		return heartsCareNumber;
	}
	public void setHeartsCareNumber(int heartsCareNumber) {
		this.heartsCareNumber = heartsCareNumber;
	}
	@Override
	public String toString() {
		return "CareHeartDTO [heartsNormalNumber=" + heartsNormalNumber + ", heartsCareNumber=" + heartsCareNumber
				+ "]";
	}
	 
	 
}
