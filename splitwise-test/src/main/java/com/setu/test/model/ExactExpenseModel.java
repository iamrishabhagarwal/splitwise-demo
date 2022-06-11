package com.setu.test.model;

import java.util.List;

public class ExactExpenseModel {
	private double amount;
	private int paidBy;
	private List<UserDue> userDues;

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

	public List<UserDue> getUserDues() {
		return userDues;
	}

	public void setUserDues(List<UserDue> userDues) {
		this.userDues = userDues;
	}

	@Override
	public String toString() {
		return "ExactExpenseModel [amount=" + amount + ", paidBy=" + paidBy + ", userDues=" + userDues + "]";
	}

}
