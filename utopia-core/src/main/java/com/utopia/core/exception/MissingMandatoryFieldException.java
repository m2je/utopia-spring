package com.utopia.core.exception;

public class MissingMandatoryFieldException extends ValidationException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5036190110495782827L;

	public MissingMandatoryFieldException() {
		super();
	}

	public MissingMandatoryFieldException(String message, Throwable cause) {
		super(message, cause);
	}

	public MissingMandatoryFieldException(String message) {
		super(message);
	}

	public MissingMandatoryFieldException(Throwable cause) {
		super(cause);
	}

}
