package com.utopia.common.basicinformation.location.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

/**
 * CmProvince entity.
 * 
 * @author Jahani
 */
@Entity
@Table(name = "CM_PROVINCE",  uniqueConstraints = {})
@TableGenerator(name = "ProvinceSequenceGenerator", 
		table = "CO_SEQUENCE", pkColumnName = "TABLENAME", valueColumnName = "CURRENTID", pkColumnValue = "CM_PROVINCE")
public class CmProvince extends AbstractCmProvince implements
		java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7972864651688371453L;

	// Constructors

	/** default constructor */
	public CmProvince() {
	}


}
