package com.utopia.common.basicinformation.bpartner.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

/**
 * CmCompanyBpartner entity.
 * 
 * @author Arsalani
 */
@Entity
@Table(name = "CM_COMPANY_BPARTNER",  uniqueConstraints = {})
@TableGenerator(name = "CmCompanyBpartnerSequenceGenerator", 
		table = "CO_SEQUENCE", pkColumnName = "TABLENAME", valueColumnName = "CURRENTID", pkColumnValue = "CM_COMPANY_BPARTNER")
public class CmCompanyBpartner extends AbstractCmCompanyBpartner implements
		java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4013514786825671397L;

	// Constructors

	/** default constructor */
	public CmCompanyBpartner() {
	}

	

}
