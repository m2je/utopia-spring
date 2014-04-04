package com.utopia.core.security.model;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import com.utopia.core.model.AbstractUtopiaPersistent;

/**
 * AbstractCoUserRoles entity provides the base persistence definition of the
 * CoUserRoles entity.
 * 
 * @author Mehdi
 */
@MappedSuperclass
public abstract class AbstractCoUserRoles extends AbstractUtopiaPersistent implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -1368987968624383829L;
	private CoUser coUser;
	private CoRole coRole;
	

	// Constructors

	/** default constructor */
	public AbstractCoUserRoles() {
	}
	@ManyToOne
	@JoinColumn(name = "CO_USER_ID", unique = false, nullable = false, insertable = true, updatable = true)
	
	public CoUser getCoUser() {
		return this.coUser;
	}

	public void setCoUser(CoUser coUser) {
		this.coUser = coUser;
	}

	@ManyToOne(cascade = {})
	@JoinColumn(name = "CO_ROLE_ID", unique = false, nullable = false, insertable = true, updatable = true)
	public CoRole getCoRole() {
		return this.coRole;
	}

	public void setCoRole(CoRole coRole) {
		this.coRole = coRole;
	}

	

}