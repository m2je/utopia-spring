package com.utopia.core.security.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;

import com.utopia.core.model.SoftDeletePersistentSupport;

/**
 * AbstractCoApplication generated by Mehdi
 */
@MappedSuperclass
public abstract class AbstractCoApplication extends SoftDeletePersistentSupport implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -235908653141048628L;
	private Long coApplicationId;
	private String name;
	private String secretKey;
	private long tokenValidity;
	
	private Set<CoUserAppToken> coUserAppTokens = new HashSet<CoUserAppToken>(0);
	private Set<CoAppUscsAccss> coAppUscsAccsses = new HashSet<CoAppUscsAccss>(
			0);

	// Constructors

	/** default constructor */
	public AbstractCoApplication() {
	}

	
	// Property accessors
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE,
		generator="ApplicationSequenceGenerator")
	@Column(name = "CO_APPLICATION_ID", unique = true, nullable = false, insertable = true, updatable = true, precision = 10, scale = 0)
	public Long getCoApplicationId() {
		return this.coApplicationId;
	}

	public void setCoApplicationId(Long coApplicationId) {
		this.coApplicationId = coApplicationId;
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

	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "coApplication")
	public Set<CoUserAppToken> getCoUserAppTokens() {
		return this.coUserAppTokens;
	}

	public void setCoUserAppTokens(Set<CoUserAppToken> coUserAppTokens) {
		this.coUserAppTokens = coUserAppTokens;
	}

	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "coApplication")
	public Set<CoAppUscsAccss> getCoAppUscsAccsses() {
		return this.coAppUscsAccsses;
	}

	public void setCoAppUscsAccsses(Set<CoAppUscsAccss> coAppUscsAccsses) {
		this.coAppUscsAccsses = coAppUscsAccsses;
	}

	@Column(name="TOKEN_VALIDITY")
	public long getTokenValidity() {
		return tokenValidity;
	}


	public void setTokenValidity(long tokenValidity) {
		this.tokenValidity = tokenValidity;
	}

	
}