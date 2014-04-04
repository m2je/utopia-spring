package com.utopia.core.security.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.utopia.core.model.annotations.LookupConfiguration;

/**
 * CoUsecaseAction entity.
 * 
 * @author Mehdi
 */
@Entity
@Table(name = "CO_USECASE_ACTION", uniqueConstraints = {})
@LookupConfiguration(displayColumns={"coAction.name","coUsecase.name"},displayItemSeperator="-")
public class CoUsecaseAction extends AbstractCoUsecaseAction implements
		java.io.Serializable {

	// Constructors

	/**
	 * 
	 */
	
	private static final long serialVersionUID = -5102730350354060208L;

	/** default constructor */
	public CoUsecaseAction() {
	}


}
