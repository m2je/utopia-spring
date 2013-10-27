package com.utopia.common.basicinformation.bpartner.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

/**
 * CmPersonBpartner entity.
 * 
 * @author Mehdi
 */
@Entity
@Table(name = "CM_PERSON_BPARTNER",  uniqueConstraints = {})
@TableGenerator(name = "CmPersonBpartnerSequenceGenerator", 
		table = "CO_SEQUENCE", pkColumnName = "TABLENAME", valueColumnName = "CURRENTID", pkColumnValue = "CM_PERSON_BPARTNER")
public class CmPersonBpartner extends AbstractCmPersonBpartner implements
		java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -422990723047719747L;

	// Constructors

	/** default constructor */
	public CmPersonBpartner() {
	}

}
