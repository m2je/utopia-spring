package com.utopia.core.security.model;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;

import com.utopia.core.security.SecurityChangeListener;

/**
 * CoUserUsecaseAcss entity.
 * 
 * @author Mehdi
 */
@Entity
@Table(name = "CO_USER_USECASE_ACSS",  uniqueConstraints = {})
@EntityListeners(value=SecurityChangeListener.class)
		public class CoUserUsecaseAcss extends AbstractCoUserUsecaseAcss implements
		java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3221158708315829134L;

	// Constructors

	/** default constructor */
	public CoUserUsecaseAcss() {
	}


}
