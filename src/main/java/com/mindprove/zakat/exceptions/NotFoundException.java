package com.mindprove.zakat.exceptions;

public class NotFoundException extends RuntimeException {

	private int httpStatusCode;

	public NotFoundException(String message,int httpStatusCode) {
		super(message);
		this.httpStatusCode=httpStatusCode;
		
	}

	public NotFoundException(Throwable cause,int httpStatusCode) {
		super(cause);
		this.httpStatusCode=httpStatusCode;
		
	}
}
