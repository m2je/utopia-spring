package com.utopia.core.security.model;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

/**
 * AbstractCoAppUscsAccss 
 */
@MappedSuperclass
public abstract class AbstractCoAppUscsAccss implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 6904439745383997941L;
	private Long coAppUscsAccssId;
	private CoApplication coApplication;
	private CoUsecase coUsecase;
	private CoUsecaseAction coUsecaseAction;

	// Constructors

	/** default constructor */
	public AbstractCoAppUscsAccss() {
	}

	/** minimal constructor */
	public AbstractCoAppUscsAccss(Long coAppUscsAccssId,
			CoApplication coApplication) {
		this.coAppUscsAccssId = coAppUscsAccssId;
		this.coApplication = coApplication;
	}

	

	// Property accessors
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE,
	generator="CoAppUscsAccssSequenceGenerator")
	@Column(name = "CO_APP_USCS_ACCSS_ID", unique = true, nullable = false, insertable = true, updatable = true, precision = 10, scale = 0)
	public Long getCoAppUscsAccssId() {
		return this.coAppUscsAccssId;
	}

	public void setCoAppUscsAccssId(Long coAppUscsAccssId) {
		this.coAppUscsAccssId = coAppUscsAccssId;
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