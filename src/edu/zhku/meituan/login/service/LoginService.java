package edu.zhku.meituan.login.service;

import edu.zhku.meituan.login.dao.LoginDao;
import edu.zhku.meituan.model.User;

/**
 * 业务逻辑
 * @author deepin
 */
public class LoginService {
    LoginDao ld = new LoginDao();
    // 检查登录
    public boolean checkLogin(User upUser) {
        boolean flag = false;

        String userName = upUser.getUserName();
        String userPass = upUser.getUserPass();

        User dbUser = ld.getUserByName(userName);

        if (dbUser != null) {
            if (userName.equals(dbUser.getUserName())
                    && userPass.equals(dbUser.getUserPass())) {
                flag = true;
            }
        }

        return flag;
    }
}
