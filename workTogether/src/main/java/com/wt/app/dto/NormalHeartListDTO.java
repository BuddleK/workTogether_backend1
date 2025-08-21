package com.wt.app.dto;

import java.util.List;

public class NormalHeartListDTO {
	// 돌봄 유저 테이블
	private int careNumber; // 돌봄 유저 번호
//	private List<T> profilesFilesNumber; // 프로필 파일 번호

	// 전체 유저 테이블
	private String userName; // 전체 유저 번호

	// 요일 테이블
	private enum Day {
		MONDAY('N'), TUESDAY('N'), WEDNESDAY('N'), THURSDAY('N'), FRIDAY('N'), SATURDAY('N'), SUNDAY('N');

		private char available;

		Day(char available) {
			this.available = available;
		}

		public char getAvailable() {
			return available;
		}

		public void setAvailable(char available) {
			this.available = available;
		}
	}

	// 돌봄 유저 테이블
	private String careIntroText; //

	public int getCareNumber() {
		return careNumber;
	}

	public void setCareNumber(int careNumber) {
		this.careNumber = careNumber;
	}

//	public List<T> getProfilesFilesNumber() {
//		return profilesFilesNumber;
//	}
//
//	public void setProfilesFilesNumber(List<T> profilesFilesNumber) {
//		this.profilesFilesNumber = profilesFilesNumber;
//	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCareIntroText() {
		return careIntroText;
	}

	public void setCareIntroText(String careIntroText) {
		this.careIntroText = careIntroText;
	}

	@Override
	public String toString() {
		return "NormalHeartListDTO [careNumber=" + careNumber + ", userName=" + userName + ", careIntroText="
				+ careIntroText + "]";
	}

}
