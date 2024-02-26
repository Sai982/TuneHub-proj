package com.example.bike.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Bike {
 
	@Id
	String engNo;
	String Brand;
	int cost;
	public Bike() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Bike(String engNo, String brand, int cost) {
		super();
		this.engNo = engNo;
		Brand = brand;
		this.cost = cost;
	}
	public String getEngNo() {
		return engNo;
	}
	public void setEngNo(String engNo) {
		this.engNo = engNo;
	}
	public String getBrand() {
		return Brand;
	}
	public void setBrand(String brand) {
		Brand = brand;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	@Override
	public String toString() {
		return "Bike [engNo=" + engNo + ", Brand=" + Brand + ", cost=" + cost + "]";
	}
	
}
