package com.utopia.core.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.utopia.common.model.CmSubsystem;
import com.utopia.core.constants.Constants.MenuLinkTarget;
import com.utopia.core.model.annotations.LookupConfiguration;
import com.utopia.core.security.model.CoUsecaseAction;

/**
 * AbstractCoMenu entity provides the base persistence definition of the CoMenu
 * entity.
 * 
 * @author Mehdi
 */
@Entity
@Table(name = "CO_MENU", uniqueConstraints = {})
@EntityListeners(com.utopia.core.model.CoMenuListener.class)
public  class CoMenu extends AbstractUtopiaPersistent implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -5853978934258888987L;
//	private AbstractCoMenu parentCoMenu;
	private CoUsecaseAction coUsecaseAction;
	
	private String name;
	private CoMenu parentMenu;
	private String iconPath;
	private CmSubsystem cmSubSystem;
	private long precedence;
	private String directUrl;
	private MenuLinkTarget linkTarget;
	private Set<CoMenu> children = new HashSet<CoMenu>(0);
	private CoMenuType menuType;
	// Constructors
	


	/** default constructor */
	public CoMenu() {
	}

	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@JoinColumn(name = "CO_USECASE_ACTION_ID", unique = false, nullable = true, insertable = true, updatable = true)
	@LookupConfiguration( displayColumns={"coAction.name","coUsecase.name"},displayItemSeperator="  -  ")
	public CoUsecaseAction getCoUsecaseAction() {
		return this.coUsecaseAction;
	}

	public void setCoUsecaseAction(CoUsecaseAction coUsecaseAction) {
		this.coUsecaseAction = coUsecaseAction;
	}
	
	@Column(name = "NAME", unique = false, nullable = false, insertable = true, updatable = true, length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@JoinColumn(name = "PARENT_MENU_ID", unique = false, nullable = true, insertable = true, updatable = true)
	public CoMenu getParentMenu() {
		return parentMenu;
	}
	public void setParentMenu(CoMenu parentMenu) {
		this.parentMenu = parentMenu;
	}

	@Column(name="ICON")
	public String getIconPath() {
		return iconPath;
	}

	public void setIconPath(String iconPath) {
		this.iconPath = iconPath;
	}
	
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@JoinColumn(name = "CM_SUBSYSTEM_ID", unique = false, nullable = true, insertable = true, updatable = true)
	@LookupConfiguration(displayColumns={"name","cmSystem.name"},displayItemSeperator="  -  ")
	public CmSubsystem getCmSubSystem() {
		return cmSubSystem;
	}

	public void setCmSubSystem(CmSubsystem cmSubSystem) {
		this.cmSubSystem = cmSubSystem;
	}
	
	@Column(name = "PRECEDENCE", unique = false, nullable = true, insertable = true, updatable = true, precision = 5, scale = 0)
	public long getPrecedence() {
		return precedence;
	}

	public void setPrecedence(long precedence) {
		this.precedence = precedence;
	}

	@Column(name = "DIRECT_URL", unique = false, nullable = false, insertable = true, updatable = true, length = 50)
	public String getDirectUrl() {
		return this.directUrl;
	}

	public void setDirectUrl(String direcUrl) {
		this.directUrl = direcUrl;
	}
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "LINK_TARGET", unique = false, nullable = false, insertable = true, updatable = true, length = 50)
	public MenuLinkTarget getLinkTarget() {
		return this.linkTarget;
	}

	public void setLinkTarget(MenuLinkTarget linkTarget) {
		this.linkTarget = linkTarget;
	}
	@Enumerated(EnumType.ORDINAL)
	@Column(name="MENU_TYPE")
	public CoMenuType getMenuType() {
		return menuType;
	}


	public void setMenuType(CoMenuType menuType) {
		this.menuType = menuType;
	}

	@OneToMany( fetch = FetchType.LAZY, mappedBy = "parentMenu")
	public Set<CoMenu> getChildren() {
		return children;
	}


	public void setChildren(Set<CoMenu> children) {
		this.children = children;
	}
	
	
}