package com.utopia.core.model;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.utopia.core.security.SecurityChangeListener;

/**
 * 
 * @author Mehdi
 */
@Entity
@Table(name = "CO_ROLE_USCS_ACTN_ACCS",  uniqueConstraints = {})
@EntityListeners(value=SecurityChangeListener.class)
public class RoleUscsActnAccs extends AbstractUtopiaPersistent implements
		java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -6808880490343303047L;
	private Role role;
	private UsecaseAction usecaseAction;

	// Constructors

	/** default constructor */
	public RoleUscsActnAccs() {
	}

	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@JoinColumn(name = "CO_ROLE_ID", unique = false, nullable = false, insertable = true, updatable = true)
	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@JoinColumn(name = "CO_USECASE_ACTION_ID", unique = false, nullable = false, insertable = true, updatable = true)
	public UsecaseAction getUsecaseAction() {
		return this.usecaseAction;
	}

	public void setUsecaseAction(UsecaseAction usecaseAction) {
		this.usecaseAction = usecaseAction;
	}

}