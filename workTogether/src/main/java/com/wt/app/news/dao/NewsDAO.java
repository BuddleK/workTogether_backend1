package com.wt.app.news.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.wt.app.dto.NewsListDTO;
import com.wt.app.dto.NewsMainDTO;
import com.wt.config.MyBatisConfig;

public class NewsDAO {
	public SqlSession sqlSession;

	public NewsDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}

	// 일반 뉴스 전체 불러오기 메소드
	public List<NewsListDTO> getNewsList(Map<String, Integer> pageMap) {
		System.out.println("모든 일반 뉴스 조회하기 - getNewsList 메소드 실행 : ");
		List<NewsListDTO> list = sqlSession.selectList("newsList.getNewsList", pageMap);
		System.out.println("조회결과 : " + list);
		return list;
	}
	//뉴스 총 개수 가져오기
	public int getTotal() {
		System.out.println("뉴스 총 개수 조회 - getTotal 메소드 실행");
		// 페이지네이션을 위해 전체 돌봄 회원 수 총 조회
		return sqlSession.selectOne("newsList.getTotal");
	}

	// 배너 뉴스 전체 불러오기 메소드
	public List<NewsMainDTO> getNewsMain() {
		System.out.println("모든 배너 뉴스 조회하기 - getNewsMain 메소드 실행 : ");
		List<NewsMainDTO> list = sqlSession.selectList("newsList.getNewsMain");
		System.out.println("조회결과 : " + list);
		return list;
	}
}