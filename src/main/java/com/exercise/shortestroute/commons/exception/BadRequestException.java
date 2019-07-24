package com.exercise.shortestroute.commons.exception;

public class BadRequestException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String exceptionCode;
	private Object response;
	
	public BadRequestException() {
		super();
	}
	
	public BadRequestException(String exceptionCode) {
		super();
		this.exceptionCode = exceptionCode;
	}

	public BadRequestException(String exceptionCode, Object response) {
		super();
		this.exceptionCode = exceptionCode;
		this.response = response;
	}
	
	public String getExceptionCode() {
		return exceptionCode;
	}
	public void setExceptionCode(String exceptionCode) {
		this.exceptionCode = exceptionCode;
	}
	public Object getResponse() {
		return response;
	}
	public void setResponse(Object response) {
		this.response = response;
	}

}
