package com.utopia.core.security.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;

import com.utopia.core.basicinformation.menu.model.CoMenu;
import com.utopia.core.model.AbstractUtopiaPersistent;

/**
 * AbstractCoUsecaseAction entity provides the base persistence definition of
 * the CoUsecaseAction entity.
 * 
 * @author Mehdi
 */
@MappedSuperclass
public abstract class AbstractCoUsecaseAction extends AbstractUtopiaPersistent implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -824075396835903445L;

	private Long coUsecaseActionId;
	
	private CoUsecase coUsecase;
	private CoAction coAction;
	private Set<CoRoleUscsActnAccs> coRoleUscsActnAccses = new HashSet<CoRoleUscsActnAccs>(
			0);
	private Set<CoMenu> coMenus = new HashSet<CoMenu>(0);
	private Set<CoUsrUscsActnAccs> coUsrUscsActnAccses = new HashSet<CoUsrUscsActnAccs>(
			0);
	// Constructors

	/** default constructor */
	public AbstractCoUsecaseAction() {
	}


	// Property accessors
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE,
			generator="UsecaseActionSequenceGenerator")
	@Column(name = "CO_USECASE_ACTION_ID", unique = true, nullable = false, insertable = true, updatable = true, precision = 10, scale = 0)
	public Long getCoUsecaseActionId() {
		return this.coUsecaseActionId;
	}

	public void setCoUsecaseActionId(Long coUsecaseActionId) {
		this.coUsecaseActionId = coUsecaseActionId;
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