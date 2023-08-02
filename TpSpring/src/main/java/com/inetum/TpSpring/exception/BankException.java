package com.inetum.TpSpring.exception;

public class BankException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public BankException() {
		
	}

	public BankException(String message) {
		super(message);
	}

	public BankException(String message, Throwable cause) {
		super(message, cause);
	}

}
