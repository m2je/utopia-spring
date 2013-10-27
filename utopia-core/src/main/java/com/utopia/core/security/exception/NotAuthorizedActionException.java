/**
 * 
 */
package com.utopia.core.security.exception;


/**
 * @author salarkia
 *
 */
public class NotAuthorizedActionException extends UtopiaSecurityException {

	
	private Long usecaseId;
	private Long actionId;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2717573062142666578L;

	/**
	 * 
	 */
	public NotAuthorizedActionException() {
	}

	/**
	 * @param message
	 * @param cause
	 */
	public NotAuthorizedActionException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public NotAuthorizedActionException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public NotAuthorizedActionException(Throwable cause) {
		super(cause);
	}

	public Long getUsecaseId() {
		return usecaseId;
	}

	public void setUsecaseId(Long usecaseId) {
		this.usecaseId = usecaseId;
	}

	public Long getActionId() {
		return actionId;
	}

	public void setActionId(Long actionId) {
		this.actionId = actionId;
	}

}
