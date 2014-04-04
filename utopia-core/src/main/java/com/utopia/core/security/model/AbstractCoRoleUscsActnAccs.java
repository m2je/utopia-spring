package com.utopia.core.security.model;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import com.utopia.core.model.AbstractUtopiaPersistent;

/**
 * AbstractCoRoleUscsActnAccs entity provides the base persistence definition of
 * the CoRoleUscsActnAccs entity.
 * 
 * @author Mehdi
 */
@MappedSuperclass
public abstract class AbstractCoRoleUscsActnAccs extends AbstractUtopiaPersistent implements
		java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -6808880490343303047L;
	private CoRole coRole;
	private CoUsecaseAction coUsecaseAction;

	// Constructors

	/** default constructor */
	public AbstractCoRoleUscsActnAccs() {
	}

	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@JoinColumn(name = "CO_ROLE_ID", unique = false, nullable = false, insertable = true, updatable = true)
	public CoRole getCoRole() {
		return this.coRole;
	}

	public void setCoRole(CoRole coRole) {
		this.coRole = coRole;
	}

	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@JoinColumn(name = "CO_USECASE_ACTION_ID", unique = false, nullable = false, insertable = true, updatable = true)
	public CoUsecaseAction getCoUsecaseAction() {
		return this.coUsecaseAction;
	}

	public void setCoUsecaseAction(CoUsecaseAction coUsecaseAction) {
		this.coUsecaseAction = coUsecaseAction;
	}

}