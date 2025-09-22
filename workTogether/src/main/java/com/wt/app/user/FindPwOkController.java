package com.wt.app.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.dto.FindPwDTO;
import com.wt.app.users.dao.UsersDAO;

public class FindPwOkController implements Execute {

  @Override
  public Result execute(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8");

    Result result = new Result();

    // 1) 파라미터 수집 + 정규화
    String usersId    = trimOrNull(request.getParameter("usersId"));
    String usersName  = trimOrNull(request.getParameter("usersName"));
    String usersPhone = trimOrNull(request.getParameter("usersPhone"));
    String usersType  = trimOrNull(request.getParameter("usersType")); // 'N'/'C' 또는 null
    String inputCode  = trimOrNull(request.getParameter("verificationCode")); // 사용자가 입력한 6자리

    // DB는 하이픈 없이 저장 → 숫자만 남김
    if (usersPhone != null) {
      usersPhone = usersPhone.replaceAll("[^0-9]", "");
    }

    // 2) 필수값 검증
    if (usersId == null || usersName == null || usersPhone == null || usersType == null || inputCode == null) {
      request.setAttribute("findPwError", "입력값이 부족합니다. 다시 확인해 주세요.");
      // 필요한 경우 이전 입력 보존
      preserveInputs(request, usersId, usersName, usersPhone, usersType);
      result.setRedirect(false);
      result.setPath("/app/login/findPassword.jsp");
      return result;
    }

    // 3) 휴대폰 인증 코드 검증(세션에 저장된 verificationCode와 일치해야 함)
    HttpSession session = request.getSession(false);
    String sessionCode = (session == null) ? null : (String) session.getAttribute("verificationCode");
    if (sessionCode == null || !sessionCode.equals(inputCode)) {
      request.setAttribute("findPwError", "휴대폰 인증이 완료되지 않았습니다.");
      preserveInputs(request, usersId, usersName, usersPhone, usersType);
      result.setRedirect(false);
      result.setPath("/app/login/findPassword.jsp");
      return result;
    }
    // 일회성 사용 후 즉시 제거
    if (session != null) {
      session.removeAttribute("verificationCode");
    }

    // 4) DB 조회로 본인 확인
    FindPwDTO dto = new FindPwDTO();
    dto.setUsersId(usersId);
    dto.setUsersName(usersName);
    dto.setUsersPhone(usersPhone);
    dto.setUsersType(usersType);

    UsersDAO usersDAO = new UsersDAO();
    Long usersNumber = usersDAO.verifyForPwReset(dto);

    if (usersNumber == null) {
      // 일치 계정 없음(문구는 통합적으로)
      request.setAttribute("findPwError", "입력하신 정보와 일치하는 회원이 없습니다.");
      preserveInputs(request, usersId, usersName, usersPhone, usersType);
      result.setRedirect(false);
      result.setPath("/app/login/findPassword.jsp");
      return result;
    }

    // 5) 비밀번호 재설정 단계 진입 보호(토큰/세션 값 설정)
    // - 최소한 usersNumber를 세션에 저장해서 modifyPassword.jsp 접근 시 확인
    // - 더 안전하게는 랜덤 토큰을 발급해 세션/서버 저장 후 다음 페이지에서 검증
    if (session == null) session = request.getSession(true);
    session.setAttribute("pwResetUsersNumber", usersNumber);

    // modifyPassword.jsp에서 request로 아이디가 필요하면 attribute도 함께 전달
    request.setAttribute("usersId", usersId);

    result.setRedirect(false); // forward (request 속성 유지)
    result.setPath("/app/login/modifyPassword.jsp");
    return result;
  }

  private String trimOrNull(String s) {
    if (s == null) return null;
    String t = s.trim();
    return t.isEmpty() ? null : t;
  }

  private void preserveInputs(HttpServletRequest req, String id, String name, String phone, String type) {
    req.setAttribute("prevUsersId",    id    == null ? "" : id);
    req.setAttribute("prevUsersName",  name  == null ? "" : name);
    req.setAttribute("prevUsersPhone", phone == null ? "" : phone);
    req.setAttribute("prevUsersType",  type  == null ? "" : type);
  }
}
