package com.utopia.core.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 * @author Mehdi
 */
@Entity
@Table(name = "CO_ACTION",  uniqueConstraints = {})
public class Action extends AbstractUtopiaPersistent implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 5780785409699454562L;

	
	private String name;
	private String methodName;
	private Set<UsecaseAction> usecaseActions = new HashSet<UsecaseAction>(
			0);
	
	// Constructors

	/** default constructor */
	public Action() {
	}


	@Column(name = "NAME", unique = false, nullable = true, insertable = true, updatable = true, length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "METHODNAME", unique = false, nullable = true, insertable = true, updatable = true, length = 200)
	public String getMethodName() {
		return this.methodName;
	}

	public void setMethodName(String methodname) {
		this.methodName = methodname;
	}

	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "action")
	public Set<UsecaseAction> getUsecaseActions() {
		return this.usecaseActions;
	}

	public void setUsecaseActions(Set<UsecaseAction> usecaseActions) {
		this.usecaseActions = usecaseActions;
	}
	
}