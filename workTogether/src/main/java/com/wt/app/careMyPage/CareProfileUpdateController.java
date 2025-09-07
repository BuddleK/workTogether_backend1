package com.wt.app.careMyPage;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.careMyPage.dao.CareProfileDAO;
import com.wt.app.dto.CareProfileDTO;
@MultipartConfig
public class CareProfileUpdateController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("====CareProfile업데이트Controller=====");
		Result result = new Result();
		CareProfileDAO careProfileDAO = new CareProfileDAO();
		CareProfileDTO careProfileDTO = new CareProfileDTO();
		CareProfileDTO updatedCareProfileDTO = new CareProfileDTO();
		
		//로그인한 사용자 번호 가져오기
		Integer usersNumber = (Integer) request.getSession().getAttribute("usersNumber");
		
		careProfileDTO = careProfileDAO.getProfile(usersNumber);
		
		String mon = request.getParameter("dayMonday") == null ? "N" : "Y";
		String tue = request.getParameter("dayTuesday") == null ? "N" : "Y";
		String wed = request.getParameter("dayWednesday") == null ? "N" : "Y";
		String thu = request.getParameter("dayThursday") == null ? "N" : "Y";
		String fri = request.getParameter("dayFriday") == null ? "N" : "Y";
		String sat = request.getParameter("daySaturday") == null ? "N" : "Y";
		String sun = request.getParameter("daySunday") == null ? "N" : "Y";

		System.out.println("월요일은 ~~~ Y일까요 N일까요~~~ 두구둑두굳구.... 정답은 : " + mon);
		System.out.println("화요일은 ~~~ Y일까요 N일까요~~~ 두구둑두굳구.... 정답은 : " + tue);
		System.out.println("수요일은 ~~~ Y일까요 N일까요~~~ 두구둑두굳구.... 정답은 : " + wed);
		System.out.println("목요일은 ~~~ Y일까요 N일까요~~~ 두구둑두굳구.... 정답은 : " + thu);
		System.out.println("금요일은 ~~~ Y일까요 N일까요~~~ 두구둑두굳구.... 정답은 : " + fri);
		System.out.println("토요일은 ~~~ Y일까요 N일까요~~~ 두구둑두굳구.... 정답은 : " + sat);
		System.out.println("일요일은 ~~~ Y일까요 N일까요~~~ 두구둑두굳구.... 정답은 : " + sun);
		
		Part proPic = request.getPart("proPic");
		String originalproPicFileName = proPic.getSubmittedFileName();
		System.out.println("프로필 사진 : " + originalproPicFileName);
		
		// 파일명과 확장자 분리
		String proPicFileName = null;
		String proPicFileExt = null;
		
		String proFileSizeBytes = null;
		
		// 들어온 게 있을 때
		if(originalproPicFileName != "" && originalproPicFileName != null) {
			System.out.println("originalproPicFileName이 널 또는 빈칸이 아님");
			if (originalproPicFileName != null && originalproPicFileName.lastIndexOf(".") != -1) {
			    int dotIndex = originalproPicFileName.lastIndexOf("."); // 가장 오른쪽의 . 위치
			    proPicFileName = originalproPicFileName.substring(0, dotIndex); // .을 기준으로 왼쪽 문자열(파일 이름)
			    proPicFileExt  = originalproPicFileName.substring(dotIndex); // .을 기준으로 오른쪽 문자열(파일 확장자)
			} else {
				proPicFileName = originalproPicFileName; // 확장자 없는 경우
				proPicFileExt  = "none";            // 빈 문자열
			}
		    //일단 들어온 파일이 있으면 byte 구하기
			System.out.println("일단 들어온 파일이 있으면 byte 구하기");
			proFileSizeBytes = String.valueOf(proPic.getSize()); // 파일 크기 (byte 단위)
			System.out.println("파일 크기: " + proFileSizeBytes + " bytes");
		}else {
			System.out.println("선택한 파일이 널 또는 빈칸임!!!");
			proPicFileExt = careProfileDTO.getProfilesFilesType();
			proPicFileName = careProfileDTO.getProfilesFilesName();
			proFileSizeBytes = careProfileDTO.getProfilesFilesSizeBytes();
		}

		System.out.println("파일명: " + proPicFileName);
		System.out.println("확장자: " + proPicFileExt);
		

		
		
		String usersPostsalCode = request.getParameter("usersPostsalCode");
		String usersAddressLine1 = request.getParameter("usersAddressLine1");
		String usersAddressLine2 = request.getParameter("usersAddressLine2");
		
		System.out.println("우편번호 : " + usersPostsalCode);
		System.out.println("주소 : " + usersAddressLine1);
		System.out.println("상세주소 : " + usersAddressLine2);
		
		String careIntroText = request.getParameter("careIntroText");
		
		System.out.println("소개글 : " + careIntroText);
		
		

		
		// 회원번혼
		updatedCareProfileDTO.setUsersNumber(usersNumber);
		
		updatedCareProfileDTO.setDayMonday(mon);
		updatedCareProfileDTO.setDayTuesday(tue);
		updatedCareProfileDTO.setDayWednesday(wed);
		updatedCareProfileDTO.setDayThursday(thu);
		updatedCareProfileDTO.setDayFriday(fri);
		updatedCareProfileDTO.setDaySaturday(sat);
		updatedCareProfileDTO.setDaySunday(sun);
		
		updatedCareProfileDTO.setUsersPostsalCode(usersPostsalCode);
		updatedCareProfileDTO.setUsersAddressLine1(usersAddressLine1);
		updatedCareProfileDTO.setUsersAddressLine2(usersAddressLine2);
		
		updatedCareProfileDTO.setProfilesFilesType(proPicFileExt);
		updatedCareProfileDTO.setProfilesFilesName(proPicFileName);
		// 경로는 원래 그대로 넣음
		updatedCareProfileDTO.setProfilesFilesPath(careProfileDTO.getProfilesFilesPath());
		updatedCareProfileDTO.setProfilesFilesSizeBytes(proFileSizeBytes);
		
		updatedCareProfileDTO.setCareIntroText(careIntroText);
		
		
		
		System.out.println("뭐가 나오려나~" + updatedCareProfileDTO);
		
		if(careProfileDAO.checkDay(usersNumber)) {
			System.out.println("정보가 없군요");
			careProfileDAO.insertDay(updatedCareProfileDTO);
		}else {
			System.out.println("요일정보있음!!!");
			careProfileDAO.updateDay(updatedCareProfileDTO);
		}

		//주소정보 업데이트!!
		careProfileDAO.updateAddr(updatedCareProfileDTO);
		careProfileDAO.updateProPic(updatedCareProfileDTO);
		careProfileDAO.updateIntro(updatedCareProfileDTO);
		
		//업데이트 서블릿을 거침을 알려주기
		request.setAttribute("updated", true);
		
//		request.setAttribute("profile", careProfileDTO);
		result.setPath("/myPageCare/careProfile.cp");
		result.setRedirect(false);
		return result;
	}
	
}
