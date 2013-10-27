package com.utopia.common.basicinformation.location.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

/**
 * CmState entity.
 * 
 * @author Jahani
 */
@Entity
@Table(name = "CM_STATE",  uniqueConstraints = {})
@TableGenerator(name = "StateSequenceGenerator", 
table = "CO_SEQUENCE", pkColumnName = "TABLENAME", valueColumnName = "CURRENTID", pkColumnValue = "CM_STATE")
public class CmState extends AbstractCmState implements java.io.Serializable {

	// Constructors

	/**
	 * 
	 */
	private static final long serialVersionUID = -4770560671624210890L;

	/** default constructor */
	public CmState() {
	}


}
