package com.zmx.ssm.user.domain;


import java.util.List;

public class User {
	private int id;
	private String account;
	private String password;
	private List<Order> orderList;

	public int getId() {
		return id; 
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Order> getOrderList() {
		return orderList;
	}
	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", account=" + account + ", password="
				+ password + "]";
	}
	

	

}
