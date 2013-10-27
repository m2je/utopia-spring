package com.utopia.core.security.model;

// Generated by Mehdi

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.UniqueConstraint;

/**
 * CoApplication 
 */
@Entity
@Table(name = "CO_APPLICATION",  uniqueConstraints = { @UniqueConstraint(columnNames = { "NAME" }) })
@TableGenerator(name = "ApplicationSequenceGenerator", 
table = "CO_SEQUENCE", pkColumnName = "TABLENAME", valueColumnName = "CURRENTID", pkColumnValue = "CO_APPLICATION")
public class CoApplication extends AbstractCoApplication implements
		java.io.Serializable {

	// Constructors

	/**
	 * 
	 */
	private static final long serialVersionUID = 4211701471226578151L;

	/** default constructor */
	public CoApplication() {
	}


}
