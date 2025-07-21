package com.mindprove.zakat.exception;

public class AlreadyExistException extends RuntimeException {

	private final int httpStatusCode;

	public AlreadyExistException(String message, int httpStatusCode) {
		super(message);
		this.httpStatusCode = httpStatusCode;

	}

	public AlreadyExistException(Throwable cause, int httpStatusCode) {
		super(cause);
		this.httpStatusCode = httpStatusCode;
	}
}
