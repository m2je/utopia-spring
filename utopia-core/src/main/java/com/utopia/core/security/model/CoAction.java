package com.utopia.core.security.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

/**
 * CoAction entity.
 * 
 * @author Mehdi
 */
@Entity
@Table(name = "CO_ACTION",  uniqueConstraints = {})
@TableGenerator(name = "ActionSequenceGenerator", 
		table = "CO_SEQUENCE", pkColumnName = "TABLENAME", valueColumnName = "CURRENTID", pkColumnValue = "CO_ACTION")
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
