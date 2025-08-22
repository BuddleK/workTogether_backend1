package com.wt.app.map.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.wt.app.dto.MarkerDTO;
import com.wt.config.MyBatisConfig;

public class MarkerDAO {
	public SqlSession sqlSession;
	public MarkerDAO(){
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	
	//모든 마커 조회하기
	public List<MarkerDTO> getMarkers(int usersNumber){
	      System.out.println("모든 마커 조회하기 - getMarkers 메소드 실행, 유저넘버 : " + usersNumber);
	      List<MarkerDTO> list = sqlSession.selectList("marker.selectAll", usersNumber);
	      System.out.println("조회결과 : " + list);
	      return list;	
	}
	
	//마커를 통해 찜하기
	public void markerAddFave(MarkerDTO markerDTO) {
		System.out.println("마커를 통해 찜하기 - markerAddFave 메소드 실행");
		sqlSession.selectList("marker.markerAddFave", markerDTO);
	}
	//마커를 통해 찜 삭제하기
	public void markerDeleteFave(MarkerDTO markerDTO) {
		System.out.println("마커를 통해 찜 삭제하기 - markerDeleteFave 메소드 실행");
		sqlSession.selectList("marker.markerDeleteFave", markerDTO);
		
	}
}
