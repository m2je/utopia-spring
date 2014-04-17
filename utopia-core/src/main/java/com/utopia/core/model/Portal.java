package com.utopia.core.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Abstractortal
 */
@Entity
@Table(name = "CO_PORTAL", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "DOMAIN_NAME" }),
		@UniqueConstraint(columnNames = { "NAME" }) })
public  class Portal extends AbstractUtopiaSoftDelete implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1448463382033230626L;
	private String name;
	private String domainName;

	// Constructors

	/** default constructor */
	public Portal() {
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