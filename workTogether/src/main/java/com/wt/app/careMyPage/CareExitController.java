package com.wt.app.careMyPage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.careMyPage.dao.CareExitDAO;
import com.wt.app.careMyPage.dao.CareProfileDAO;
import com.wt.app.dto.CareProfilePictureDTO;

public class CareExitController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Result result = new Result();
		
		CareExitDAO careExitDAO = new CareExitDAO();
		
		//로그인한 사용자 번호 가져오기
		Integer usersNumber = (Integer) request.getSession().getAttribute("usersNumber");
		System.out.println("로그인 한 멤버 번호 : " + usersNumber);
		
		//프로필 사진 담아오기
		CareProfileDAO careProfileDAO = new CareProfileDAO();
		CareProfilePictureDTO careProfilePictureDTO = new CareProfilePictureDTO();
		careProfilePictureDTO = careProfileDAO.getProPic(usersNumber);
		request.setAttribute("profilePic", careProfilePictureDTO);
		
		request.setAttribute("exitFlag", 1);
		
		if(careExitDAO.countReserve(usersNumber) == 0) {
			request.setAttribute("exitFlag", 0);
			System.out.println("매칭 없으면 폴스");
		}

		
		result.setPath("/app/myPageCare/careExit.jsp");
		result.setRedirect(false);
		return result;
	}

}
