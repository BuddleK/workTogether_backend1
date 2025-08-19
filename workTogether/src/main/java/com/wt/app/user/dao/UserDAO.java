package com.wt.app.user.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.wt.app.dto.UserDTO;
import com.wt.config.MyBatisConfig;

public class UserDAO {
    public SqlSession sqlSession;

    public UserDAO() {
        sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
    }
   

    public int countByUserId(String userId) {
        return sqlSession.selectOne("com.wt.app.user.dao.UserMapper.countByUserId", userId);
    }

    public int countByEmail(String email) {
        return sqlSession.selectOne("com.wt.app.user.dao.UserMapper.countByEmail", email);
    }

    public int insertUser(UserDTO dto) {
        sqlSession.insert("com.wt.app.user.dao.UserMapper.insertUser", dto);
        Integer key = sqlSession.selectOne("com.wt.app.user.dao.UserMapper.currvalUser");
        return key != null ? key : 0;
    }

    public int insertNormal(int userNumber, String level) {
        Map<String, Object> p = new HashMap<>();
        p.put("userNumber", userNumber);
        p.put("level", level);
        return sqlSession.insert("com.wt.app.user.dao.UserMapper.insertNormal", p);
    }

    /** 이름+휴대전화+유형으로 user_id 찾기 (아이디 찾기) */
    public String findUserIdByNamePhoneType(String userName, String userPhone, String userType) {
        Map<String, Object> p = new HashMap<>();
        p.put("userName", userName);
        p.put("userPhone", userPhone);
        p.put("userType", userType);
        return sqlSession.selectOne("com.wt.app.user.dao.UserMapper.findUserIdByNamePhoneType", p);
    }

    /** 이름+이메일로 user_id 찾기 */
    public String findUserIdByNameEmail(String userName, String userPhone) {
        Map<String, Object> p = new HashMap<>();
        p.put("userName", userName);
        p.put("userEmail", userPhone);
        return sqlSession.selectOne("com.wt.app.user.dao.UserMapper.findUserIdByNamePhone", p);
    }

    /** (비번찾기)  */
    public boolean existsUserForPw(String userId, String userName, String userPhone, String userType) {
        Map<String, Object> p = new HashMap<>();
        p.put("userId", userId);
        p.put("userName", userName);
        p.put("userPhone", userPhone);
        p.put("userType", userType);
        Integer cnt = sqlSession.selectOne("com.wt.app.user.dao.UserMapper.existsUserForPw", p);
        return cnt != null && cnt > 0;
    }

    /** 비밀번호 업데이트 */
    public int updatePasswordById(String userId, String newPw) {
        Map<String, Object> p = new HashMap<>();
        p.put("userId", userId);
        p.put("newPw", newPw);
        return sqlSession.update("com.wt.app.user.dao.UserMapper.updatePasswordById", p);
    }

    /** (옵션) 로그인 */
    public UserDTO login(String userId, String userPw) {
        Map<String, Object> p = new HashMap<>();
        p.put("userId", userId);
        p.put("userPw", userPw);
        return sqlSession.selectOne("com.wt.app.user.dao.UserMapper.login", p);
    }
}