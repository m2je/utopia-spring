package com.utopia.common.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.utopia.core.model.AbstractUtopiaPersistent;
import com.utopia.core.model.annotations.LookupConfiguration;


@Entity
@Table(name = "CM_ORGANIZATION",  uniqueConstraints = { /*@UniqueConstraint(columnNames = { "NAME","PARENT_ID" })*/ })
@LookupConfiguration(displayColumns={"code","name"},displayItemSeperator=" - ",descriptionColumnName="description")
public abstract class CmOrganization extends AbstractUtopiaPersistent implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = -1071001404864903512L;
	private String code;
	private String name;
	private CmOrganization parent;
	private String description;
	private Set<CmOrganization> children = new HashSet<CmOrganization>(0);

	// Constructors



	/** default constructor */
	public CmOrganization() {
	}
	
	@Column(name = "CODE", unique = true, nullable = false, insertable = true, updatable = true, length = 20)
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	
	
	
	@Column(name = "NAME", unique = false, nullable = false, insertable = true, updatable = true, length = 200)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
	@ManyToOne(cascade = {})
	@JoinColumn(name = "PARENT_ID", unique = false, nullable = true, insertable = true, updatable = true)
	public CmOrganization getParent() {
		return parent;
	}

	public void setParent(CmOrganization parent) {
		this.parent = parent;
	}
	
	
	

	@Column(name = "DESCRIPTION", unique = false, nullable = false, insertable = true, updatable = true)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	@OneToMany( fetch = FetchType.LAZY, mappedBy = "parent")
	public Set<CmOrganization> getChildren() {
		return children;
	}



	public void setChildren(Set<CmOrganization> children) {
		this.children = children;
	}



}