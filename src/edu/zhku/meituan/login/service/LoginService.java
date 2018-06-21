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

        String userName = upUser.getName();
        String userPass = upUser.getPass();

        User dbUser = ld.getUserByName(upUser);

        if (dbUser != null) {
            if (userName.equals(dbUser.getName())
                    && userPass.equals(dbUser.getPass())) {
                flag = true;
            }
        }

        return flag;
    }
}
