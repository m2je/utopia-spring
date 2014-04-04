package com.utopia.common.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

import com.utopia.core.model.AbstractUtopiaPersistent;

/**
 * AbstractCmCurrency entity provides the base persistence definition of the
 * CmCurrency entity.
 * 
 * @author Mehdi
 */
@MappedSuperclass
@Entity
@Table(name = "CM_CURRENCY", uniqueConstraints = {})
public  class CmCurrency extends AbstractUtopiaPersistent implements java.io.Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -3763874085054197734L;
	private String description;
	private String code;
	private String symbol;
	private String name;
	

	// Constructors

	/** default constructor */
	public CmCurrency() {
	}



	@Column(name = "DESCRIPTION", unique = false, nullable = false, insertable = true, updatable = true)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "CODE", unique = false, nullable = false, insertable = true, updatable = true, length = 3)
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "SYMBOL", unique = false, nullable = true, insertable = true, updatable = true, length = 50)
	public String getSymbol() {
		return this.symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	@Column(name = "NAME", unique = false, nullable = true, insertable = true, updatable = true, length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}