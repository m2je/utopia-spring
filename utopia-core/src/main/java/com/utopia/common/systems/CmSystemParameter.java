package com.utopia.common.systems;


import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * CmSystemParameter
 */
@Entity
@Table(name = "CM_SYSTEM_PARAMETER",  uniqueConstraints = { @UniqueConstraint(columnNames = {
		"CM_SYSTEM_ID", "KEY" }) })
public class CmSystemParameter extends AbstractCmSystemParameter implements
		java.io.Serializable {

	// Constructors

	/**
	 * 
	 */
	private static final long serialVersionUID = 3017176520874079925L;

	/** default constructor */
	public CmSystemParameter() {
	}

	

}
