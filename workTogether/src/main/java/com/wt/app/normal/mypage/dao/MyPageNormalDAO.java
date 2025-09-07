package com.wt.app.normal.mypage.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.wt.app.dto.NormalFavoriteListDTO;
import com.wt.app.dto.NormalMatchingDTO;
import com.wt.app.dto.NormalModifyDTO;
import com.wt.app.dto.NormalPostsListDTO;
import com.wt.app.dto.NormalReferenceListDTO;
import com.wt.config.MyBatisConfig;

public class MyPageNormalDAO {
	public SqlSession sqlSession;

	public MyPageNormalDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}

	public boolean checkPw(Map<String, String> numbers) {
		System.out.println("checkPw 메소드 출력: " +(Integer)sqlSession.selectOne("myPageNormal.checkPw", numbers));
		return (Integer) sqlSession.selectOne("myPageNormal.checkPw", numbers) > 0;
	}

	public List<NormalModifyDTO> normalSearch(String usersNumber) {
		System.out.println("개인 정보 조회하기 - normalSearch 메소드 실행" + usersNumber);
		List<NormalModifyDTO> list = sqlSession.selectList("myPageNormal.normalSearch", usersNumber);
		System.out.println("조회결과 : " + list);
		return list;
	}

	public void normalModify(NormalModifyDTO normalModifyDTO) throws SQLException {
		System.out.println("개인 정보 수정 - normalModify 메소드 실행" + normalModifyDTO);
		try {
			sqlSession.update("myPageNormal.normalModify", normalModifyDTO);
			
		} catch (Exception e) {
			throw new SQLException("email_dup");
		}
	}

	public List<NormalFavoriteListDTO> normalfavoriteListSearch(Map<String, Integer> pgMap) {
		System.out.println("찜 목록 조회하기 - normalfavoriteListSearch 메소드 실행");
		List<NormalFavoriteListDTO> list = sqlSession.selectList("myPageNormal.normalfavoriteListSearch", pgMap);
		System.out.println("조회결과 : " + list);
		return list;
	}
	
	public int getTotal() {
		return sqlSession.selectOne("myPageNormal.getTotal");
	}

	public void normalfavoriteListDelete(NormalFavoriteListDTO normalFavoriteListDTO) {
		System.out.println("찜 목록 삭제하기 - normalfavoriteListDelete 메소드 실행" + normalFavoriteListDTO);
		sqlSession.delete("myPageNormal.normalfavoriteListDelete", normalFavoriteListDTO);
		System.out.println("찜 목록 삭제하기 실행 완료");
	}

	public List<NormalMatchingDTO> normalMatchingSearch() {
		System.out.println("매칭 목록 조회하기 - normalMatchingSearch 메소드 실행");
		List<NormalMatchingDTO> list = sqlSession.selectList("myPageNormal.normalMatchingSearch");
		System.out.println("조회결과 : " + list);
		return list;
	}

	public List<NormalPostsListDTO> normalPostsListSearch(int usersNumber) {
		System.out.println("게시물 리스트 조회하기 - normalPostsListSearch 메소드 실행" + usersNumber);
		List<NormalPostsListDTO> list = sqlSession.selectList("myPageNormal.normalPostsListSearch", usersNumber);
		System.out.println("조회결과 : " + list);
		return list;
	}

	public void normalPostsListDelete(NormalPostsListDTO normalPostsListDTO) {
		System.out.println("게시물 리스트 삭제하기 - normalPostsListDelete 메소드 실행" + normalPostsListDTO);
		sqlSession.delete("myPageNormal.normalPostsListDelete", normalPostsListDTO);
		System.out.println("게시물 리스트 삭제하기 실행 완료");
	}

	public int normalReferenceInsert(NormalReferenceListDTO normalReferenceListDTO) {
		sqlSession.insert("myPageNormal.normalReferenceInsert", normalReferenceListDTO);
		return normalReferenceListDTO.getReferenceNumber();
	}
	
	public List<NormalReferenceListDTO> normalReferenceListSearch() {
		System.out.println("문의 목록 조회하기 - normalReferenceListSearch 메소드 실행");
		List<NormalReferenceListDTO> list = sqlSession.selectList("myPageNormal.normalReferenceListSearch");
		System.out.println("조회결과 : " + list);
		return list;
	}
	
	public void normalExit(int usersNumber) {
		sqlSession.delete("myPageNormal.normalExit", usersNumber);
	}
}
