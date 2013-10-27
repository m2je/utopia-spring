package com.utopia.common.basicinformation.bpartner.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

/**
 * CmBpartner entity.
 * 
 * @author Mehdi
 */
@Entity
@Table(name = "CM_BPARTNER")
@TableGenerator(name = "CmBpartnerSequenceGenerator", 
		table = "CO_SEQUENCE", pkColumnName = "TABLENAME", valueColumnName = "CURRENTID", pkColumnValue = "CM_BPARTNER")
public class CmBpartner extends AbstractCmBpartner  {

	// Constructors

	/**
	 * 
	 */
	private static final long serialVersionUID = -5396081736918825168L;

	/** default constructor */
	public CmBpartner() {
	}
		

}
