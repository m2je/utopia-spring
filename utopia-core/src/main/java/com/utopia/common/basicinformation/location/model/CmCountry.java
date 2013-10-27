package com.utopia.common.basicinformation.location.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

/**
 * CmCountry entity.
 * 
 * @author Jahani
 */
@Entity
@Table(name = "CM_COUNTRY", uniqueConstraints = {})
@TableGenerator(name = "CountrySequenceGenerator", 
		table = "CO_SEQUENCE", pkColumnName = "TABLENAME", valueColumnName = "CURRENTID", pkColumnValue = "CM_COUNTRY")
public class CmCountry extends AbstractCmCountry implements
		java.io.Serializable {

	// Constructors

	/**
	 * 
	 */
	private static final long serialVersionUID = -2124257912204755814L;

	/** default constructor */
	public CmCountry() {
	}


}
