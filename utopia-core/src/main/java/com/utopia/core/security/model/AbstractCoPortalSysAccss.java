package com.utopia.core.security.model;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import com.utopia.common.systems.CmSubsystem;
import com.utopia.common.systems.CmSystem;
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
	private Long coPortalSysAccssId;
	private CmSystem cmSystem;
	private CmSubsystem cmSubsystem;
	private CoPortal coPortal;

	// Constructors

	/** default constructor */
	public AbstractCoPortalSysAccss() {
	}
	
	@GeneratedValue(strategy=GenerationType.TABLE,
	generator="PortalAccssSequenceGenerator")
	@Id
	@Column(name = "CO_PORTAL_SYS_ACCSS_ID", unique = true, nullable = false, insertable = true, updatable = true, precision = 10, scale = 0)
	public Long getCoPortalSysAccssId() {
		return this.coPortalSysAccssId;
	}

	public void setCoPortalSysAccssId(Long coPortalSysAccssId) {
		this.coPortalSysAccssId = coPortalSysAccssId;
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