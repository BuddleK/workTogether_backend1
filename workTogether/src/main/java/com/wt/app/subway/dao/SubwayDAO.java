package com.wt.app.subway.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.wt.app.dto.GetSubwayLineDTO;
import com.wt.app.dto.SubwayStationDTO;
import com.wt.config.MyBatisConfig;

public class SubwayDAO {
    private final SqlSession sqlSession;

    public SubwayDAO() {
        this.sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
    }

    public List<GetSubwayLineDTO> subwayLineSearch() {
        return sqlSession.selectList("subway.subwayLineSearch");
    }

    public List<SubwayStationDTO> subwayStationImgSearch(int lineNumber) {
        return sqlSession.selectList("subway.subwayStationImgSearch", lineNumber);
    }

    public List<SubwayStationDTO> subwayStationSearch(int lineNumber) {
        return sqlSession.selectList("subway.subwayStationSearch", lineNumber);
    }

    public List<SubwayStationDTO> subwayDetailSearch(int stationsId) {
        return sqlSession.selectList("subway.subwayDetailSearch", stationsId);
    }
}
