package com.utopia.core.security.model;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import com.utopia.core.model.AbstractUtopiaPersistent;

/**
 * AbstractCoUserUsecaseAcss entity provides the base persistence definition of
 * the CoUserUsecaseAcss entity.
 * 
 * @author Mehdi
 */
@MappedSuperclass
public abstract class AbstractCoUserUsecaseAcss extends AbstractUtopiaPersistent implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 3344607570387708840L;
	private CoUser coUser;
	private CoUsecase coUsecase;

	// Constructors


	/** default constructor */
	public AbstractCoUserUsecaseAcss() {
	}

	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@JoinColumn(name = "CO_USER_ID", unique = false, nullable = false, insertable = true, updatable = true)
	public CoUser getCoUser() {
		return this.coUser;
	}

	public void setCoUser(CoUser coUser) {
		this.coUser = coUser;
	}

	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@JoinColumn(name = "CO_USECASE_ID", unique = false, nullable = false, insertable = true, updatable = true)
	public CoUsecase getCoUsecase() {
		return coUsecase;
	}

	public void setCoUsecase(CoUsecase coUsecase) {
		this.coUsecase = coUsecase;
	}

}