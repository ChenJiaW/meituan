package edu.zhku.meituan.register.ctrl;

import edu.zhku.meituan.model.User;
import edu.zhku.meituan.register.service.RegisterService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author deepin
 */
@WebServlet(name = "RegisterServlet", value = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    RegisterService service = new RegisterService();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String userPass = request.getParameter("userName");
        double consumption = Double.parseDouble(request.getParameter("consumption"));
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
//        这一条可以省略，因为 ID 是在数据库里面自增的， 不需要人为地添加
//        int id = Integer.parseInt(request.getParameter("id"));

        User upUser = new User();
        upUser.setUserName(userName);
        upUser.setUserPass(userPass);
        upUser.setConsumption(consumption);
        upUser.setAddress(address);
        upUser.setPhone(phone);

        boolean flag = service.insertUser(upUser);

        if (flag) {
            request.getRequestDispatcher("succ.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("fail.jsp").forward(request, response);
        }
    }

    /**
     * 用于判断在数据库中是否存在这个用户
     */
    protected boolean isExict(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("userName");
        return service.isExist(userName);
    }
}
