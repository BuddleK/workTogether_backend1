package com.wt.app.news.dao;

import org.apache.ibatis.session.SqlSession;

import com.wt.app.dto.NewsListDTO;
import com.wt.config.MyBatisConfig;

public class NewsDAO {
	public SqlSession sqlSession;

	public NewsDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	
	//뉴스 추가 메소드
	public void add(NewsListDTO newsDTO) {
		sqlSession.insert("news.add", newsDTO);
	}
	
	//뉴스 불러오기 메소드
	public NewsListDTO findById(int newsNumber) {
		NewsListDTO newsDTO = null;
		newsDTO = sqlSession.selectOne("news.findById", newsNumber);
		return newsDTO;
	}
	
	//뉴스 수정 메소드
	public void edit(NewsListDTO newsDTO) {
		sqlSession.update("news.edit", newsDTO);
	}
	
	//뉴스 삭제 메소드
	public void delete(int newsNumber) {
		sqlSession.delete("news.delete", newsNumber);
	}
}
