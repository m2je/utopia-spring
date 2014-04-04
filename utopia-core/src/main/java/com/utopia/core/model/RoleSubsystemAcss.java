package com.utopia.core.model;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.utopia.common.model.Subsystem;
import com.utopia.core.security.SecurityChangeListener;

/**
 * 
 * @author Mehdi
 */
@Entity
@Table(name = "CO_ROLE_SUBSYSTEM_ACSS",  uniqueConstraints = {})
@EntityListeners(value=SecurityChangeListener.class)	
public  class RoleSubsystemAcss extends AbstractUtopiaPersistent implements
		java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 5668835749477148338L;
	private Role role;
	private Subsystem subsystem;

	// Constructors


	/** default constructor */
	public RoleSubsystemAcss() {
	}
	@ManyToOne
	@JoinColumn(name = "CO_ROLE_ID", unique = false, nullable = false, insertable = true, updatable = true)
	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	@ManyToOne	
	@JoinColumn(name = "CM_SUBSYSTEM_ID")
	public Subsystem getSubsystem() {
		return subsystem;
	}

	public void setSubsystem(Subsystem subsystem) {
		this.subsystem = subsystem;
	}

}