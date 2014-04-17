 package com.utopia.core.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.utopia.common.model.Bpartner;
import com.utopia.core.model.annotations.LookupConfiguration;

/**
 * 
 * @author Mehdi
 */
@Entity
@Table(name = "CO_USER", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "CM_BPARTNER_ID" }),
		@UniqueConstraint(columnNames = { "USERNAME","CO_PORTAL_ID" }) })
@LookupConfiguration(displayColumns={"username","bpartner.name","bpartner.secoundName"},displayItemSeperator="-")
@JsonIgnoreProperties({"password","createdby","updatedby"})
public  class User extends AbstractOrganizationData implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -7507791792184619004L;
	private String username;
	private String password;
	private byte[] userImage;
	private Bpartner bpartner;
	private Portal portal;
	private Set<UsrUscsActnAccs> usrUscsActnAccses = new HashSet<UsrUscsActnAccs>(
			0);
	private Set<UserRoles> userRoles;
	
	// Constructors

	/** default constructor */
	public User() {
	}


	@Column(name = "USERNAME", unique = true, nullable = false, insertable = true, updatable = true, length = 200)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	@Type(type="encryptedString")
	@Column(name = "PASSWORD", unique = false, nullable = false, insertable = true, updatable = true, length = 200)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	@Lob
	@Basic(fetch=FetchType.LAZY)
	@Column(name = "USER_IMAGE", unique = false, nullable = true, insertable = true, updatable = true)
	public byte[] getUserImage() {
		return this.userImage;
	}

	public void setUserImage(byte[] userImage) {
		this.userImage = userImage;
	}

	@OneToOne(fetch=FetchType.LAZY)	
	@JoinColumn(name = "CM_BPARTNER_ID",updatable=false,insertable=false)
	public Bpartner getBpartner() {
		return this.bpartner;
	}

	public void setBpartner(Bpartner bpartner) {
		this.bpartner = bpartner;
	}

	@OneToMany(cascade = {}, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<UsrUscsActnAccs> getUsrUscsActnAccses() {
		return this.usrUscsActnAccses;
	}

	public void setUsrUscsActnAccses(
			Set<UsrUscsActnAccs> usrUscsActnAccses) {
		this.usrUscsActnAccses = usrUscsActnAccses;
	}

	@OneToMany( fetch = FetchType.LAZY, mappedBy = "user")
	@OrderBy
	public Set<UserRoles> getUserRoles() {
		return this.userRoles;
	}

	public void setUserRoles(Set<UserRoles> userRoles) {
		this.userRoles = userRoles;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CO_PORTAL_ID")
	public Portal getPortal() {
		return portal;
	}

	public void setPortal(Portal portal) {
		this.portal = portal;
	}
	@Transient
	public String getName() {
		return bpartner==null&&isInitialized(bpartner, "name")?bpartner.getName():null;
	}


	
	


	

	
	
}