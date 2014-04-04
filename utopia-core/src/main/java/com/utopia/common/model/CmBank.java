package com.utopia.common.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.utopia.core.model.AbstractUtopiaPersistent;

@Entity
@Table(name = "CM_BANK", uniqueConstraints = {})
public  class CmBank extends AbstractUtopiaPersistent implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1172802845451010227L;
	
	private String code;
	private String name;
	private String latinname;
	private String descriptions;

	
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