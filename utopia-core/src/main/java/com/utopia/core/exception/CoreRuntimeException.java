/**
 * 
 */
package com.utopia.core.exception;

/**
 * @author salarkia
 *
 */
public class CoreRuntimeException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3214540141221780481L;

	/**
	 * 
	 */
	public CoreRuntimeException() {
	}

	/**
	 * @param message
	 */
	public CoreRuntimeException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public CoreRuntimeException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public CoreRuntimeException(String message, Throwable cause) {
		super(message, cause);
	}

}
