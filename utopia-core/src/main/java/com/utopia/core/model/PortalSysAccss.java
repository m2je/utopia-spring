package com.utopia.core.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.utopia.common.model.Subsystem;
import com.utopia.common.model.System;

/**
 * AbstractPortalSysAccss 
 */
@Entity
@Table(name = "CO_PORTAL_SYS_ACCSS", uniqueConstraints = { @UniqueConstraint(columnNames = {
		"CO_PORTAL_ID", "CM_SYSTEM_ID", "CM_SUBSYSTEM_ID" }) })
public  class PortalSysAccss extends AbstractBasicPersistent implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1291387372298877062L;
	private System system;
	private Subsystem subsystem;
	private Portal portal;

	// Constructors

	/** default constructor */
	public PortalSysAccss() {
	}
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "CM_SYSTEM_ID", unique = false, nullable = false, insertable = true, updatable = true)
	public System getSystem() {
		return this.system;
	}

	public void setSystem(System system) {
		this.system = system;
	}
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "CM_SUBSYSTEM_ID", unique = false, nullable = true, insertable = true, updatable = true)
	public Subsystem getSubsystem() {
		return this.subsystem;
	}

	public void setSubsystem(Subsystem subsystem) {
		this.subsystem = subsystem;
	}
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "CO_PORTAL_ID", unique = false, nullable = false, insertable = true, updatable = true)
	public Portal getPortal() {
		return this.portal;
	}

	public void setPortal(Portal portal) {
		this.portal = portal;
	}

}