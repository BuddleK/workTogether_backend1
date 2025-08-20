package com.wt.app.posts.dao;

import org.apache.ibatis.session.SqlSession;

import com.wt.app.dto.NewsDTO;
import com.wt.config.MyBatisConfig;

public class PostsDAO {
	public SqlSession sqlSession;

	public PostsDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	
	//게시물 추가 메소드
	public void add(PostsDAO postsDTO) {
		sqlSession.insert("posts.add", postsDTO);
	}
	
	//게시물 불러오기 메소드
	public PostsDAO findById(int postsNumber) {
		PostsDAO postsDTO = null;
		postsDTO = sqlSession.selectOne("posts.findById", postsNumber);
		return postsDTO;
	}
	
	//게시물 수정 메소드
	public void edit(PostsDAO postsDTO) {
		sqlSession.update("posts.edit", postsDTO);
	}
	
	//게시물 삭제 메소드
	public void delete(int postsNumber) {
		sqlSession.delete("posts.delete", postsNumber);
	}
}
