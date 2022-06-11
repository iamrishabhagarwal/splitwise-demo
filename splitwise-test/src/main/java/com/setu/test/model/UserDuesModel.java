package com.setu.test.model;

import java.util.List;

public class UserDuesModel {

	private String type;
	private String message;
	private List<UserValuePairModel> userValueList;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<UserValuePairModel> getUserValueList() {
		return userValueList;
	}

	public void setUserValueList(List<UserValuePairModel> userValueList) {
		this.userValueList = userValueList;
	}

	@Override
	public String toString() {
		return "UserDuesModel [type=" + type + ", message=" + message + ", userValueList=" + userValueList + "]";
	}

}
