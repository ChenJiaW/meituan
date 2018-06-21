package edu.zhku.meituan.login.dao;

import edu.zhku.meituan.model.User;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author deepin
 */
public class LoginDao {
    public User getUserByName(User user) {
        User tempUser =new User();
        String username = user.getName();
        String passwd = user.getPass();
        System.out.println("i am coming to the dao layer ");
        java.sql.Connection con;
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/mysql";
        String user1 = "root";
        String password = "123456";
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url,user1,password);
            if(!con.isClosed())
                System.out.println("Succeeded connecting to the Database!");
            java.sql.Statement statement = con.createStatement();
            String sql = "select * from useradmin where name='"+username+"' and passwd='"+passwd+"'";
            ResultSet rs = statement.executeQuery(sql);
            String name = null;
            String pass = null;
            while(rs.next()){
                name = rs.getString("name");
                passwd = rs.getString("passwd");
                tempUser.setName(name);
                tempUser.setPass(passwd);
            }
            rs.close();
            con.close();
        } catch(ClassNotFoundException e) {
            System.out.println("Sorry,can`t find the Driver!");
            e.printStackTrace();
        } catch(SQLException e) {
            e.printStackTrace();
        }catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally{
            System.out.println("数据库数据查询获取！！");
        }

        return tempUser;
    }
}
