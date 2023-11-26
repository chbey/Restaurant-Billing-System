package com;

public class Dish {
 private int sno;
 private String dishName;
 private double price;
 
 public Dish(int sno ,String dishName, double price) {
	 this.sno=sno;
	 this.dishName=dishName;
	 this.price=price;
 }
 
 public int getSno() {
	 return this.sno;
 }
 
 public String getDishName() {
	 return this.dishName;
 }
 public double getPrice() {
	 return this.price;
 }
}
