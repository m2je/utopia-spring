package com.utopia.core.security.model;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import com.utopia.core.model.AbstractBasicPersistent;

/**
 * AbstractCoAppUscsAccss 
 */
@MappedSuperclass
public abstract class AbstractCoAppUscsAccss extends AbstractBasicPersistent implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 6904439745383997941L;
	private CoApplication coApplication;
	private CoUsecase coUsecase;
	private CoUsecaseAction coUsecaseAction;

	// Constructors

	/** default constructor */
	public AbstractCoAppUscsAccss() {
	}

	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@JoinColumn(name = "CO_APPLICATION_ID", unique = false, nullable = false, insertable = true, updatable = true)
	public CoApplication getCoApplication() {
		return this.coApplication;
	}

	public void setCoApplication(CoApplication coApplication) {
		this.coApplication = coApplication;
	}

	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@JoinColumn(name = "CO_USECASE_ID", unique = false, nullable = true, insertable = true, updatable = true)
	public CoUsecase getCoUsecase() {
		return this.coUsecase;
	}

	public void setCoUsecase(CoUsecase coUsecase) {
		this.coUsecase = coUsecase;
	}
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@JoinColumn(name = "CO_USECASE_ACTION_ID", unique = false, nullable = true, insertable = true, updatable = true)
	public CoUsecaseAction getCoUsecaseAction() {
		return this.coUsecaseAction;
	}

	public void setCoUsecaseAction(CoUsecaseAction coUsecaseAction) {
		this.coUsecaseAction = coUsecaseAction;
	}

}