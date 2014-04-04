package com.utopia.common.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.utopia.core.model.AbstractUtopiaPersistent;

/**
 * AbstractCmProvince entity provides the base persistence definition of the
 * CmProvince entity.
 * 
 * @author Mehdi
 */
@Entity
@Table(name = "CM_PROVINCE",  uniqueConstraints = {})
public abstract class CmProvince extends AbstractUtopiaPersistent implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -5303357894586637161L;
	private String name;
	private String description;
	private CmState cmState;
	private String code;

	// Constructors

	/** default constructor */
	public CmProvince() {
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
	@JoinColumn(name = "CM_STATE_ID" )
	public CmState getCmState() {
		return this.cmState;
	}

	public void setCmState(CmState cmState) {
		this.cmState = cmState;
	}

	@Column(name = "CODE", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}