package com.utopia.core.security.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
	private Long coAppRefreshTokenId;

	// Constructors

	/** default constructor */
	public AbstractCoAppRefreshToken() {
	}


	// Property accessors
	@Id
	@Column(name = "CO_APP_REFRESH_TOKEN_ID", unique = true, nullable = false, insertable = true, updatable = true, precision = 10, scale = 0)
	@GeneratedValue(generator="CoAppRefreshTokenGenerator")
	public Long getCoAppRefreshTokenId() {
		return this.coAppRefreshTokenId;
	}

	public void setCoAppRefreshTokenId(Long coAppRefreshTokenId) {
		this.coAppRefreshTokenId = coAppRefreshTokenId;
	}


}