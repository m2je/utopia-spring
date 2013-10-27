package com.utopia.core.security.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	private Long coUserRolesId;
	private CoUser coUser;
	private CoRole coRole;
	

	// Constructors

	/** default constructor */
	public AbstractCoUserRoles() {
	}
	// Property accessors
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE,
			generator="UserRolesSequenceGenerator")
	@Column(name = "CO_USER_ROLES_ID", unique = true, nullable = false, insertable = true, updatable = true, precision = 10, scale = 0)
	public Long getCoUserRolesId() {
		return this.coUserRolesId;
	}

	public void setCoUserRolesId(Long coUserRolesId) {
		this.coUserRolesId = coUserRolesId;
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