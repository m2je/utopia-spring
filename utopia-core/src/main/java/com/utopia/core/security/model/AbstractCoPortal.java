package com.utopia.core.security.model;

import javax.persistence.Column;
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
	private String name;
	private String domainName;

	// Constructors

	/** default constructor */
	public AbstractCoPortal() {
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