package com.wt.app.careMyPage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.app.Result;

/**
 * Servlet implementation class CareMyPageFrontController
 */
@MultipartConfig
public class CareMyPageFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CareMyPageFrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String target = request.getRequestURI().substring(request.getContextPath().length());
		System.out.println("CareModifyFrontController 현재 경로 : " + target);
		Result result = new Result();
		switch(target) {
		case "/myPageCare/carePwCheck.cp":
			System.out.println("비밀번호 확인 페이지 요청");
			result = new CarePwCheckController().execute(request, response);
			break;
		case "/myPageCare/carePwCheckOk.cp":
			System.out.println("비밀번호 확인 페이지 처리 요청");
			result = new CarePwCheckOkController().execute(request, response);
			break;
		case "/myPageCare/careProfile.cp":
			System.out.println("프로필 수정 페이지 요청");
			result = new CareProfileController().execute(request, response);
			break;
		case "/myPageCare/careProfileUpdate.cp":
			System.out.println("프로필 수정 요청");
			result = new CareProfileUpdateController().execute(request, response);
			break;
		case "/myPageCare/careModify.cp":
			System.out.println("개인정보 수정 페이지 요청");
			result = new CareModifyController().execute(request, response);
			break;
		case "/myPageCare/careModifyOk.cp":
			System.out.println("개인정보 수정 요청");
			result = new CareModifyOkController().execute(request, response);
			break;
		case "/myPageCare/careMark.cp":
			System.out.println("찜한목록 페이지 요청");
			result = new CareMarkController().execute(request, response);
			break;
		case "/myPageCare/careMarkDelete.cp":
			System.out.println("체크한 찜 삭제 요청");
			result = new CareMarkDeleteController().execute(request, response);
			break;
		case "/myPageCare/careMatching.cp":
			System.out.println("매칭기록 페이지 요청");
			result = new CareMatchingController().execute(request, response);
			break;
		case "/myPageCare/careMatchingOk.cp":
			System.out.println("매칭 추가 요청");
			result = new CareMatchingOkController().execute(request, response);
			break;
		
			
		case "/myPageCare/careMsgList.cp":
			System.out.println("마이페이지 받은 쪽지리스트 요청");
			result = new CareMsgListOkController().execute(request, response);
			break;
		case "/myPageCare/careMsgGetJsList.cp":
			System.out.println("마이페이지 받은 쪽지리스트 JS 요청");
			result = new CareMsgGetListJsOkController().execute(request, response);
			break;
		case "/myPageCare/careMsgJsList.cp":
			System.out.println("마이페이지 보낸 쪽지리스트 JS 요청");
			result = new CareMsgListJsOkController().execute(request, response);
			break;
		case "/myPageCare/careMsgDeleteList.cp":
			System.out.println("마이페이지 받은 쪽지리스트 삭제");
			result = new CareMsgDeleteOkController().execute(request, response);
			break;
		case "/myPageCare/careMsgNumber.cp":
			System.out.println("마이페이지 쪽지 넘버값으로 불러오기");
			result = new CareMsgOkController().execute(request, response);
			break;
		case "/myPageCare/careMsgResend.cp":
			System.out.println("마이페이지 받은 쪽지 답장하기");
			result = new CareSendMsgOkController().execute(request, response);
			//대기
			break;
		case "/myPageCare/careReceiveList.cp":
			System.out.println("마이페이지 보낸 쪽지리스트 요청");
			result = new CareReceiveListOkController().execute(request, response);
			break;
		case "/myPageCare/normalReceiveDeleteList.cp":
			System.out.println("마이페이지 보낸 쪽지리스트 삭제");
			result = new CareReceiveDeleteOkController().execute(request, response);
			break;
		case "/myPageCare/careReceiveNumber.cp":
		  System.out.println("마이페이지 받은 쪽지 넘버값으로 불러오기"); 
		  result = new CareReceiveOkController().execute(request, response); 
		  break;
			
			
			
			
			
		case "/myPageCare/careMesseageDelete.cp":
			System.out.println("쪽지 삭제 요청");
			result = new CareMesseageDeleteController().execute(request, response);
			break;
		case "/myPageCare/carePost.cp":
			System.out.println("게시글 관리 페이지 요청");
			result = new CarePostController().execute(request, response);
			break;
		case "/myPageCare/carePostDelete.cp":
			System.out.println("게시글 관리-삭제 요청");
			result = new CarePostDeleteController().execute(request, response);
			break;
		case "/myPageCare/carePointreturn.cp":
			System.out.println("포인트 환급 신청 페이지 요청");
			result = new CarePointreturnController().execute(request, response);
			break;
		case "/myPageCare/carePointreturnOK.cp":
			System.out.println("포인트 환급 신청 요청");
			result = new CarePointreturnOkController().execute(request, response);
			break;
		case "/myPageCare/carePointList.cp":
			System.out.println("포인트 환급 내역 페이지 요청");
			result = new CarePointListController().execute(request, response);
			break;
		case "/myPageCare/careReference.cp":
			System.out.println("1대1문의 페이지 요청");
			result = new CareReferenceController().execute(request, response);
			break;
		case "/myPageCare/careExit.cp":
			System.out.println("회원탈퇴 페이지 요청");
			result = new CareExitController().execute(request, response);
			break;
		case "/myPageCare/careExitOk.cp":
			System.out.println("회원탈퇴지 요청");
			result = new CareExitOkController().execute(request, response);
			break;
		
		}
		
		if (result != null) {
			if (result.isRedirect()) {
				response.sendRedirect(result.getPath());
			} else {
				request.getRequestDispatcher(result.getPath()).forward(request, response);
			}
		}
		
		
	}

}
