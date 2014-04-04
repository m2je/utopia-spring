package com.utopia.core.security.model;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import com.utopia.common.model.CmSubsystem;
import com.utopia.common.model.CmSystem;
import com.utopia.core.model.AbstractBasicPersistent;

/**
 * AbstractCoPortalSysAccss 
 */
@MappedSuperclass
public abstract class AbstractCoPortalSysAccss extends AbstractBasicPersistent implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1291387372298877062L;
	private CmSystem cmSystem;
	private CmSubsystem cmSubsystem;
	private CoPortal coPortal;

	// Constructors

	/** default constructor */
	public AbstractCoPortalSysAccss() {
	}
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "CM_SYSTEM_ID", unique = false, nullable = false, insertable = true, updatable = true)
	public CmSystem getCmSystem() {
		return this.cmSystem;
	}

	public void setCmSystem(CmSystem cmSystem) {
		this.cmSystem = cmSystem;
	}
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "CM_SUBSYSTEM_ID", unique = false, nullable = true, insertable = true, updatable = true)
	public CmSubsystem getCmSubsystem() {
		return this.cmSubsystem;
	}

	public void setCmSubsystem(CmSubsystem cmSubsystem) {
		this.cmSubsystem = cmSubsystem;
	}
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "CO_PORTAL_ID", unique = false, nullable = false, insertable = true, updatable = true)
	public CoPortal getCoPortal() {
		return this.coPortal;
	}

	public void setCoPortal(CoPortal coPortal) {
		this.coPortal = coPortal;
	}

}