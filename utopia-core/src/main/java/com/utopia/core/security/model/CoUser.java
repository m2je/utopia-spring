 package com.utopia.core.security.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import com.utopia.common.model.CmBpartner;
import com.utopia.core.model.AbstractOrganizationData;
import com.utopia.core.model.annotations.LookupConfiguration;

/**
 * AbstractCoUser entity provides the base persistence definition of the CoUser
 * entity.
 * 
 * @author Mehdi
 */
@Entity
@Table(name = "CO_USER", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "CM_BPARTNER_ID" }),
		@UniqueConstraint(columnNames = { "USERNAME","CO_PORTAL_ID" }) })
@LookupConfiguration(displayColumns={"username","cmBpartner.name","cmBpartner.secoundName"},displayItemSeperator="-")
@JsonIgnoreProperties({"password","createdby","updatedby"})
public  class CoUser extends AbstractOrganizationData implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -7507791792184619004L;
	private String username;
	private String password;
	private byte[] userImage;
	private CmBpartner cmBpartner;
	private CoPortal coPortal;
	private Set<CoUsrUscsActnAccs> coUsrUscsActnAccses = new HashSet<CoUsrUscsActnAccs>(
			0);
	private Set<CoUserRoles> coUserRoleses = new HashSet<CoUserRoles>(0);
	
	// Constructors

	/** default constructor */
	public CoUser() {
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
	public CmBpartner getCmBpartner() {
		return this.cmBpartner;
	}

	public void setCmBpartner(CmBpartner cmBpartner) {
		this.cmBpartner = cmBpartner;
	}

	@OneToMany(cascade = {}, fetch = FetchType.LAZY, mappedBy = "coUser")
	public Set<CoUsrUscsActnAccs> getCoUsrUscsActnAccses() {
		return this.coUsrUscsActnAccses;
	}

	public void setCoUsrUscsActnAccses(
			Set<CoUsrUscsActnAccs> coUsrUscsActnAccses) {
		this.coUsrUscsActnAccses = coUsrUscsActnAccses;
	}

	@OneToMany( fetch = FetchType.LAZY, mappedBy = "coUser",cascade=CascadeType.ALL)
	@OrderBy
	public Set<CoUserRoles> getCoUserRoleses() {
		return this.coUserRoleses;
	}

	public void setCoUserRoleses(Set<CoUserRoles> coUserRoleses) {
		this.coUserRoleses = coUserRoleses;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CO_PORTAL_ID")
	public CoPortal getCoPortal() {
		return coPortal;
	}

	public void setCoPortal(CoPortal coPortal) {
		this.coPortal = coPortal;
	}
	@Transient
	public String getName() {
		return cmBpartner==null&&isInitialized(cmBpartner, "name")?cmBpartner.getName():null;
	}


	
	


	

	
	
}