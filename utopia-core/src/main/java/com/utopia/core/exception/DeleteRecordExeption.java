/**
 * 
 */
package com.utopia.core.exception;

/**
 * @author Salarkia
 *
 */
public class DeleteRecordExeption extends CoreException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4756194734253553717L;

	/**
	 * 
	 */
	public DeleteRecordExeption() {
	}

	/**
	 * @param message
	 * @param cause
	 */
	public DeleteRecordExeption(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public DeleteRecordExeption(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public DeleteRecordExeption(Throwable cause) {
		super(cause);
	}

}
