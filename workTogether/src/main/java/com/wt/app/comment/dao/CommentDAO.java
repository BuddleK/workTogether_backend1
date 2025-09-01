package com.wt.app.comment.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.wt.app.dto.CommentDTO;
import com.wt.config.MyBatisConfig;

public class CommentDAO {
	public SqlSession sqlSession;

	public CommentDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	
	//후기 목록
		public List<CommentDTO> selectAll(int careNumber){
			return sqlSession.selectList("comment.selectAll", careNumber);
		}
	
	//후기 작성
	public void insert(CommentDTO commentDTO) {
		sqlSession.insert("comment.insert", commentDTO);
	}
	
	//후기 삭제
	public void delete(Map<String, Integer> numbers) {
		sqlSession.delete("comment.delete", numbers);
	}
	
	//후기 수정
	public void update(CommentDTO commentDTO) {
		sqlSession.update("comment.update", commentDTO);
	}
}
