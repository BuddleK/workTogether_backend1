package com.wt.app.careMyPage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.reflection.SystemMetaObject;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.careMyPage.dao.CareModifyDAO;
import com.wt.app.careMyPage.dao.CareProfileDAO;
import com.wt.app.dto.AdminCareSignupDTO;
import com.wt.app.dto.CareModifyDTO;
import com.wt.app.dto.CareProfilePictureDTO;

public class CareModifyController implements Execute{
	
	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	System.out.println("========CareModifyController 진입========");
		CareModifyDAO careModifyDAO = new CareModifyDAO();
		CareModifyDTO careModifyDTO = new CareModifyDTO();
		Result result = new Result();
		
		//로그인한 사용자 번호 가져오기
		Integer usersNumber = (Integer) request.getSession().getAttribute("usersNumber");
		System.out.println("로그인 한 멤버 번호 : " + usersNumber);
		
		//프로필 사진 담아오기
		CareProfileDAO careProfileDAO = new CareProfileDAO();
		CareProfilePictureDTO careProfilePictureDTO = new CareProfilePictureDTO();
		careProfilePictureDTO = careProfileDAO.getProPic(usersNumber);
		request.setAttribute("profilePic", careProfilePictureDTO);
		
		//개인정보 담아오기
		careModifyDTO = careModifyDAO.getInfo(usersNumber);
		
		System.out.println("회원 : " + careModifyDTO);
		
		System.out.println("회원 이름 : " + careModifyDTO.getUsersName());
		
		/*
		 * // 프로필 수정 서블릿을 타고 왔는지 아닌지 확인하기 위한 속성 request.setAttribute("updatedComplete",
		 * false);
		 * 
		 * try { // 프로필 수정 서블릿을 거쳐 왔는지 확인 if((boolean) request.getAttribute("updated"))
		 * { request.setAttribute("updatedComplete", true);
		 * request.setAttribute("updated", false); } } catch (Exception e) {
		 * System.out.println("수정 서블릿을 거치치 않음"); }
		 */

		
		request.setAttribute("careModify", careModifyDTO);
		result.setPath("/app/myPageCare/careModify.jsp");
		result.setRedirect(false);
		return result;
	}
	
}
