package com.mindprove.zakat.exceptions;

public class APIHandlerException extends RuntimeException {

	private final int httpStatusCode;

	public APIHandlerException(String message, int httpStatusCode) {
		super(message);
		this.httpStatusCode = httpStatusCode;
	}

	public APIHandlerException(Throwable cause, int httpStatusCode) {
		super(cause);
		this.httpStatusCode = httpStatusCode;
	}

}
