package com.wt.app.news.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.wt.app.dto.AdminNewsBoardDTO;
import com.wt.app.dto.AdminNewsBoardListDTO;
import com.wt.config.MyBatisConfig;

public class AdminNewsDAO {
	public SqlSession sqlSession;

	public AdminNewsDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}

	// 전체 뉴스 조회
	public List<AdminNewsBoardListDTO> selectAll(Map<String, Integer> pageMap) {
		System.out.println("전체 뉴스 조회 - selectAll 메소드 실행" + pageMap);
		List<AdminNewsBoardListDTO> list = sqlSession.selectList("adminNews.selectAll", pageMap);
		System.out.println("조회결과 : " + list);
		return list;
	}

	// 뉴스 총 갯수
	public int getTotal() {
		System.out.println("뉴스 총 개수 조회 - getTotal 메소드 실행");
		return sqlSession.selectOne("adminNews.getTotal");
	}

	// 뉴스 등록 후 자동 생성된 newsNumber 반환
	public int insertNews(AdminNewsBoardDTO newsDTO) {
		int insert = sqlSession.insert("adminNews.insert", newsDTO);
		System.out.println("뉴스 작성 - insertNews 메소드 실행");
		System.out.println("insert 결과 : " + insert);
		System.out.println("생성된 newsNumber : " + newsDTO.getNewsNumber());
		return newsDTO.getNewsNumber();
	}

	// 뉴스 삭제
	public void delete(int newsNumber) {
	    System.out.println("뉴스 삭제 실행 : newsNumber=" + newsNumber);
	    int result = sqlSession.delete("adminNews.delete", newsNumber);
	    System.out.println("뉴스 삭제 결과 : " + result);
	}

	// 뉴스 수정
    public void update(AdminNewsBoardDTO newsDTO) {
        System.out.println("뉴스 수정 실행 : " + newsDTO);
        int result = sqlSession.update("adminNews.update", newsDTO);
        System.out.println("뉴스 수정 결과 : " + result);
    }
    // 뉴스 상세 조회 (1건)
    public AdminNewsBoardDTO select(int newsNumber) {
        System.out.println("뉴스 상세 페이지 조회(단건조회)");
        return sqlSession.selectOne("adminNews.selectOne", newsNumber);
    }
}
