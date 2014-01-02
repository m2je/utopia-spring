package com.utopia.core.security.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * AbstractCoUserAppToken 
 */
@MappedSuperclass
public abstract class AbstractCoUserAppToken extends AbstractCoAppToken implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 7898517976814203390L;
	private Long coUserAppTokenId;
	
	private String token;
	private Date validTo;
	private Date created;
	private Date updated;
	/** default constructor */
	public AbstractCoUserAppToken() {
	}

	
	// Property accessors
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE,
		generator="UserApplicationSequenceGenerator")
	@Column(name = "CO_USER_APP_TOKEN_ID", unique = true, nullable = false, insertable = true, updatable = true, precision = 10, scale = 0)
	public Long getCoUserAppTokenId() {
		return this.coUserAppTokenId;
	}

	public void setCoUserAppTokenId(Long coUserAppTokenId) {
		this.coUserAppTokenId = coUserAppTokenId;
	}

	@Column(name = "TOKEN", unique = false, nullable = false, insertable = true, updatable = true, length = 3000)
	public String getToken() {
		return this.token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "VALID_TO", unique = false, nullable = false, insertable = true, updatable = true, length = 7)
	public Date getValidTo() {
		return this.validTo;
	}

	public void setValidTo(Date validTo) {
		this.validTo = validTo;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED", unique = false, nullable = false, insertable = true, updatable = true, length = 7)
	public Date getCreated() {
		return this.created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UPDATED", unique = false, nullable = false, insertable = true, updatable = true, length = 7)
	public Date getUpdated() {
		return this.updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}


	

}