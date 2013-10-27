package com.utopia.common.systems;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import com.utopia.core.model.AbstractUtopiaPersistent;

/**
 * AbstractCmSubsystem entity provides the base persistence definition of the
 * CmSubsystem entity.
 * 
 * @author Mehdi
 */
@MappedSuperclass
public abstract class AbstractCmSubsystem extends AbstractUtopiaPersistent implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -4161690472465526832L;
	private Long cmSubsystemId;
	private CmSystem cmSystem;
	private String name;
	private String iconPath;
	private String abbreviation;
	// Constructors

	/** default constructor */
	public AbstractCmSubsystem() {
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE,
			generator="SubSystemSequenceGenerator")
	@Column(name = "CM_SUBSYSTEM_ID", unique = true, nullable = false, insertable = true, updatable = true, precision = 10, scale = 0)
	public Long getCmSubsystemId() {
		return this.cmSubsystemId;
	}

	public void setCmSubsystemId(Long cmSubsystemId) {
		this.cmSubsystemId = cmSubsystemId;
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