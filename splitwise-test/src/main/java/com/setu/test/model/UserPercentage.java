package com.setu.test.model;

public class UserPercentage {

	private int userId;
	private double percentage;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public double getPercentage() {
		return percentage;
	}

	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}

	@Override
	public String toString() {
		return "UserPercentage [userId=" + userId + ", percentage=" + percentage + "]";
	}

}
