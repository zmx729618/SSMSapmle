package com.zmx.ssm.user.domain;

public class Order {
	
    private int id;  
    private double price;   
    private User user;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", price=" + price + "]";
	} 
    
    


}
