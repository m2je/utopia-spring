package com.utopia.common.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.utopia.core.model.AbstractUtopiaPersistent;
import com.utopia.core.model.annotations.LookupConfiguration;

/**
 * AbstractCmSubsystem entity provides the base persistence definition of the
 * CmSubsystem entity.
 * 
 * @author Mehdi
 */
@Entity
@Table(name = "CM_SUBSYSTEM",  uniqueConstraints = { @UniqueConstraint(columnNames = { "NAME" }) })
	@LookupConfiguration(displayColumns={"abbreviation","name"})
public abstract class CmSubsystem extends AbstractUtopiaPersistent implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -4161690472465526832L;
	private CmSystem cmSystem;
	private String name;
	private String iconPath;
	private String abbreviation;
	// Constructors

	/** default constructor */
	public CmSubsystem() {
	}

	@ManyToOne
	@JoinColumn(name = "CM_SYSTEM_ID", unique = false, nullable = false, insertable = true, updatable = true)
	public CmSystem getCmSystem() {
		return this.cmSystem;
	}

	public void setCmSystem(CmSystem cmSystem) {
		this.cmSystem = cmSystem;
	}

	@Column(name = "NAME", unique = true, nullable = false, insertable = true, updatable = true, length = 200)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	@Column(name="ICON")
	public String getIconPath() {
		return iconPath;
	}

	public void setIconPath(String iconPath) {
		this.iconPath = iconPath;
	}
	@Column(name = "ABBREVIATION", unique = true, nullable = false, insertable = true, updatable = true, length = 2)
	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}
}