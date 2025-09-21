package com.wt.app.careMyPage;

import java.io.IOException;
import java.text.NumberFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.careMyPage.dao.CarePointreturnDAO;
import com.wt.app.careMyPage.dao.CareProfileDAO;
import com.wt.app.dto.CareProfilePictureDTO;

public class CarePointreturnController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("============CarePointreturnController=========");
		Result result = new Result();
		
		//로그인한 사용자 번호 가져오기
		Integer usersNumber = (Integer) request.getSession().getAttribute("usersNumber");
		System.out.println("로그인 한 멤버 번호 : " + usersNumber);
		
		//프로필 사진 담아오기
		CareProfileDAO careProfileDAO = new CareProfileDAO();
		CareProfilePictureDTO careProfilePictureDTO = new CareProfilePictureDTO();
		careProfilePictureDTO = careProfileDAO.getProPic(usersNumber);
		request.setAttribute("profilePic", careProfilePictureDTO);
		
		CarePointreturnDAO carePointreturnDAO = new CarePointreturnDAO();
		// 포인트
		int point = carePointreturnDAO.getPoint(usersNumber);
		
		// 계좌
		String passbook = carePointreturnDAO.getPassbook(usersNumber);
		
		// 계좌번호가 아직 등록되지 않았을 때
		if(passbook == null) {
			request.setAttribute("pass", false);
			passbook = "[계좌가 아직 등록되지 않았습니다. 관리자에게 문의하시기 바랍니다.]";
		}else { // 등록되어 있을 때
			request.setAttribute("pass", true);
		}
		
		System.out.println("포인트 : " + point);
		System.out.println("계좌 : " + passbook);
		
		// 숫자에 쉼표 추가
		NumberFormat numberFormat = NumberFormat.getInstance();
		String commaPoint = numberFormat.format(point) + " P";
		System.out.println("쉼표 숫자 : " + commaPoint);

		request.setAttribute("point", point);
		request.setAttribute("commaPoint", commaPoint);
		
		request.setAttribute("passbook", passbook);

		result.setPath("/app/myPageCare/carePointreturn.jsp");
		result.setRedirect(false);
		return result;
	}

}
