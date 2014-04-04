package com.utopia.core.model;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

import com.utopia.core.security.SecurityChangeListener;

/**
 * 
 * @author Mehdi
 */
@Entity
@Table(name = "CO_USER_USECASE_ACSS",  uniqueConstraints = {})
@EntityListeners(value=SecurityChangeListener.class)
public class UserUsecaseAcss extends AbstractUtopiaPersistent implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 3344607570387708840L;
	private User user;
	private Usecase usecase;

	// Constructors


	/** default constructor */
	public UserUsecaseAcss() {
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
	@JoinColumn(name = "CO_USECASE_ID", unique = false, nullable = false, insertable = true, updatable = true)
	public Usecase getUsecase() {
		return usecase;
	}

	public void setUsecase(Usecase usecase) {
		this.usecase = usecase;
	}

}