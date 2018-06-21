package edu.zhku.meituan.buycar.ctrl;

import edu.zhku.meituan.buycar.service.BuyCarService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "BuyCarServlet", value = "/BuyCarServlet")
public class BuyCarServlet extends HttpServlet {
    BuyCarService buyCarService = new BuyCarService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * 1.显示所有的未提交订单的菜品
         */
        List list = buyCarService.getDishesByFlag();

    }


}
