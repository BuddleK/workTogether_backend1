package com.wt.app.posts.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.wt.app.dto.PostsDTO;
import com.wt.app.dto.PostsListDTO;
import com.wt.config.MyBatisConfig;

public class PostsDAO {
	public SqlSession sqlSession;

	public PostsDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	
//	전체 게시글 조회 메소드
	public List<PostsListDTO> selectAll(Map<String, Integer> pageMap){
		System.out.println("모든 게시글 조회하기 - selectAll 메소드 실행 : " + pageMap);
		List<PostsListDTO> list = sqlSession.selectList("posts.selectAll", pageMap);
		System.out.println("조회결과 : " + list);
		return list;
	}
	
//	게시글 총 개수 가져오기
	public int getTotal() {
		System.out.println("게시글 총 개수 조회 - getTotal 메소드 실행");
		return sqlSession.selectOne("posts.getTotal");
	}
	
//	게시글 추가 메소드
	// 게시글 추가 후 자동으로 생성된 boardNumber 반환 -> 파일 테이블에서도 써야하기 때문에
	public int insertPosts(PostsDTO postsDTO) {
		int insert = sqlSession.insert("posts.insert", postsDTO);
		System.out.println(postsDTO + "출력");
		System.out.println(postsDTO.getPostsContent() + "출력 === ");
		System.out.println("게시글 작성 - insertPosts 메소드 실행 ");
		System.out.println("insert 결과 : " + insert);
		System.out.println("생성된 postsNumber : " + postsDTO.getPostsNumber());
		return postsDTO.getPostsNumber();
	}
	
//	조회수 추가 메소드
	public void updateReadCount(int postsNumber) {
		System.out.println("조회수 추가 메소드 - updateReadCount 메소드 실행 ");
		int result = sqlSession.update("posts.updateReadCount", postsNumber);
		System.out.println("조회수 업데이트 결과 : " + result);
	}
	
// 게시글 삭제 메소드
	   public void delete(int postsNumber) {
	      System.out.println("게시글 삭제 실행 : " + postsNumber);
	      sqlSession.delete("posts.delete", postsNumber);
	      System.out.println("게시글 삭제 쿼리 실행 완료");
	   }

// 게시글 수정 메소드
	   public void update(PostsDTO postsDTO) {
		   System.out.println("게시글 업데이트 실행 : ");
		   int result = sqlSession.update("postss.update", postsDTO);
		   System.out.println("게시물 업데이트 결과 : " + result);
	   }

// 게시글 상세 페이지 조회 메소드
	   public PostsListDTO select(int postsNumber) {
	      System.out.println("게시글 상세 페이지 조회(단건조회)");
	      return sqlSession.selectOne("posts.select", postsNumber);
	   }
	
//	게시글 검색 메소드
	   public List<PostsListDTO> search(Map<String, String> pageMapAndKeyWord) {
		   System.out.println("게시글 검색 메소드");
		   List<PostsListDTO> list = sqlSession.selectList("posts.search", pageMapAndKeyWord);
		   System.out.println("게시물 검색 결과 : " + list);
		   return list;
	   }
}
