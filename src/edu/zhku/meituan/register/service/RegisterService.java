package edu.zhku.meituan.register.service;

import edu.zhku.meituan.model.User;
import edu.zhku.meituan.register.dao.RegisterDao;

public class RegisterService {
    private RegisterDao registerDao = new RegisterDao();

    public boolean insertUser(User upUser) {
        boolean flag;

        String userName = upUser.getUserName();
        // 数据库存在这个用户名，不给插入
        if (!registerDao.isExistByName(userName)) {
            return false;
        }

        flag = registerDao.insertUser(upUser);

        return flag;
    }

    public boolean isExist(String name) {
        return registerDao.isExistByName(name);
    }

}
