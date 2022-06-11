package com.setu.test.model;

import java.util.List;

public class EqualExpenseModel {
	private double amount;
	private int paidBy;
	private List<Integer> users;

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getPaidBy() {
		return paidBy;
	}

	public void setPaidBy(int paidBy) {
		this.paidBy = paidBy;
	}

	public List<Integer> getUsers() {
		return users;
	}

	public void setUsers(List<Integer> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "EqualExpenseModel [amount=" + amount + ", paidBy=" + paidBy + ", users=" + users + "]";
	}

}