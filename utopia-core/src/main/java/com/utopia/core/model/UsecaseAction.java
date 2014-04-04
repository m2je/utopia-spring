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
@LookupConfiguration(displayColumns={"action.name","usecase.name"},displayItemSeperator="-")
public  class UsecaseAction extends AbstractUtopiaPersistent implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -824075396835903445L;

	
	private Usecase usecase;
	private Action action;
	private Set<RoleUscsActnAccs> roleUscsActnAccses = new HashSet<RoleUscsActnAccs>(
			0);
	private Set<Menu> menus = new HashSet<Menu>(0);
	private Set<UsrUscsActnAccs> usrUscsActnAccses = new HashSet<UsrUscsActnAccs>(
			0);
	// Constructors

	/** default constructor */
	public UsecaseAction() {
	}
	
	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "usecaseAction")
	public Set<RoleUscsActnAccs> getRoleUscsActnAccses() {
		return this.roleUscsActnAccses;
	}

	public void setRoleUscsActnAccses(
			Set<RoleUscsActnAccs> roleUscsActnAccses) {
		this.roleUscsActnAccses = roleUscsActnAccses;
	}

	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "usecaseAction")
	public Set<Menu> getMenus() {
		return this.menus;
	}

	public void setMenus(Set<Menu> menus) {
		this.menus = menus;
	}

	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "usecaseAction")
	public Set<UsrUscsActnAccs> getUsrUscsActnAccses() {
		return this.usrUscsActnAccses;
	}

	public void setUsrUscsActnAccses(
			Set<UsrUscsActnAccs> usrUscsActnAccses) {
		this.usrUscsActnAccses = usrUscsActnAccses;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CO_USECASE_ID", unique = false, nullable = false, insertable = true, updatable = true)
	public Usecase getUsecase() {
		return usecase;
	}

	public void setUsecase(Usecase usecase) {
		this.usecase = usecase;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CO_ACTION_ID", unique = false, nullable = false, insertable = true, updatable = true)
	public Action getAction() {
		return action;
	}
	
	public void setAction(Action action) {
		this.action = action;
	}
	
}