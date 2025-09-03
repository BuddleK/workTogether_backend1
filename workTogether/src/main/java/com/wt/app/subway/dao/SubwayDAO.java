package com.wt.app.subway.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.wt.app.dto.FilesStationsDTO;
import com.wt.app.dto.GetSubwayLineDTO;
import com.wt.app.dto.SubwayStationDTO;
import com.wt.config.MyBatisConfig;

public class SubwayDAO {
	public SqlSession sqlSession;

	// DAO 기본 생성자 호출(sqlSession 동작 위한 작업)
	public SubwayDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}

	// 지하철 호선 조회 Mapper 불러오기 위한 메소드
	public List<GetSubwayLineDTO> subwayLineSearch() {
		List<GetSubwayLineDTO> list = sqlSession.selectList("subway.subwayLineSearch");
		return list;
	}

	// 지하철 역 목록 이미지 조회 Mapper 불러오기 위한 메소드
	public List<SubwayStationDTO> subwayStationImgSearch(String lineNumber) {
	    int lineNum = 0;
	    try {
	        lineNum = Integer.parseInt(lineNumber);
	    } catch (NumberFormatException e) {
	        lineNum = 0; // 기본값 전체
	    }
		return sqlSession.selectList("subway.subwayStationImgSearch", lineNum);
	}

	// 지하철 역 이름 조회 Mapper 불러오기 위한 메소드
	public List<SubwayStationDTO> subwayStationSearch(String lineNumber) {
	    int lineNum = 0;
	    try {
	        lineNum = Integer.parseInt(lineNumber);
	    } catch (NumberFormatException e) {
	        lineNum = 0; // 기본값 전체
	    }
		return sqlSession.selectList("subway.subwayStationSearch", lineNum);
	}

	// 지하철 디테일 페이지 정보 조회 Mapper 불러오기 위한 메소드
	public List<SubwayStationDTO> subwayDetailSearch() {
		List<SubwayStationDTO> list = sqlSession.selectList("subway.subwayDetailSearch");
		return list;
	}
}
