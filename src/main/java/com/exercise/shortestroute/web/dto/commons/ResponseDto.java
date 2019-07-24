package com.exercise.shortestroute.web.dto.commons;

public class ResponseDto<T> {
	
	public static boolean NOT_ERROR = false;
	public static boolean ERROR = true;
	private boolean isError;
	private String code;
	private String msg;
	private T response;
	
	public ResponseDto(boolean isError, String code, String msg, T response) {
		super();
		this.isError = isError;
		this.code = code;
		this.msg = msg;
		this.response = response;
	}

	public boolean isError() {
		return isError;
	}

	public void setError(boolean isError) {
		this.isError = isError;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getResponse() {
		return response;
	}
	
	public void setResponse(T response) {
		this.response = response;
	}

	@Override
	public String toString() {
		return "ExceptionDetailsDto [isError=" + isError + ", code=" + code + ", msg=" + msg + ", response=" + response
				+ "]";
	}
}
