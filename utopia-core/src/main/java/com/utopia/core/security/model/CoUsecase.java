package com.utopia.core.security.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Transient;

/**
 * CoUsecase entity.
 * 
 * @author Mehdi
 */
@Entity
@Table(name = "CO_USECASE",  uniqueConstraints = {})
@TableGenerator(name = "CoUsecaseSequenceGenerator", 
		table = "CO_SEQUENCE", pkColumnName = "TABLENAME", valueColumnName = "CURRENTID", pkColumnValue = "CO_USECASE")

public class CoUsecase extends AbstractCoUsecase implements
		java.io.Serializable {

	// Constructors

//	private long systemId;
//	private long subSystemId;
	/**
	 * 
	 */
	private static final long serialVersionUID = -3842717939392710215L;

	/** default constructor */
	public CoUsecase() {
	}

	/** minimal constructor */
	public CoUsecase(Long coUsecaseId, String uscsRemoteClass) {
		super(coUsecaseId, uscsRemoteClass);
	}
	
	@Transient
	public String getFullName(){
		return getCmSubsystem().getCmSystem().getAbbreviation()+getCmSubsystem().getAbbreviation()+getName();
	}
	
	
}
