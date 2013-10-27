package com.utopia.common.basicinformation.bank.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.utopia.core.model.AbstractUtopiaPersistent;

@MappedSuperclass
public abstract class AbstractCmBank extends AbstractUtopiaPersistent implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1172802845451010227L;
	
	private Long cmBankId;
	private String code;
	private String name;
	private String latinname;
	private String descriptions;

	@Id
	@Column(name = "CM_BANK_ID", unique = true, nullable = false, insertable = true, updatable = true, precision = 10, scale = 0)
	public Long getCmBankId() {
		return this.cmBankId;
	}

	public void setCmBankId(Long cmBankId) {
		this.cmBankId = cmBankId;
	}

	@Column(name = "CODE", unique = false, nullable = true, insertable = true, updatable = true)
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "NAME", unique = false, nullable = true, insertable = true, updatable = true)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "LATINNAME", unique = false, nullable = true, insertable = true, updatable = true)
	public String getLatinname() {
		return this.latinname;
	}

	public void setLatinname(String latinname) {
		this.latinname = latinname;
	}

	@Column(name = "DESCRIPTIONS", unique = false, nullable = true, insertable = true, updatable = true)
	public String getDescriptions() {
		return this.descriptions;
	}

	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}

}