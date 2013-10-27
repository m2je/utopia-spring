package com.utopia.core.exception;

public class ValidationException extends CoreRuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8444963732685470476L;

	public ValidationException() {
		super();
	}

	public ValidationException(String message, Throwable cause) {
		super(message, cause);
	}

	public ValidationException(String message) {
		super(message);
	}

	public ValidationException(Throwable cause) {
		super(cause);
	}

	
}
