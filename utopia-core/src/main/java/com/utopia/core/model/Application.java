package com.utopia.core.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * @author Mehdi
 */
@Entity
@Table(name = "CO_APPLICATION",  uniqueConstraints = { @UniqueConstraint(columnNames = { "NAME" }) })
public  class Application extends SoftDeletePersistentSupport implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -235908653141048628L;
	private String name;
	private String secretKey;
	private int tokenValidity;
	
	private Set<UserAppToken> userAppTokens = new HashSet<UserAppToken>(0);
	private Set<AppUscsAccss> appUscsAccsses = new HashSet<AppUscsAccss>(
			0);
	private String scope;
	private String redirectURL;
	// Constructors

	/** default constructor */
	public Application() {
	}


	@Column(name = "NAME", unique = true, nullable = false, insertable = true, updatable = true, length = 3000)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "SECRET_KEY", unique = false, nullable = false, insertable = true, updatable = true, length = 3000)
	public String getSecretKey() {
		return this.secretKey;
	}

	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}

	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "application")
	public Set<UserAppToken> getUserAppTokens() {
		return this.userAppTokens;
	}

	public void setUserAppTokens(Set<UserAppToken> userAppTokens) {
		this.userAppTokens = userAppTokens;
	}

	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "application")
	public Set<AppUscsAccss> getAppUscsAccsses() {
		return this.appUscsAccsses;
	}

	public void setAppUscsAccsses(Set<AppUscsAccss> appUscsAccsses) {
		this.appUscsAccsses = appUscsAccsses;
	}

	@Column(name="TOKEN_VALIDITY")
	public int getTokenValidity() {
		return tokenValidity;
	}


	public void setTokenValidity(int tokenValidity) {
		this.tokenValidity = tokenValidity;
	}

	@Column
	public String getScope() {
		return scope;
	}


	public void setScope(String scope) {
		this.scope = scope;
	}

	@Column(name="redirect_URL")
	public String getRedirectURL() {
		return redirectURL;
	}


	public void setRedirectURL(String redirectURL) {
		this.redirectURL = redirectURL;
	}


	
	
}