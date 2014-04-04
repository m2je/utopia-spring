package com.utopia.core.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.utopia.common.model.CmSubsystem;

/**
 * 
 * @author Mehdi
 */
@Entity
@Table(name = "CO_USECASE",  uniqueConstraints = {})
public  class CoUsecase extends AbstractUtopiaPersistent implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -3178644408009107112L;
	private String name;
	private String uscsRemoteClass;
	private CmSubsystem cmSubsystem;
	private Set<CoUsecaseAction> coUsecaseActions = new HashSet<CoUsecaseAction>(
			0);
	
	// Constructors

	/** default constructor */
	public CoUsecase() {
	}

	@Column(name = "NAME", unique = false, nullable = true, insertable = true, updatable = true, length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "USCS_REMOTE_CLASS", unique = false, nullable = false, insertable = true, updatable = true, length = 2000)
	public String getUscsRemoteClass() {
		return this.uscsRemoteClass;
	}

	public void setUscsRemoteClass(String uscsRemoteClass) {
		this.uscsRemoteClass = uscsRemoteClass;
	}
	@ManyToOne	
	@JoinColumn(name = "CM_SUBSYSTEM_ID" )
	public CmSubsystem getCmSubsystem() {
		return cmSubsystem;
	}
	public void setCmSubsystem(CmSubsystem cmSubsystem) {
		this.cmSubsystem = cmSubsystem;
	}
	
	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "coUsecase")
	public Set<CoUsecaseAction> getCoUsecaseActions() {
		return this.coUsecaseActions;
	}

	public void setCoUsecaseActions(Set<CoUsecaseAction> coUsecaseActions) {
		this.coUsecaseActions = coUsecaseActions;
	}

	@Transient
	public String getFullName(){
		return getCmSubsystem().getCmSystem().getAbbreviation()+getCmSubsystem().getAbbreviation()+getName();
	}

	
	 
	
	

}