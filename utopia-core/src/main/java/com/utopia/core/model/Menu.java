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

import com.utopia.common.model.Subsystem;
import com.utopia.core.constants.Constants.MenuLinkTarget;
import com.utopia.core.model.annotations.LookupConfiguration;

/**
 * 
 * @author Mehdi
 */
@Entity
@Table(name = "CO_MENU", uniqueConstraints = {})
@EntityListeners(com.utopia.core.model.MenuListener.class)
public  class Menu extends AbstractUtopiaPersistent implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -5853978934258888987L;
	private UsecaseAction usecaseAction;
	
	private String name;
	private Menu parentMenu;
	private String iconPath;
	private Subsystem subSystem;
	private long precedence;
	private String directUrl;
	private MenuLinkTarget linkTarget;
	private Set<Menu> children = new HashSet<Menu>(0);
	private MenuType menuType;
	// Constructors
	


	/** default constructor */
	public Menu() {
	}

	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@JoinColumn(name = "CO_USECASE_ACTION_ID", unique = false, nullable = true, insertable = true, updatable = true)
	@LookupConfiguration( displayColumns={"action.name","usecase.name"},displayItemSeperator="  -  ")
	public UsecaseAction getUsecaseAction() {
		return this.usecaseAction;
	}

	public void setUsecaseAction(UsecaseAction usecaseAction) {
		this.usecaseAction = usecaseAction;
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
	public Menu getParentMenu() {
		return parentMenu;
	}
	public void setParentMenu(Menu parentMenu) {
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
	@LookupConfiguration(displayColumns={"name","system.name"},displayItemSeperator="  -  ")
	public Subsystem getSubSystem() {
		return subSystem;
	}

	public void setSubSystem(Subsystem subSystem) {
		this.subSystem = subSystem;
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
	public MenuType getMenuType() {
		return menuType;
	}


	public void setMenuType(MenuType menuType) {
		this.menuType = menuType;
	}

	@OneToMany( fetch = FetchType.LAZY, mappedBy = "parentMenu")
	public Set<Menu> getChildren() {
		return children;
	}


	public void setChildren(Set<Menu> children) {
		this.children = children;
	}
	
	
}