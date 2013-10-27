package com.utopia.common.basicinformation.location.model;



import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import com.utopia.common.basicinformation.currency.model.CmCurrency;
import com.utopia.core.model.AbstractUtopiaPersistent;

/**
 * AbstractCmCountry entity provides the base persistence definition of the
 * CmCountry entity.
 * 
 * @author Jahani
 */
@MappedSuperclass
public abstract class AbstractCmCountry extends AbstractUtopiaPersistent implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -4617277611963889225L;
	private Long cmCountryId;
	private String name;
	private String description;
	private CmCurrency cmCurrency;
	private String code;

	// Constructors

	/** default constructor */
	public AbstractCmCountry() {
	}


	// Property accessors
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE,
			generator="CountrySequenceGenerator")
	@Column(name = "CM_COUNTRY_ID", unique = true, nullable = false, insertable = true, updatable = true, precision = 10, scale = 0)
	public Long getCmCountryId() {
		return this.cmCountryId;
	}

	public void setCmCountryId(Long cmCountryId) {
		this.cmCountryId = cmCountryId;
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
	@JoinColumn(name = "CM_CURRENCY_ID", referencedColumnName = "CM_CURRENCY_ID" )
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