package com.utopia.common.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.utopia.core.model.AbstractUtopiaSoftDelete;

/**
 * AbstractSystemParameter 
 */
@Entity
@Table(name = "CM_SYSTEM_PARAMETER",  uniqueConstraints = { @UniqueConstraint(columnNames = {
		"CM_SYSTEM_ID", "KEY" }) })
public class SystemParameter extends AbstractUtopiaSoftDelete implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -1520481424416401703L;
	private System system;
	private String key;
	private String value;
	private SystemParameterType type;

	// Constructors

	/** default constructor */
	public SystemParameter() {
	}

	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@JoinColumn(name = "CM_SYSTEM_ID", unique = false, nullable = false, insertable = true, updatable = true)
	public System getSystem() {
		return this.system;
	}

	public void setSystem(System system) {
		this.system = system;
	}

	@Column(name = "KEY", unique = false, nullable = false, insertable = true, updatable = true, length = 200)
	public String getKey() {
		return this.key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	@Column(name = "VALUE", unique = false, nullable = false, insertable = true, updatable = true, length = 2000)
	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "TYPE", unique = false, nullable = false, insertable = true, updatable = true, precision = 2, scale = 0)
	public SystemParameterType getType() {
		return this.type;
	}

	public void setType(SystemParameterType type) {
		this.type = type;
	}

}