package edu.zhku.meituan.login.ctrl;

import edu.zhku.meituan.login.service.LoginService;
import edu.zhku.meituan.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/LoginCtrl")

public class LoginServlet extends HttpServlet {
    LoginService loginService = new LoginService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String userPass = request.getParameter("userPass");

        User upUser = new User();
        upUser.setUserName(userName);
        upUser.setAddress(userPass);

        boolean flag = loginService.checkLogin(upUser);

        request.setAttribute("userName", userName);
        HttpSession session = request.getSession();

        String path = request.getContextPath();

        session.setAttribute("userName", userName);
        if (flag) {
            request.getRequestDispatcher("/succ.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/fail.jsp").forward(request, response);
        }

    }
}
