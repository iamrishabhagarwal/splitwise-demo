package com.setu.test.model;

public class UserValuePairModel {

	private String name;
	private double amount;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "UserValuePairModel [name=" + name + ", amount=" + amount + "]";
	}

	public UserValuePairModel(String name, double amount) {
		super();
		this.name = name;
		this.amount = amount;
	}

}
