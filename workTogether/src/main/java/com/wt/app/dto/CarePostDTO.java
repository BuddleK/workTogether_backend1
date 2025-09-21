package com.wt.app.dto;

import java.util.List;

public class CarePostDTO {

//	-- 게시글
//	CREATE TABLE tbl_posts (
//	    posts_number NUMBER PRIMARY KEY,
//	    posts_title VARCHAR2(300) NOT NULL,
//	    users_number NUMBER NOT NULL,
//	    posts_content VARCHAR2(4000) NOT NULL,
//	    posts_view_count NUMBER DEFAULT 0 NOT NULL,
//	    posts_created_date DATE NOT NULL,
//	    posts_updated_date DATE,
//	    posts_report_count NUMBER DEFAULT 0 NOT NULL,
//	    CONSTRAINT fk_posts_users FOREIGN KEY (users_number) REFERENCES tbl_users(users_number) ON DELETE CASCADE
//	);

	private int postsNumber;
	private String postsTitle;
	private int usersNumber;
	private String postsCreatedDate;
	private String postsUpdatedDate;
	private String usersName;
	
	public int getPostsNumber() {
		return postsNumber;
	}

	public void setPostsNumber(int postsNumber) {
		this.postsNumber = postsNumber;
	}

	public String getPostsTitle() {
		return postsTitle;
	}

	public void setPostsTitle(String postsTitle) {
		this.postsTitle = postsTitle;
	}

	public int getUsersNumber() {
		return usersNumber;
	}

	public void setUsersNumber(int usersNumber) {
		this.usersNumber = usersNumber;
	}

	public String getPostsCreatedDate() {
		return postsCreatedDate;
	}

	public void setPostsCreatedDate(String postsCreatedDate) {
		this.postsCreatedDate = postsCreatedDate;
	}

	public String getPostsUpdatedDate() {
		return postsUpdatedDate;
	}

	public void setPostsUpdatedDate(String postsUpdatedDate) {
		this.postsUpdatedDate = postsUpdatedDate;
	}

	@Override
	public String toString() {
		return "CarePostDTO [postsNumber=" + postsNumber + ", postsTitle=" + postsTitle + ", usersNumber=" + usersNumber
				+ ", postsCreatedDate=" + postsCreatedDate + ", postsUpdatedDate=" + postsUpdatedDate
				+ "]";
	}

	public String getUsersName() {
		return usersName;
	}

	public void setUsersName(String usersName) {
		this.usersName = usersName;
	}

}
