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
@Table(name = "CO_ROLE_USECASE_ACSS",  uniqueConstraints = {})
@EntityListeners(value=SecurityChangeListener.class)
public  class RoleUsecaseAcss extends AbstractUtopiaPersistent implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -2794261476045135321L;
	private Role role;
	private Usecase usecase;

	// Constructors


	/** default constructor */
	public RoleUsecaseAcss() {
	}


	// Property accessors
	

	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@JoinColumn(name = "CO_ROLE_ID", unique = false, nullable = false, insertable = true, updatable = true)
	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@JoinColumn(name = "CO_USECASE_ID", unique = false, nullable = false, insertable = true, updatable = true)
	public Usecase getUsecase() {
		return usecase;
	}


	public void setUsecase(Usecase usecase) {
		this.usecase = usecase;
	}


}