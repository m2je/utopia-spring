package com.utopia.core.exception;

import java.util.Map;

public class CoreException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1481584445896947458L;
	private Map<String,Object>context;
	/**
	 * 
	 */
	public CoreException() {
		super();
	}

	/**
	 * @param message
	 * @param cause
	 */
	public CoreException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public CoreException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public CoreException(Throwable cause) {
		super(cause);
	}

	public Map<String, Object> getContext() {
		return context;
	}

	public void setContext(Map<String, Object> context) {
		this.context = context;
	}

}
