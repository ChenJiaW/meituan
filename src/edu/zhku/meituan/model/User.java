package edu.zhku.meituan.model;

public class User {
    /**
     *  userName 是用户的登录账号
     *  userPass 是用户的登录密码
     *  consumption 是用户的消费金额
     *  phone 是用户的电话
     *  address 是用户的地址
     *  id 是用户的编号，自动生成叠加
     */
    private String userName;
    private String userPass;
    private double consumption;
    private String address;
    private String phone;
    private int id;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public double getConsumption() {
        return consumption;
    }

    public void setConsumption(double consumption) {
        this.consumption = consumption;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User() {}
    public User(String userName, String userPass, double consumption, String address, String phone, int id) {
        this.userName = userName;
        this.userPass = userPass;
        this.consumption = consumption;
        this.address = address;
        this.phone = phone;
        this.id = id;
    }
}
