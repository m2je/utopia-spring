package com.utopia.common.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.utopia.core.model.AbstractUtopiaSoftDelete;

/**
 * 
 * @author Mehdi
 */
@Entity
@Table(name = "CM_COUNTRY", uniqueConstraints = {})
public class Country extends AbstractUtopiaSoftDelete implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -4617277611963889225L;
	private String name;
	private String description;
	private Currency currency;
	private String code;

	// Constructors

	/** default constructor */
	public Country() {
	}



	@Column(name = "NAME", unique = false, nullable = false, insertable = true, updatable = true, length = 60)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "DESCRIPTION", unique = false, nullable = true, insertable = true, updatable = true)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@ManyToOne	
	@JoinColumn(name = "CM_CURRENCY_ID" )
	public Currency getCurrency() {
		return this.currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	@Column(name = "CODE", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}