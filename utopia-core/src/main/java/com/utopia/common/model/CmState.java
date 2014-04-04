package com.utopia.common.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.utopia.core.model.AbstractUtopiaPersistent;

/**
 * 
 * @author Mehdi
 */
@Entity
@Table(name = "CM_STATE",  uniqueConstraints = {})
public  class CmState extends AbstractUtopiaPersistent implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 8138522366604737315L;
	private String name;
	private String description;
	private CmCountry cmCountry;
	private String code;

	// Constructors

	/** default constructor */
	public CmState() {
	}


	@Column(name = "NAME", unique = false, nullable = false, insertable = true, updatable = true, length = 66)
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

	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@JoinColumn(name = "CM_COUNTRY_ID" )
	public CmCountry getCmCountry() {
		return this.cmCountry;
	}

	public void setCmCountry(CmCountry cmCountry) {
		this.cmCountry = cmCountry;
	}

	@Column(name = "CODE", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}