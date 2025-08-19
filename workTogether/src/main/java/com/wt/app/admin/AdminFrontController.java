package com.wt.app.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.wt.app.Result;
import com.wt.app.admin.AdminLoginOkController;

public class AdminFrontController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public AdminFrontController() { super(); }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doProcess(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doProcess(request, response);
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        String target = request.getRequestURI().substring(request.getContextPath().length());
        System.out.println("현재 경로(ADMIN) : " + target);

        Result result = null;

        switch (target) {

        case "/admin/login.ad":
                result = new Result();
                result.setPath("/WEB-INF/views/admin/login.jsp");
                result.setRedirect(false);
                break;

            case "/admin/loginOk.ad":
                if (!"POST".equalsIgnoreCase(request.getMethod())) {
                    response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
                    return;
                }
                result = new AdminLoginOkController().execute(request, response);
                break;
                
            case "/admin/logoutOk.ad":
                HttpSession session = request.getSession(false);
                if (session != null) session.invalidate();
                result = new Result();
                result.setPath(request.getContextPath() + "/index");
                result.setRedirect(true);
                break;

            default:
                response.sendError(HttpServletResponse.SC_NOT_FOUND);
                return;
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
