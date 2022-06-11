package com.setu.test.model;

import java.util.List;

public class PercentageExpenseModel {

	private double amount;
	private int paidBy;
	private List<UserPercentage> userPercentages;

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

	public List<UserPercentage> getUserPercentages() {
		return userPercentages;
	}

	public void setUserPercentages(List<UserPercentage> userPercentages) {
		this.userPercentages = userPercentages;
	}

	@Override
	public String toString() {
		return "PercentageExpenseModel [amount=" + amount + ", paidBy=" + paidBy + ", userPercentages="
				+ userPercentages + "]";
	}

}
