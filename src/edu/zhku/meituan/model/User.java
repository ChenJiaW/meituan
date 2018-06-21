package edu.zhku.meituan.model;

public class User {
	private int     id;   //�û�id
	private String  name ;//�û�����
	private String  passwd;//����
	private double  consumption ;//���ѽ��
	private String  phone ;//�û���ϵ�绰
	private String  address ;//�û�סַ

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPass() {
		return passwd;
	}
	public void setPass(String passwd) {
		this.passwd = passwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getConsumption() {
		return consumption;
	}
	public void setConsumption(double consumption) {
		this.consumption = consumption;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

}
