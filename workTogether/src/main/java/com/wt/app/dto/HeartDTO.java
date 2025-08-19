package com.wt.app.dto;

public class HeartDTO {
//    hearts_normal_number NUMBER NOT NULL,
//    hearts_care_number NUMBER NOT NULL
	int normalNumber;
	int careNumber;

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

	@Override
	public String toString() {
		return "HeartDTO [normalNumber=" + normalNumber + ", careNumber=" + careNumber + "]";
	}

}
