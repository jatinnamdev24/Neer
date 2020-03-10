package com.tr.model;


import javax.persistence.Id;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int pid;
	@NotNull(message="ProductName must be entered")
	@Pattern(regexp="[A-Za-z]+[0-9]+",message="name should be alphanumeric")
	@Size(min=6,message="pname atleast min 6 chars")
	private String pname;
	@NotNull(message="ProductDescritioin must be entered")
	private String decription;
	@NotNull(message="Productprice must be entered")
	@Min(value=100,message="price should be >100")
	private double price;
	@NotNull(message="category not blank")
	private String category;
	
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(int pid, String pname, String decription, double price) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.decription = decription;
		this.price = price;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getDecription() {
		return decription;
	}
	public void setDecription(String decription) {
		this.decription = decription;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", decription=" + decription + ", price=" + price
				+ ", category=" + category + "]";
	}
	
}
