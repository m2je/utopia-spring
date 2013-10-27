package com.utopia.core.security.exception;


public class NotAuthenticatedException extends UtopiaSecurityException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5998265491171611890L;

	public NotAuthenticatedException() {
		super();
	}

	public NotAuthenticatedException(String message, Throwable cause) {
		super(message, cause);
	}

	public NotAuthenticatedException(String message) {
		super(message);
	}

	public NotAuthenticatedException(Throwable cause) {
		super(cause);
	}

	

}
