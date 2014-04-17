package com.utopia.common.model;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.utopia.core.model.AbstractUtopiaSoftDelete;
import com.utopia.core.model.annotations.LookupConfiguration;

/**
 * 
 * @author Mehdi
 */
@LookupConfiguration(displayColumns="name")
@Entity
@Table(name = "CM_SYSTEM",uniqueConstraints = { @UniqueConstraint(columnNames = { "NAME" }) })
public  class System  extends AbstractUtopiaSoftDelete implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 8275767449913038466L;

	
	private String name;
	private Set<Subsystem> subsystems = new HashSet<Subsystem>(0);
	private String icon;
	private String abbreviation;
	// Constructors

	/** default constructor */
	public System() {
	}


	@Column(name = "NAME", unique = true, nullable = false, insertable = true, updatable = true, length = 200)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "system")
	public Set<Subsystem> getSubsystems() {
		return this.subsystems;
	}

	public void setSubsystems(Set<Subsystem> subsystems) {
		this.subsystems = subsystems;
	}
	@Column(name="ICON")
	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}
	@Column(name = "ABBREVIATION", unique = true, nullable = false, insertable = true, updatable = true, length = 2)
	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}
}