package com.utopia.core.security.model;


import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;

import com.utopia.core.security.SecurityChangeListener;

/**
 * CoUsrUscsActnAccs entity.
 * 
 * @author Mehdi
 */
@Entity
@Table(name = "CO_USR_USCS_ACTN_ACCS",  uniqueConstraints = {})
@EntityListeners(value=SecurityChangeListener.class)
public class CoUsrUscsActnAccs extends AbstractCoUsrUscsActnAccs  implements
		java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1814092114217445116L;

	// Constructors

	/** default constructor */
	public CoUsrUscsActnAccs() {
	}


}
