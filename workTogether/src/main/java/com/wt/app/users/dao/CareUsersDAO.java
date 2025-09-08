package com.wt.app.users.dao;

import org.apache.ibatis.session.SqlSession;

import com.wt.app.dto.CareSignDTO;
import com.wt.config.MyBatisConfig;

public class CareUsersDAO {
	public SqlSession sqlSession;

	public CareUsersDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}

	public void sign(CareSignDTO dto) {
		try {
			sqlSession.insert("CareUsersMapper.insertUser", dto);

			if (dto.getLicenseType() != null && dto.getLicenseName() != null && dto.getLicensePath() != null) {
				sqlSession.insert("CareUsersMapper.insertLicenseFile", dto);
			}

			if (dto.getAccountType() != null && dto.getAccountName() != null && dto.getAccountPath() != null) {
				sqlSession.insert("CareUsersMapper.insertAccountFile", dto);
			}

			if (dto.getCareAccept() == null)
				dto.setCareAccept("W");
			sqlSession.insert("CareUsersMapper.insertCareUser", dto);

			if (dto.getProfileType() != null && dto.getProfileName() != null && dto.getProfilePath() != null) {
				sqlSession.insert("CareUsersMapper.insertProfileFile", dto);
			}

			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			throw e;
		}
	}
}