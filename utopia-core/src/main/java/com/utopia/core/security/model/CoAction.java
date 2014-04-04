package com.utopia.core.security.model;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * CoAction entity.
 * 
 * @author Mehdi
 */
@Entity
@Table(name = "CO_ACTION",  uniqueConstraints = {})
public class CoAction extends AbstractCoAction implements java.io.Serializable {

	// Constructors

	/**
	 * 
	 */
	private static final long serialVersionUID = 1930913825584052032L;

	/** default constructor */
	public CoAction() {
	}

}
