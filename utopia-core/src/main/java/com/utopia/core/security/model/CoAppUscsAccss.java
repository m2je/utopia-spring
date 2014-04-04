package com.utopia.core.security.model;


import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * CoAppUscsAccss 
 * @author Mehdi
 */
@Entity
@Table(name = "CO_APP_USCS_ACCSS", uniqueConstraints = { @UniqueConstraint(columnNames = {
		"CO_USECASE_ID", "CO_APPLICATION_ID" }) })
public class CoAppUscsAccss extends AbstractCoAppUscsAccss implements
		java.io.Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 5748893547877854487L;

	/** default constructor */
	public CoAppUscsAccss() {
	}

	


}
