package com.utopia.core.exception;

import com.utopia.core.model.User;

public class LockRecordException extends CoreException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4020187217154894980L;

	User lockedUser;
	public LockRecordException() {
	}

	public LockRecordException(String message, Throwable cause) {
		super(message, cause);
	}

	public LockRecordException(String message) {
		super(message);
	}

	public LockRecordException(Throwable cause) {
		super(cause);
	}

	public User getLockedUser() {
		return lockedUser;
	}

	public void setLockedUser(User lockedUser) {
		this.lockedUser = lockedUser;
	}

	

}
