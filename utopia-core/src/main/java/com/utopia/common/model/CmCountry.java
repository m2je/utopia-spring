package com.utopia.common.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.utopia.core.model.AbstractUtopiaPersistent;

/**
 * AbstractCmCountry entity provides the base persistence definition of the
 * CmCountry entity.
 * 
 * @author Mehdi
 */
@Entity
@Table(name = "CM_COUNTRY", uniqueConstraints = {})
public class CmCountry extends AbstractUtopiaPersistent implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -4617277611963889225L;
	private String name;
	private String description;
	private CmCurrency cmCurrency;
	private String code;

	// Constructors

	/** default constructor */
	public CmCountry() {
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
	public CmCurrency getCmCurrency() {
		return this.cmCurrency;
	}

	public void setCmCurrency(CmCurrency cmCurrency) {
		this.cmCurrency = cmCurrency;
	}

	@Column(name = "CODE", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}