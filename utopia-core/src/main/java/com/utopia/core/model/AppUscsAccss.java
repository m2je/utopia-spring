package com.utopia.core.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * AbstractAppUscsAccss 
 */
@Entity
@Table(name = "CO_APP_USCS_ACCSS", uniqueConstraints = { @UniqueConstraint(columnNames = {
		"CO_USECASE_ID", "CO_APPLICATION_ID" }) })
public  class AppUscsAccss extends AbstractBasicPersistent implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 6904439745383997941L;
	private Application application;
	private Usecase usecase;
	private UsecaseAction usecaseAction;

	// Constructors

	/** default constructor */
	public AppUscsAccss() {
	}

	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@JoinColumn(name = "CO_APPLICATION_ID", unique = false, nullable = false, insertable = true, updatable = true)
	public Application getApplication() {
		return this.application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}

	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@JoinColumn(name = "CO_USECASE_ID", unique = false, nullable = true, insertable = true, updatable = true)
	public Usecase getUsecase() {
		return this.usecase;
	}

	public void setUsecase(Usecase usecase) {
		this.usecase = usecase;
	}
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@JoinColumn(name = "CO_USECASE_ACTION_ID", unique = false, nullable = true, insertable = true, updatable = true)
	public UsecaseAction getUsecaseAction() {
		return this.usecaseAction;
	}

	public void setUsecaseAction(UsecaseAction usecaseAction) {
		this.usecaseAction = usecaseAction;
	}

}