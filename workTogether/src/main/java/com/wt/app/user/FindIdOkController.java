package com.wt.app.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.dto.FindIdDTO;
import com.wt.app.users.dao.UsersDAO;

public class FindIdOkController implements Execute {

	@Override
	public Result Execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

        // 파라미터 수집
        String usersName  = request.getParameter("usersName");
        String usersPhone = request.getParameter("usersPhone");
        String usersType  = request.getParameter("usersType"); // 'N' 또는 'C' (선택)

        // DTO 구성
        FindIdDTO dto = new FindIdDTO();
        dto.setUsersName(usersName);
        dto.setUsersPhone(usersPhone);
        dto.setUsersType(usersType);

        // DAO 호출: usersId 문자열만 반환
        UsersDAO usersDAO = new UsersDAO();
        String usersId = usersDAO.findUserIdByNamePhone(dto);

        // 결과 포워드
        Result result = new Result();
        if (usersId != null) {
            // 아이디 찾기 성공 → 결과 페이지
            request.setAttribute("usersId", usersId); // JSP에서 ${usersId}
            result.setRedirect(false);
            result.setPath("/app/login/findIdResult.jsp");
        } else {
            // 실패 → 입력 페이지로 메시지
            request.setAttribute("findIdError", "일치하는 회원 정보가 없습니다.");
            result.setRedirect(false);
            result.setPath("/app/login/findId.jsp");
        }
        return result;
	}

}
