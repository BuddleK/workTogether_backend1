package com.wt.app.subway.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.wt.app.dto.GetSubwayLineDTO;
import com.wt.app.dto.SubwayStationDTO;
import com.wt.config.MyBatisConfig;

public class SubwayDAO {
	public SqlSession sqlSession;

	public SubwayDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	
	public List<GetSubwayLineDTO> subwayLineSearch(){
		List<GetSubwayLineDTO> list = sqlSession.selectList("subway.subwayLineSearch");
		return list;
	}

	public String subwayStationImgSearch(){
		String img = sqlSession.select("subway.subwayStationImgSearch");
		return img;
	}
	
	public List<SubwayStationDTO> subwayDetailSearch(){
		List<SubwayStationDTO> list = sqlSession.selectList("subway.subwayDetailSearch");
		return list;
	}
}
