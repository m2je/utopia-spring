package com.utopia.core.security.model;



import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * CoApplication
 * @author Mehdi 
 */
@Entity
@Table(name = "CO_APPLICATION",  uniqueConstraints = { @UniqueConstraint(columnNames = { "NAME" }) })
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
