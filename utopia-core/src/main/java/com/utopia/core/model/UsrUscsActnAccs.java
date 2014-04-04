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
@Table(name = "CO_USR_USCS_ACTN_ACCS",  uniqueConstraints = {})
@EntityListeners(value=SecurityChangeListener.class)
public  class UsrUscsActnAccs extends AbstractUtopiaPersistent implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 2672455068015163789L;
	private User user;
	private UsecaseAction usecaseAction;
	

	// Constructors

	/** default constructor */
	public UsrUscsActnAccs() {
	}
	

	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@JoinColumn(name = "CO_USER_ID", unique = false, nullable = false, insertable = true, updatable = true)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
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