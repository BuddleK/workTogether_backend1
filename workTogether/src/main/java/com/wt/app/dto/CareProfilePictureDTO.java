package com.wt.app.dto;

public class CareProfilePictureDTO {
	private String profilesFilesType;
	private String profilesFilesName;
	private String profilesFilesPath;
	public String getProfilesFilesType() {
		return profilesFilesType;
	}
	public void setProfilesFilesType(String profilesFilesType) {
		this.profilesFilesType = profilesFilesType;
	}
	public String getProfilesFilesName() {
		return profilesFilesName;
	}
	public void setProfilesFilesName(String profilesFilesName) {
		this.profilesFilesName = profilesFilesName;
	}
	public String getProfilesFilesPath() {
		return profilesFilesPath;
	}
	public void setProfilesFilesPath(String profilesFilesPath) {
		this.profilesFilesPath = profilesFilesPath;
	}
	@Override
	public String toString() {
		return "CareProfilePictureDTO [profilesFilesType=" + profilesFilesType + ", profilesFilesName="
				+ profilesFilesName + ", profilesFilesPath=" + profilesFilesPath + "]";
	}
	
}
