package com.utopia.common.systems;


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

import com.utopia.core.model.AbstractUtopiaPersistent;

/**
 * AbstractCmSystem entity provides the base persistence definition of the
 * CmSystem entity.
 * 
 * @author Mehdi
 */
@MappedSuperclass
public abstract class AbstractCmSystem  extends AbstractUtopiaPersistent implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 8275767449913038466L;

	private Long cmSystemId;
	
	private String name;
	private Set<CmSubsystem> cmSubsystems = new HashSet<CmSubsystem>(0);
	private String icon;
	private String abbreviation;
	// Constructors

	/** default constructor */
	public AbstractCmSystem() {
	}


	// Property accessors
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE,
			generator="SystemSequenceGenerator")
	@Column(name = "CM_SYSTEM_ID", unique = true, nullable = false, insertable = true, updatable = true, precision = 10, scale = 0)
	public Long getCmSystemId() {
		return this.cmSystemId;
	}

	public void setCmSystemId(Long cmSystemId) {
		this.cmSystemId = cmSystemId;
	}

	@Column(name = "NAME", unique = true, nullable = false, insertable = true, updatable = true, length = 200)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "cmSystem")
	public Set<CmSubsystem> getCmSubsystems() {
		return this.cmSubsystems;
	}

	public void setCmSubsystems(Set<CmSubsystem> cmSubsystems) {
		this.cmSubsystems = cmSubsystems;
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