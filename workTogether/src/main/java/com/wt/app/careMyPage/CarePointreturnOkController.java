package com.wt.app.careMyPage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.careMyPage.dao.CarePointreturnDAO;

public class CarePointreturnOkController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("============CarePointreturnOkController=========");
		Result result = new Result();
		
		CarePointreturnDAO carePointreturnDAO = new CarePointreturnDAO();
		
		//로그인한 사용자 번호 가져오기
		Integer usersNumber = (Integer) request.getSession().getAttribute("usersNumber");
		System.out.println("로그인 한 멤버 번호 : " + usersNumber);
		
		String fee = request.getParameter("fee");

		System.out.println("서블릿 타지롱~");
		System.out.println("fee는 " + fee + "지롱~!");
		
		// 원래 포인트
		int originalPoint = carePointreturnDAO.getPoint(usersNumber);
		// 차감되고 남을 포인트
		int afterPoint = originalPoint - Integer.parseInt(fee);
		System.out.println("애프터포인트 : " + afterPoint);
		

		// 계좌
		String passbook = carePointreturnDAO.getPassbook(usersNumber);
		String bank = null; // 은행명
		String passNum = null; //놀립게도 이것이 계좌번호.
		
	    // 계좌가 비어있지 않다면 나누기 작업
	    if (passbook != null && !passbook.isEmpty()) {
	        String[] parts = passbook.split(" ");  // 공백을 기준으로 나눔
	        
	        if (parts.length == 2) {  // "은행명 계좌번호" 형식
	            bank = parts[0];     // 은행명
	            passNum = parts[1];  // 계좌번호
	        } else if (parts.length == 1) {  // 계좌번호만 입력된 경우
	            passNum = parts[0];  // 계좌번호만 저장
	            bank = "은행 미기입";          // 은행명은 null로 설정
	        }
	    }
		
		//포인트 차감을 위한 맵 생성
		Map<String, Integer> updatePointMap = new HashMap<>();
		updatePointMap.put("usersNumber", usersNumber);
		updatePointMap.put("afterPoint", afterPoint);
		
		//포인트 차감
		carePointreturnDAO.updatePoint(updatePointMap);
		
		// 환급 신청 내역 생성을 위한 맵 생성
		Map<String, Object> insertRefundMap = new HashMap<>();
		insertRefundMap.put("usersNumber", usersNumber);
		insertRefundMap.put("fee", fee);
		insertRefundMap.put("bank", bank);
		insertRefundMap.put("passNum", passNum);
		
		System.out.println("은행 : " + bank);
		System.out.println("계좌 : " + passNum);
		
		//환급 신청 생성
		carePointreturnDAO.insertRefund(insertRefundMap);
		
		
		result.setPath("/myPageCare/carePointreturn.cp");
		result.setRedirect(false);
		return result;
	}
}
