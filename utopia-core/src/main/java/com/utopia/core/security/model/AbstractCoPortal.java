package com.utopia.core.security.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.utopia.core.model.AbstractUtopiaPersistent;

/**
 * AbstractCoPortal
 */
@MappedSuperclass
public abstract class AbstractCoPortal extends AbstractUtopiaPersistent implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1448463382033230626L;
	private Long coPortalId;
	private String name;
	private String domainName;

	// Constructors

	/** default constructor */
	public AbstractCoPortal() {
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE,
	generator="PortalSequenceGenerator")
	@Column(name = "CO_PORTAL_ID", unique = true, nullable = false, insertable = true, updatable = true, precision = 10, scale = 0)
	public Long getCoPortalId() {
		return this.coPortalId;
	}

	public void setCoPortalId(Long coPortalId) {
		this.coPortalId = coPortalId;
	}

	
	@Column(name = "NAME", unique = true, nullable = false, insertable = true, updatable = true, length = 300)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "DOMAIN_NAME", unique = true, nullable = false, insertable = true, updatable = true, length = 1000)
	public String getDomainName() {
		return this.domainName;
	}

	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}

}