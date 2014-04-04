package com.utopia.core.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.utopia.core.model.annotations.LookupConfiguration;

/**
 * 
 * @author Mehdi
 */
@Entity
@Table(name = "CO_USECASE_ACTION", uniqueConstraints = {})
@LookupConfiguration(displayColumns={"coAction.name","coUsecase.name"},displayItemSeperator="-")
public  class CoUsecaseAction extends AbstractUtopiaPersistent implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -824075396835903445L;

	
	private CoUsecase coUsecase;
	private CoAction coAction;
	private Set<CoRoleUscsActnAccs> coRoleUscsActnAccses = new HashSet<CoRoleUscsActnAccs>(
			0);
	private Set<CoMenu> coMenus = new HashSet<CoMenu>(0);
	private Set<CoUsrUscsActnAccs> coUsrUscsActnAccses = new HashSet<CoUsrUscsActnAccs>(
			0);
	// Constructors

	/** default constructor */
	public CoUsecaseAction() {
	}
	
	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "coUsecaseAction")
	public Set<CoRoleUscsActnAccs> getCoRoleUscsActnAccses() {
		return this.coRoleUscsActnAccses;
	}

	public void setCoRoleUscsActnAccses(
			Set<CoRoleUscsActnAccs> coRoleUscsActnAccses) {
		this.coRoleUscsActnAccses = coRoleUscsActnAccses;
	}

	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "coUsecaseAction")
	public Set<CoMenu> getCoMenus() {
		return this.coMenus;
	}

	public void setCoMenus(Set<CoMenu> coMenus) {
		this.coMenus = coMenus;
	}

	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "coUsecaseAction")
	public Set<CoUsrUscsActnAccs> getCoUsrUscsActnAccses() {
		return this.coUsrUscsActnAccses;
	}

	public void setCoUsrUscsActnAccses(
			Set<CoUsrUscsActnAccs> coUsrUscsActnAccses) {
		this.coUsrUscsActnAccses = coUsrUscsActnAccses;
	}
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@JoinColumn(name = "CO_USECASE_ID", unique = false, nullable = false, insertable = true, updatable = true)
	public CoUsecase getCoUsecase() {
		return coUsecase;
	}

	public void setCoUsecase(CoUsecase coUsecase) {
		this.coUsecase = coUsecase;
	}
	@ManyToOne(cascade = {}, fetch = FetchType.EAGER)
	@JoinColumn(name = "CO_ACTION_ID", unique = false, nullable = false, insertable = true, updatable = true)
	public CoAction getCoAction() {
		return coAction;
	}
	
	public void setCoAction(CoAction coAction) {
		this.coAction = coAction;
	}
	
}