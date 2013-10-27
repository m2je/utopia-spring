package com.utopia.common.basicinformation.currency.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

/**
 * CmCurrency entity.
 * 
 * @author  Jahani
 */
@Entity
@Table(name = "CM_CURRENCY", uniqueConstraints = {})
@TableGenerator(name = "CurrencySequenceGenerator", 
		table = "CO_SEQUENCE", pkColumnName = "TABLENAME", valueColumnName = "CURRENTID", pkColumnValue = "CM_CURRENCY")

	public class CmCurrency extends AbstractCmCurrency implements
		java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4273932275203405416L;

	// Constructors

	/** default constructor */
	public CmCurrency() {
	}

}
