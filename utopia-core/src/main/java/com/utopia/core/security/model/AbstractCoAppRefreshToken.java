package com.utopia.core.security.model;

import javax.persistence.MappedSuperclass;

/**
 * AbstractCoAppRefreshToken 
 */
@MappedSuperclass
public abstract class AbstractCoAppRefreshToken extends AbstractCoAppToken implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -2094317080061625538L;

	// Constructors

	/** default constructor */
	public AbstractCoAppRefreshToken() {
	}


	

}