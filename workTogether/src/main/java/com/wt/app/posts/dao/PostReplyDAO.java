package com.wt.app.posts.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.wt.app.dto.PostReplyDTO;
import com.wt.config.MyBatisConfig;


public class PostReplyDAO {
	public SqlSession sqlSession;

	public PostReplyDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	
	
	
	//댓글 목록
		public List<PostReplyDTO> selectAll(int postsNumber){
			return sqlSession.selectList("postReply.listAll", postsNumber);
		}
	//댓글 작성
		public void insert(PostReplyDTO postReplyDTO) {
			sqlSession.insert("postReply.replyAdd",postReplyDTO);
		}
		
		//댓글 수정
		public void update(PostReplyDTO postReplyDTO) {
			sqlSession.update("postReply.replyUpdate", postReplyDTO);
		}
		//댓글 삭제
		public void delete(int replyNumber) {
			sqlSession.delete("postReply.replyDelete", replyNumber);
		}
	
}
