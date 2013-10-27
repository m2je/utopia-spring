package com.utopia.core.security.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import com.utopia.common.systems.CmSubsystem;
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
	private Long coRoleSubsystemAcssId;
	private CoRole coRole;
	private CmSubsystem cmSubsystem;

	// Constructors


	/** default constructor */
	public AbstractCoRoleSubsystemAcss() {
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE,
			generator="RoleSubsystemAcssSequenceGenerator")
	@Column(name = "CO_ROLE_SUBSYSTEM_ACSS_ID", unique = true, nullable = false, insertable = true, updatable = true, precision = 10, scale = 0)
	public Long getCoRoleSubsystemAcssId() {
		return this.coRoleSubsystemAcssId;
	}

	public void setCoRoleSubsystemAcssId(Long coRoleSubsystemAcssId) {
		this.coRoleSubsystemAcssId = coRoleSubsystemAcssId;
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
	@JoinColumn(name = "CM_SUBSYSTEM_ID", referencedColumnName = "CM_SUBSYSTEM_ID")
	public CmSubsystem getCmSubsystem() {
		return cmSubsystem;
	}

	public void setCmSubsystem(CmSubsystem cmSubsystem) {
		this.cmSubsystem = cmSubsystem;
	}

}