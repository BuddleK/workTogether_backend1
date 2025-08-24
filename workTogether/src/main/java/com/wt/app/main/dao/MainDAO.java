package com.wt.app.main.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.wt.app.dto.MainDTO;
import com.wt.config.MyBatisConfig;

public class MainDAO {
	 public SqlSession sqlSession;
	 
	 public MainDAO() {
		 sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	 }
	 
	 //뉴스배너 조회
	 public List<MainDTO> newsBanner() {
			System.out.println("뉴스 배너 조회하기 - newsBanner 메소드 실행");
			List<MainDTO> list = sqlSession.selectList("main.newsBanner");
			System.out.println("조회결과 : " + list);
			return list;
		}

	 //추천가게 조회
	 public List<MainDTO> shops() {
			System.out.println("추천 가게 조회하기 - shops 메소드 실행");
			List<MainDTO> list = sqlSession.selectList("main.shops");
			System.out.println("조회결과 : " + list);
			return list;
		}
	 
	 //게시판 조회
	 public List<MainDTO> post() {
			System.out.println("게시판 조회하기 - post 메소드 실행");
			List<MainDTO> list = sqlSession.selectList("main.post");
			System.out.println("조회결과 : " + list);
			return list;
		}
	 
	 //지도 마커 조회
	 
	 
	 //돌봄회원 조회
	 public List<MainDTO> care() {
			System.out.println("돌봄회원 조회하기 - care 메소드 실행");
			List<MainDTO> list = sqlSession.selectList("main.care");
			System.out.println("조회결과 : " + list);
			return list;
		}
	 
}
