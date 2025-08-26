package com.wt.app.users.dao;

import org.apache.ibatis.session.SqlSession;

import com.wt.app.dto.FindIdDTO;
import com.wt.app.dto.FindPwDTO;
import com.wt.app.dto.UpdatePwDTO;
import com.wt.app.dto.UsersDTO;
import com.wt.app.dto.UsersLoginDTO;
import com.wt.config.MyBatisConfig;

public class UsersDAO {

	public SqlSession sqlSession;
	
	public UsersDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	
	 /** 회원가입 */
	 public long join(UsersDTO usersDTO) {
	        sqlSession.insert("UserMapper.insertUser", usersDTO); 
	        return usersDTO.getUsersNumber();
	    }

	    /** 아이디 중복체크: 사용 가능(true) / 불가(false) */
	    public boolean checkId(String usersId) {
	        Integer cnt = sqlSession.selectOne("userMapper.countByUsersId", usersId);
	        return cnt != null && cnt < 1;
	    }

	    /** 일반 로그인: 일치하는 사용자 정보를 반환 (없으면 null) */
	    public int normalLogin(UsersLoginDTO usersLoginDTO) {
	        return sqlSession.selectOne("userMapper.normalLogin", usersLoginDTO) != null ? sqlSession.selectOne("userMapper.normalLogin", usersLoginDTO) : -1 ;
	    }
	    /**  돌봄 로그인: 일치하는 사용자 정보를 반환 (없으면 null) */
	    public UsersDTO careLogin(UsersLoginDTO usersloginDTO) {
	        return sqlSession.selectOne("userMapper.careLogin", usersloginDTO);
	    }

	    /** 회원번호로 아이디 조회 (원시 long 그대로 전달 → 매퍼에서 #{value} 사용) */
	    public String getUsersId(long usersNumber) {
	        return sqlSession.selectOne("userMapper.getUsersId", usersNumber);
	    }

	    /** 아이디 찾기: 이름+휴대전화(+유형)으로 users_id 문자열 반환 */
	    public String findUserIdByNamePhone(FindIdDTO dto) {
	        return sqlSession.selectOne("userMapper.findUserIdByNamePhone", dto);
	    }

	    /** 비밀번호 찾기 검증(존재 시 usersNumber 반환) */
	    public Long verifyForPwReset(FindPwDTO dto) {
	        return sqlSession.selectOne("userMapper.verifyForPwReset", dto);
	    }

	    /** 비밀번호 변경 (usersId 기준) */
	    public int updatePasswordByUsersId(UpdatePwDTO dto) {
	        return sqlSession.update("userMapper.updatePasswordByUsersId", dto);
    }
}
