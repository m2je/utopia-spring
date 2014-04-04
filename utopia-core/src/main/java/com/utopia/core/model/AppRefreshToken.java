package com.utopia.core.model;

import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * AbstractAppRefreshToken 
 */
@Entity
@Table(name = "CO_APP_REFRESH_TOKEN", uniqueConstraints = { @UniqueConstraint(columnNames = { "REFRESH_TOKEN" }) })
public  class AppRefreshToken extends AbstractAppToken implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -2094317080061625538L;

	// Constructors

	/** default constructor */
	public AppRefreshToken() {
	}


	

}