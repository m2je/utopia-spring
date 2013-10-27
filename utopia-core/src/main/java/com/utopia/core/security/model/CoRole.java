package com.utopia.core.security.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.UniqueConstraint;

/**
 * CoRole entity.
 * 
 * @author Mehdi
 */
@Entity
@Table(name = "CO_ROLE",  uniqueConstraints = { @UniqueConstraint(columnNames = { "NAME" }) })
@TableGenerator(name = "RoleSequenceGenerator", 
		table = "CO_SEQUENCE", pkColumnName = "TABLENAME", valueColumnName = "CURRENTID", pkColumnValue = "CO_ROLE")
public class CoRole extends AbstractCoRole implements java.io.Serializable {

	// Constructors

	/**
	 * 
	 */
	private static final long serialVersionUID = 8056447988318177539L;

	/** default constructor */
	public CoRole() {
	}

	

}
