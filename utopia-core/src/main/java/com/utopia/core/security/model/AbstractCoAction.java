package com.utopia.core.security.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;

import com.utopia.core.model.AbstractUtopiaPersistent;

/**
 * AbstractCoAction entity provides the base persistence definition of the
 * CoAction entity.
 * 
 * @author Mehdi
 */
@MappedSuperclass
public abstract class AbstractCoAction extends AbstractUtopiaPersistent implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 5780785409699454562L;

	
	private String name;
	private String methodName;
	private Set<CoUsecaseAction> coUsecaseActions = new HashSet<CoUsecaseAction>(
			0);
	
	// Constructors

	/** default constructor */
	public AbstractCoAction() {
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

	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "coAction")
	public Set<CoUsecaseAction> getCoUsecaseActions() {
		return this.coUsecaseActions;
	}

	public void setCoUsecaseActions(Set<CoUsecaseAction> coUsecaseActions) {
		this.coUsecaseActions = coUsecaseActions;
	}
	
}