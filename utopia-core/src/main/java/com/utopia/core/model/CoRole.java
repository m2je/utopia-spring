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
public  class CoRole extends AbstractUtopiaPersistent implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -7000866511878044342L;
	private String name;
	
	private Set<CoUserRoles> coUserRoleses = new HashSet<CoUserRoles>(0);
	private Set<CoRoleUscsActnAccs> coRoleUscsActnAccses = new HashSet<CoRoleUscsActnAccs>(
			0);

	private Set<CoRoleSubsystemAcss> coRoleSubsystemAcsses = new HashSet<CoRoleSubsystemAcss>(
			0);


	// Constructors

	/** default constructor */
	public CoRole() {
	}

	@Column(name = "NAME", unique = true, nullable = false, insertable = true, updatable = true, length = 200)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "coRole")
	public Set<CoUserRoles> getCoUserRoleses() {
		return this.coUserRoleses;
	}

	public void setCoUserRoleses(Set<CoUserRoles> coUserRoleses) {
		this.coUserRoleses = coUserRoleses;
	}

	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "coRole")
	public Set<CoRoleUscsActnAccs> getCoRoleUscsActnAccses() {
		return this.coRoleUscsActnAccses;
	}

	public void setCoRoleUscsActnAccses(
			Set<CoRoleUscsActnAccs> coRoleUscsActnAccses) {
		this.coRoleUscsActnAccses = coRoleUscsActnAccses;
	}

	

	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "coRole")
	public Set<CoRoleSubsystemAcss> getCoRoleSubsystemAcsses() {
		return this.coRoleSubsystemAcsses;
	}

	public void setCoRoleSubsystemAcsses(
			Set<CoRoleSubsystemAcss> coRoleSubsystemAcsses) {
		this.coRoleSubsystemAcsses = coRoleSubsystemAcsses;
	}



}