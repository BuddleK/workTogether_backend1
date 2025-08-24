package com.wt.app.report.dao;

import org.apache.ibatis.session.SqlSession;

import com.wt.config.MyBatisConfig;

public class ReportDAO {
	public SqlSession sqlSession;

	public ReportDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	// 게시글 신고
	public void reportAdd() {
		sqlSession.insert("report.reportAdd");
	}
	
	
}
