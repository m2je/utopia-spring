package com.utopia.core.security.model;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import com.utopia.common.model.CmSubsystem;
import com.utopia.core.model.AbstractUtopiaPersistent;

/**
 * AbstractCoRoleSubsystemAcss entity provides the base persistence definition
 * of the CoRoleSubsystemAcss entity.
 * 
 * @author Mehdi
 */
@MappedSuperclass
public abstract class AbstractCoRoleSubsystemAcss extends AbstractUtopiaPersistent implements
		java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 5668835749477148338L;
	private CoRole coRole;
	private CmSubsystem cmSubsystem;

	// Constructors


	/** default constructor */
	public AbstractCoRoleSubsystemAcss() {
	}
	@ManyToOne
	@JoinColumn(name = "CO_ROLE_ID", unique = false, nullable = false, insertable = true, updatable = true)
	public CoRole getCoRole() {
		return this.coRole;
	}

	public void setCoRole(CoRole coRole) {
		this.coRole = coRole;
	}
	
	@ManyToOne	
	@JoinColumn(name = "CM_SUBSYSTEM_ID")
	public CmSubsystem getCmSubsystem() {
		return cmSubsystem;
	}

	public void setCmSubsystem(CmSubsystem cmSubsystem) {
		this.cmSubsystem = cmSubsystem;
	}

}