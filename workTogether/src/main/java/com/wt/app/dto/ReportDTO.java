package com.wt.app.dto;

public class ReportDTO {

//	-- 신고
//	create table tbl_report (
//		report_number NUMBER,
//		report_post_number number,
//		report_users_number number,
//		constraint pk_report primary key (report_number),
//		constraint fk_report_post foreign key (report_post_number) references tbl_posts (posts_number),
//		constraint fk_report_users foreign key (report_users_number) references tbl_users (users_number)
//	)
	
	private int reportNumber;
	private int reportPostNumber;
	private int reportUsersNumber;
	public int getReportNumber() {
		return reportNumber;
	}
	public void setReportNumber(int reportNumber) {
		this.reportNumber = reportNumber;
	}
	public int getReportPostNumber() {
		return reportPostNumber;
	}
	public void setReportPostNumber(int reportPostNumber) {
		this.reportPostNumber = reportPostNumber;
	}
	public int getReportUsersNumber() {
		return reportUsersNumber;
	}
	public void setReportUsersNumber(int reportUsersNumber) {
		this.reportUsersNumber = reportUsersNumber;
	}
	@Override
	public String toString() {
		return "ReportDTO [reportNumber=" + reportNumber + ", reportPostNumber=" + reportPostNumber
				+ ", reportUsersNumber=" + reportUsersNumber + "]";
	}
	
	
	
	
	
}
