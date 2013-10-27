package com.utopia.core.security.model;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.utopia.core.security.SecurityChangeListener;

/**
 * CoUserRoles entity.
 * 
 * @author Mehdi
 */
@Entity
@Table(name = "CO_USER_ROLES", uniqueConstraints = {})
@TableGenerator(name = "UserRolesSequenceGenerator", 
		table = "CO_SEQUENCE", pkColumnName = "TABLENAME", valueColumnName = "CURRENTID", pkColumnValue = "CO_USER_ROLES")
@EntityListeners(value=SecurityChangeListener.class)
public class CoUserRoles extends AbstractCoUserRoles implements
		java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1561128405945486018L;

	// Constructors

	/** default constructor */
	public CoUserRoles() {
	}

	

}
