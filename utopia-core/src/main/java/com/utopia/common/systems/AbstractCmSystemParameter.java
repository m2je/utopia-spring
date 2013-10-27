package com.utopia.common.systems;



import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import com.utopia.core.model.AbstractUtopiaPersistent;

/**
 * AbstractCmSystemParameter 
 */
@MappedSuperclass
public abstract class AbstractCmSystemParameter extends AbstractUtopiaPersistent implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -1520481424416401703L;
	private Long cmSystemParameterId;
	private CmSystem cmSystem;
	private String key;
	private String value;
	private SystemParameterType type;

	// Constructors

	/** default constructor */
	public AbstractCmSystemParameter() {
	}

	
	@Id
	@Column(name = "CM_SYSTEM_PARAMETER_ID", unique = true, nullable = false, insertable = true, updatable = true, precision = 10, scale = 0)
	public Long getCmSystemParameterId() {
		return this.cmSystemParameterId;
	}

	public void setCmSystemParameterId(Long cmSystemParameterId) {
		this.cmSystemParameterId = cmSystemParameterId;
	}

	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@JoinColumn(name = "CM_SYSTEM_ID", unique = false, nullable = false, insertable = true, updatable = true)
	public CmSystem getCmSystem() {
		return this.cmSystem;
	}

	public void setCmSystem(CmSystem cmSystem) {
		this.cmSystem = cmSystem;
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