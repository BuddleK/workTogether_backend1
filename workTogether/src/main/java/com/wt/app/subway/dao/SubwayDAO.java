package com.wt.app.subway.dao;

import org.apache.ibatis.session.SqlSession;

import com.wt.config.MyBatisConfig;

public class SubwayDAO {
	public SqlSession sqlSession;

	public SubwayDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
}
