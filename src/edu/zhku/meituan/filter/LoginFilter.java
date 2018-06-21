package edu.zhku.meituan.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 用filter来做登录控制，但是路径目前不知道怎么写
 */
@WebFilter(filterName = "LoginFilter", value = "/mainfort/*")
public class LoginFilter implements Filter {
    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        HttpSession session = request.getSession();

        String userName = (String) session.getAttribute("userName");

        if (userName == null || "".equals(userName)) {
            // 如果在 session 中没有找到userName, 或者userName为空
            response.sendRedirect("/Login.jsp");
        } else {
            chain.doFilter(req, resp);
        }
    }

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

}
