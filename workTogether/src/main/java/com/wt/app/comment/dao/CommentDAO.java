package com.wt.app.comment.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.wt.app.dto.CommentDTO;
import com.wt.config.MyBatisConfig;

public class CommentDAO {
	public SqlSession sqlSession;

	public CommentDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	
	//후기 작성
	public void insert(CommentDTO commentDTO) {
		sqlSession.insert("comment.selectAll", commentDTO);
	}
	
	//후기 목록
	public List<CommentDTO> selectAll(int careNumber){
		return sqlSession.selectList("comment.selectAll", careNumber);
	}
	
	//후기 삭제
	public void delete(int commentNumber) {
		sqlSession.delete("reply.delete", commentNumber);
	}
	
	//후기 수정
	public void update(CommentDTO commentDTO) {
		sqlSession.update("reply.update", commentDTO);
	}
}
