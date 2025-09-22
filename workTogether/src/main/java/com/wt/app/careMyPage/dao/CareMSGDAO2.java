package com.wt.app.careMyPage.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.wt.app.dto.MessageSRDTO;
import com.wt.config.MyBatisConfig;

public class CareMSGDAO2 {
	public SqlSession sqlSession;
	
	public List<MessageSRDTO> selectAllMsg(Map<String, Integer> numbers) {
		List<MessageSRDTO> list = sqlSession.selectList("message.selectAllMsg", numbers);
		return list;
	}
	
	public int getMsgTotal (int usersNumber) {
		return sqlSession.selectOne("message.getMsgTotal", usersNumber);
	}
	
	public List<MessageSRDTO> selectAllReceive(Map<String, Integer> numbers) {
		List<MessageSRDTO> list = sqlSession.selectList("message.selectAllReceive", numbers);
		return list;
	}
	
	public void deleteMsg(int messageNumber) {
		sqlSession.delete("message.deleteMsg", messageNumber);
	}
	
	public int getReceiveTotal (int usersNumber) {
		return sqlSession.selectOne("message.getReceiveTotal", usersNumber);
	}
	
	public List<MessageSRDTO> getMsgContent(int messageNumber) {
		sqlSession.update("message.msgRead", messageNumber);
		return sqlSession.selectList("message.getMsgContent", messageNumber);
	}
	
	public List<MessageSRDTO> getMsgReceiveContent(int messageNumber) {
		return sqlSession.selectList("message.getMsgContent", messageNumber);
	}
	
	
}
