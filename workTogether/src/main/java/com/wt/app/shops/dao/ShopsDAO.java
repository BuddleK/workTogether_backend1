package com.wt.app.shops.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.wt.app.dto.ShopsFavoritesActionDTO;
import com.wt.app.dto.ShopsListDTO;
import com.wt.config.MyBatisConfig;

public class ShopsDAO {
	public SqlSession sqlSession;

	public ShopsDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}

	// 모든 가게 리스트 가져오기
	public List<ShopsListDTO> shopSelectAll(Map<String, Integer> pgMap) {
		System.out.println("모든 가게 조회하기 - selectAll 메소드 실행 : ");
		List<ShopsListDTO> list = sqlSession.selectList("shops.listAll", pgMap);
		System.out.println("조회결과 : " + list);
		return list;
	}

	// 총 가게 수
	public int getTotal() {
		System.out.println("가게 총 개수 조회 - getTotal 메소드 실행");
		return sqlSession.selectOne("shops.getTotal");
	}

	// 동별 가게 리스트 가져오기
	public List<ShopsListDTO> shopSelectDongAll(Map<String, String> pgMap) {
		System.out.println("모든 가게 조회하기 - selectAll 메소드 실행 : ");
		List<ShopsListDTO> list = sqlSession.selectList("shops.searchEachDong", pgMap);
		System.out.println("조회결과 : " + list);
		return list;
	}

	// 동별 총 가게 수
	public int getDongTotal() {
		System.out.println("가게 총 개수 조회 - getTotal 메소드 실행");
		return sqlSession.selectOne("shops.getDongTotal");
	}

	// 법정 동명 가져오기 (ex => 방배동, 양재동)
	public List<ShopsListDTO> adminDongSelect() {
		System.out.println("법정 동명 가져오기 - adminDongSelect 실행");
		List<ShopsListDTO> list = sqlSession.selectList("shops.adminDong");
		System.out.println("조회결과 : " + list);
		return list;
	}

	// 내가 찜 했는지 불러오기
	public int selectFavorite(int usersNumber, int shopsNumber) {
		System.out.println("selectFavorite 실행");
		Map<String, Object> list = new HashMap<>();
		list.put("usersNumber", usersNumber);
		list.put("favoritesShopsNumber", shopsNumber);
		String t = sqlSession.selectOne("shops.favoriteSelect", list);
		System.out.println(t);

		Integer result = sqlSession.selectOne("shops.favoriteSelect");

		return result == null ? 0 : result;

	}

	// 찜 상태 확인
	public int isJim(Map<String, Integer> numbers) {
		Integer cnt = sqlSession.selectOne("shops.isJim", numbers);
		return (cnt != null && cnt > 0) ? 1 : -1;
	}

	// 찜하기
	public void addFavorites(ShopsFavoritesActionDTO shopsFavoritesActionDTO) {
		sqlSession.insert("shops.favoriteAdd", shopsFavoritesActionDTO);
	}

	// 찜 삭제
	public void deleteJim(Map<String, Integer> numbers) {
		System.out.println("삭제 메소드 실행");
		sqlSession.delete("shops.favoriteDelete", numbers);
		System.out.println("삭제 메소드 완료");
	}
}
