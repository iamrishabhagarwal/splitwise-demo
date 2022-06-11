package com.setu.test.model;

public class SettleExpenseModel {
	private int id;
	private double amount;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "SettleExpenseModel [id=" + id + ", amount=" + amount + "]";
	}

}
