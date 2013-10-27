 package com.utopia.core.security.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import com.utopia.common.basicinformation.bpartner.model.CmBpartner;
import com.utopia.core.model.AbstractOrganizationData;

/**
 * AbstractCoUser entity provides the base persistence definition of the CoUser
 * entity.
 * 
 * @author Mehdi
 */
@MappedSuperclass
public abstract class AbstractCoUser extends AbstractOrganizationData implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -7507791792184619004L;
	private Long coUserId;
	private String username;
	private String password;
	private byte[] userImage;
	private CmBpartner cmBpartner;
	private Set<CoUsrUscsActnAccs> coUsrUscsActnAccses = new HashSet<CoUsrUscsActnAccs>(
			0);
	private Set<CoUserRoles> coUserRoleses = new HashSet<CoUserRoles>(0);

	// Constructors

	/** default constructor */
	public AbstractCoUser() {
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE,
			generator="UserSequenceGenerator")
	@Column(name = "CO_USER_ID", unique = true, nullable = false, insertable = true, updatable = true, precision = 10, scale = 0)
	public Long getCoUserId() {
		return this.coUserId;
	}

	public void setCoUserId(Long coUserId) {
		this.coUserId = coUserId;
	}

	@Column(name = "USERNAME", unique = true, nullable = false, insertable = true, updatable = true, length = 200)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

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

	@ManyToOne(cascade={CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH})	
	@JoinColumn(name = "CM_BPARTNER_ID", referencedColumnName = "CM_BPARTNER_ID")
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

}