package com.utopia.common.basicinformation.location.model;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import com.utopia.core.model.AbstractUtopiaPersistent;

/**
 * AbstractCmState entity provides the base persistence definition of the
 * CmState entity.
 * 
 * @author Jahani
 */
@MappedSuperclass
public abstract class AbstractCmState extends AbstractUtopiaPersistent implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 8138522366604737315L;
	private Long cmStateId;
	private String name;
	private String description;
	private CmCountry cmCountry;
	private String code;

	// Constructors

	/** default constructor */
	public AbstractCmState() {
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE,
			generator="StateSequenceGenerator")
	@Column(name = "CM_STATE_ID", unique = true, nullable = false, insertable = true, updatable = true, precision = 10, scale = 0)
	public Long getCmStateId() {
		return this.cmStateId;
	}

	public void setCmStateId(Long cmStateId) {
		this.cmStateId = cmStateId;
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
	@JoinColumn(name = "CM_COUNTRY_ID", referencedColumnName = "CM_COUNTRY_ID" )
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