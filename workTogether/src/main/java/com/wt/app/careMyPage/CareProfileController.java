package com.wt.app.careMyPage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.careMyPage.dao.CareProfileDAO;
import com.wt.app.dto.CareProfileDTO;
import com.wt.app.dto.CareProfilePictureDTO;

public class CareProfileController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("====CareProfileController=====");

		Result result = new Result();
		CareProfileDAO careProfileDAO = new CareProfileDAO();
		CareProfileDTO careProfileDTO = new CareProfileDTO();
		
		
		//로그인한 사용자 번호 가져오기
		Integer usersNumber = (Integer) request.getSession().getAttribute("usersNumber");
		System.out.println("로그인 한 멤버 번호 : " + usersNumber);
		

		
		//프로필 사진 담아오기
		CareProfilePictureDTO careProfilePictureDTO = new CareProfilePictureDTO();
		careProfilePictureDTO = careProfileDAO.getProPic(usersNumber);
		request.setAttribute("profilePic", careProfilePictureDTO);
		
		
		//프로필 담아오기
		careProfileDTO = careProfileDAO.getProfile(usersNumber);
		

		
		
		
//		프로필 수정 서블릿을 타고 왔는지 아닌지 확인하기 위한 속성
		request.setAttribute("updatedComplete", false);
		
		try {
			// 프로필 수정 서블릿을 거쳐 왔는지 확인
			if((boolean) request.getAttribute("updated")) {
				request.setAttribute("updatedComplete", true);
				request.setAttribute("updated", false);	
			}
		} catch (Exception e) {
			System.out.println("수정 서블릿을 거치치 않음");
		}
		

		request.setAttribute("profile", careProfileDTO);
		result.setPath("/app/myPageCare/careProfile.jsp");
		result.setRedirect(false);
		return result;
	}

}
