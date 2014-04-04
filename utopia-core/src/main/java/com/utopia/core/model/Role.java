package com.utopia.core.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * 
 * 
 * 
 * @author Mehdi
 */
@Entity
@Table(name = "CO_ROLE",  uniqueConstraints = { @UniqueConstraint(columnNames = { "NAME" }) })
public  class Role extends AbstractUtopiaPersistent implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -7000866511878044342L;
	private String name;
	
	private Set<UserRoles> userRoleses = new HashSet<UserRoles>(0);
	private Set<RoleUscsActnAccs> roleUscsActnAccses = new HashSet<RoleUscsActnAccs>(
			0);

	private Set<RoleSubsystemAcss> roleSubsystemAcsses = new HashSet<RoleSubsystemAcss>(
			0);


	// Constructors

	/** default constructor */
	public Role() {
	}

	@Column(name = "NAME", unique = true, nullable = false, insertable = true, updatable = true, length = 200)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "role")
	public Set<UserRoles> getUserRoleses() {
		return this.userRoleses;
	}

	public void setUserRoleses(Set<UserRoles> userRoleses) {
		this.userRoleses = userRoleses;
	}

	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "role")
	public Set<RoleUscsActnAccs> getRoleUscsActnAccses() {
		return this.roleUscsActnAccses;
	}

	public void setRoleUscsActnAccses(
			Set<RoleUscsActnAccs> roleUscsActnAccses) {
		this.roleUscsActnAccses = roleUscsActnAccses;
	}

	

	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "role")
	public Set<RoleSubsystemAcss> getRoleSubsystemAcsses() {
		return this.roleSubsystemAcsses;
	}

	public void setRoleSubsystemAcsses(
			Set<RoleSubsystemAcss> roleSubsystemAcsses) {
		this.roleSubsystemAcsses = roleSubsystemAcsses;
	}



}