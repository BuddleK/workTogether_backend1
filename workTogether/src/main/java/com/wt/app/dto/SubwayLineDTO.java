package com.wt.app.dto;

public class SubwayLineDTO {
//    line_number NUMBER PRIMARY KEY,
//	  line_name VARCHAR2(20) NOT NULL UNIQUE
	private int lineNumber;
	private String lineName;
	public int getLineNumber() {
		return lineNumber;
	}
	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}
	public String getLineName() {
		return lineName;
	}
	public void setLineName(String lineName) {
		this.lineName = lineName;
	}
	
	@Override
	public String toString() {
		return "SubwayLineDTO [lineNumber=" + lineNumber + ", lineName=" + lineName + "]";
	}
}
