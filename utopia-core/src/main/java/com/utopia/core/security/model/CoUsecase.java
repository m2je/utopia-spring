package com.utopia.core.security.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * CoUsecase entity.
 * 
 * @author Mehdi
 */
@Entity
@Table(name = "CO_USECASE",  uniqueConstraints = {})

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

	
	
	@Transient
	public String getFullName(){
		return getCmSubsystem().getCmSystem().getAbbreviation()+getCmSubsystem().getAbbreviation()+getName();
	}
	
	
}
