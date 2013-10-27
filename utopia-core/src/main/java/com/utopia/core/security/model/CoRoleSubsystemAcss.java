package com.utopia.core.security.model;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.utopia.core.security.SecurityChangeListener;

/**
 * CoRoleSubsystemAcss entity.
 * 
 * @author Mehdi
 */
@Entity
@Table(name = "CO_ROLE_SUBSYSTEM_ACSS",  uniqueConstraints = {})
@TableGenerator(name = "RoleSubsystemAcssSequenceGenerator", 
		table = "CO_SEQUENCE", pkColumnName = "TABLENAME", valueColumnName = "CURRENTID", pkColumnValue = "CO_ROLE_SUBSYSTEM_ACSS")
@EntityListeners(value=SecurityChangeListener.class)		
public class CoRoleSubsystemAcss extends AbstractCoRoleSubsystemAcss implements
		java.io.Serializable {

	// Constructors

	/**
	 * 
	 */
	private static final long serialVersionUID = -3819531876442156967L;

	/** default constructor */
	public CoRoleSubsystemAcss() {
	}

	

}
