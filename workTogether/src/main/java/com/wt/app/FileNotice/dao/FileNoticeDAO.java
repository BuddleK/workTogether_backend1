package com.wt.app.FileNotice.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.wt.app.dto.FileNoticeDTO;
import com.wt.app.dto.FilesLicenseDTO;
import com.wt.config.MyBatisConfig;

public class FileNoticeDAO {
	public SqlSession sqlSession;

	public FileNoticeDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}

	// 파일 추가 메소드
    public void insert(FileNoticeDTO dto) {
        System.out.println("파일 DAO - 파일 저장 " + dto);
        try {
            int result = sqlSession.insert("fileNotice.insert", dto);
            System.out.println("파일 저장 완료 - DB에 저장된 행의 개수 : " + result);

            // 방금 저장된 파일 확인 (뉴스는 files_number로 연결되므로 PK 기준 조회 예시)
            FilesLicenseDTO saved = selectByFilesNumber(dto.getNoticeFilesNumber());
            System.out.println("db에서 가져온 파일 : " + saved);
        } catch (Exception e) {
            System.out.println("파일 저장이 실패되었습니다. : " + e.getMessage());
            e.printStackTrace();
        }
    }

    // 파일 조회 메소드 (PK로 1건)
    public FilesLicenseDTO selectByFilesNumber(Integer filesNumber) {
        return sqlSession.selectOne("fileNotice.selectByFilesNumber", filesNumber);
    }

    // 파일 조회 메소드 (뉴스번호로 1건) - 뉴스가 파일 1개만 가질 때
    public FilesLicenseDTO selectByNewsNumber(int newsNumber) {
        return sqlSession.selectOne("fileNotice.selectByNewsNumber", newsNumber);
    }

    // 파일 삭제 메소드 (뉴스번호 기준 삭제)
    public void deleteByNewsNumber(int newsNumber) {
        sqlSession.delete("fileNotice.deleteByNewsNumber", newsNumber);
    }

    // 파일 삭제 메소드 (PK 기준 삭제)
    public void deleteByFilesNumber(int filesNumber) {
        sqlSession.delete("fileNotice.deleteByFilesNumber", filesNumber);
    }

    // (옵션) 최근 파일 목록 등 필요 시 추가
    public List<FilesLicenseDTO> selectRecent(int limit) {
        return sqlSession.selectList("fileNotice.selectRecent", limit);	}
}
