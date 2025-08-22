package com.wt.app.dto;

public class AdminNewsBannerDTO {
	private int newsNumber;
	private String newsTitle;
	private String newsCreatedDate;

	public int getNewsNumber() {
		return newsNumber;
	}

	public void setNewsNumber(int newsNumber) {
		this.newsNumber = newsNumber;
	}

	public String getNewsTitle() {
		return newsTitle;
	}

	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}

	public String getNewsCreatedDate() {
		return newsCreatedDate;
	}

	public void setNewsCreatedDate(String newsCreatedDate) {
		this.newsCreatedDate = newsCreatedDate;
	}

	@Override
	public String toString() {
		return "AdminNewsBannerDTO [newsNumber=" + newsNumber + ", newsTitle=" + newsTitle + ", newsCreatedDate="
				+ newsCreatedDate + "]";
	}
}
