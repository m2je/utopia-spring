package com.utopia.common.basicinformation.currency.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.utopia.core.model.AbstractUtopiaPersistent;

/**
 * AbstractCmCurrency entity provides the base persistence definition of the
 * CmCurrency entity.
 * 
 * @author Jahani
 */
@MappedSuperclass
public abstract class AbstractCmCurrency extends AbstractUtopiaPersistent implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -3763874085054197734L;
	private Long cmCurrencyId;
	private String description;
	private String code;
	private String symbol;
	private String name;
	

	// Constructors

	/** default constructor */
	public AbstractCmCurrency() {
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE,
			generator="CurrencySequenceGenerator")
	@Column(name = "CM_CURRENCY_ID", unique = true, nullable = false, insertable = true, updatable = true, precision = 10, scale = 0)
	public Long getCmCurrencyId() {
		return this.cmCurrencyId;
	}

	public void setCmCurrencyId(Long cmCurrencyId) {
		this.cmCurrencyId = cmCurrencyId;
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