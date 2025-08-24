package com.wt.app.careMyPage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.careMyPage.dao.CareProfileDAO;
import com.wt.app.dto.CareProfileDTO;

public class CareProfileController implements Execute {

	@Override
	public Result Execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		CareProfileDAO careProfileDAO = new CareProfileDAO();
//		CareProfileDTO profile = new CareProfileDTO();
		Result result = new Result();
		
//		Integer usersNumber = (Integer) request.getSession().getAttribute("usersNumber");
//        profile.setUsersNumber(usersNumber);
        
//		int profilesFilesNumber = request.getParameter("profilesFilesNumber");
//		String profilesFilesType = request.getParameter("profilesFilesType");
//		String profilesFilesName = request.getParameter("profilesFilesName");
//		String profilesFilesPath = request.getParameter("profilesFilesPath");
//		int profilesFilesSizeBytes = request.getParameter("profilesFilesSizeBytes");
//		String profilesCreatedDate = request.getParameter("profilesCreatedDate");
//		String dayMonday = request.getParameter("dayMonday"); 
//		String dayTuesday = request.getParameter("dayTuesday"); 
//		String dayWednesday = request.getParameter("dayWednesday"); 
//		String dayThursday = request.getParameter("dayThursday"); 
//		String dayFriday = request.getParameter("dayFriday"); 
//		String daySaturday = request.getParameter("daySaturday"); 
//		String daySunday = request.getParameter("daySunday"); 
//        String usersPostsalCode = request.getParameter("usersPostsalCode");   
//        String usersAddressLine1 = request.getParameter("usersAddressLine1");   
//        String usersAddressLine2 = request.getParameter("usersAddressLine2");   
//        String careIntroText = request.getParameter("careIntroText");
//        
//        profile.set;
        
        
        
        
		result.setPath("/app/myPageCare/careProfile.jsp");
		result.setRedirect(false);
		return result;
	}

}
