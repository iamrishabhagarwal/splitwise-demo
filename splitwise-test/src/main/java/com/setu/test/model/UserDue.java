package com.setu.test.model;

public class UserDue {

	private int userId;
	private double userAmount;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public double getUserAmount() {
		return userAmount;
	}

	public void setUserAmount(double userAmount) {
		this.userAmount = userAmount;
	}

	@Override
	public String toString() {
		return "UserDue [userId=" + userId + ", userAmount=" + userAmount + "]";
	}

}
