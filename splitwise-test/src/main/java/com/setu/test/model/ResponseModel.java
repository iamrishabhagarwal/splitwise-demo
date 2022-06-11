package com.setu.test.model;

public class ResponseModel {

	private String status;
	private String statusCode;
	private String message;
	private Object respObj;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getRespObj() {
		return respObj;
	}

	public void setRespObj(Object respObj) {
		this.respObj = respObj;
	}

	public ResponseModel(String status, String statusCode, String message, Object respObj) {
		super();
		this.status = status;
		this.statusCode = statusCode;
		this.message = message;
		this.respObj = respObj;
	}

	public ResponseModel() {
		super();
	}

	@Override
	public String toString() {
		return "ResponseModel [status=" + status + ", statusCode=" + statusCode + ", message=" + message + ", respObj="
				+ respObj + "]";
	}

}
