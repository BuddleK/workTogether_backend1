package com.wt.app.users.dao;

import org.apache.ibatis.session.SqlSession;
import com.wt.app.dto.FindIdDTO;
import com.wt.app.dto.FindPwDTO;
import com.wt.config.MyBatisConfig;

public class UsersDAO {
    private final SqlSession sqlSession;

    public UsersDAO() {
        this.sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
    }
    // 공통 회원 
    public int insertUser(Object usersDTO) {
        Integer usersNumber = sqlSession.selectOne("Users.insertUser", usersDTO);
        return usersNumber == null ? -1 : usersNumber;
    }
    // 아이디 중복 검사
    public boolean existsUserId(String usersId) {
        Integer cnt = sqlSession.selectOne("Users.existsUserId", usersId);
        return cnt != null && cnt > 0;
    }
    // 비밀번호 바꾸는 곳
    public int updatePassword(String usersId, String newPassword) {
        java.util.Map<String, Object> param = new java.util.HashMap<>();
        param.put("usersId", newPassword != null ? usersId : null);
        param.put("newPassword", newPassword);
        return sqlSession.update("Users.updatePasswordByUserId", param);
    }
    // 아이디 찾기
    public String findId(FindIdDTO dto) {
        return sqlSession.selectOne("Users.findIdByNamePhoneType", dto);
    }
    // 비번 찾기 전에 인증하기
    public boolean verifyForPwReset(FindPwDTO dto) {
        Integer ok = sqlSession.selectOne("Users.verifyForPwReset", dto);
        return ok != null && ok == 1;
    }
}
