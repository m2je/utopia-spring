package com.utopia.common.basicinformation.bpartner.model;

import java.util.Date;
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
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.utopia.core.model.AbstractUtopiaPersistent;

/**
 * AbstractCmCompanyBpartner entity provides the base persistence definition of
 * the CmCompanyBpartner entity.
 * 
 * @author Mehdi
 */
@MappedSuperclass
public abstract class AbstractCmCompanyBpartner extends AbstractUtopiaPersistent implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 6412122310239904308L;
	private Long cmCompanyBpartnerId;
	private CmBpartner cmBpartner;
	private CmCompanyBpartner cmCompanyBpartner;
	private String website;
	private String phoneNo;
	private Date establishedDate;
	private String establishedCode;
	private String zipCode;
	private String iranCode;
	private Date iranCodeDate;
	private String description;
	
	
	private Set<CmCompanyBpartner> cmCompanyBpartners = new HashSet<CmCompanyBpartner>(
			0);
	private Set<CmPersonBpartner> cmPersonBpartners = new HashSet<CmPersonBpartner>(
			0);

	// Constructors

	/** default constructor */
	public AbstractCmCompanyBpartner() {
	}


	// Property accessors
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE,
			generator="CmCompanyBpartnerSequenceGenerator")
	@Column(name = "CM_COMPANY_BPARTNER_ID", unique = true, nullable = false, insertable = true, updatable = true, precision = 10, scale = 0)
	public Long getCmCompanyBpartnerId() {
		return this.cmCompanyBpartnerId;
	}

	public void setCmCompanyBpartnerId(Long cmCompanyBpartnerId) {
		this.cmCompanyBpartnerId = cmCompanyBpartnerId;
	}

	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "CM_BPARTNER_ID", unique = false, nullable = false, insertable = true, updatable = true)
	public CmBpartner getCmBpartner() {
		return this.cmBpartner;
	}

	public void setCmBpartner(CmBpartner cmBpartner) {
		this.cmBpartner = cmBpartner;
	}

	@ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
	@JoinColumn(name = "PARENT_COMPANY", unique = false, nullable = true, insertable = true, updatable = true)
	public CmCompanyBpartner getCmCompanyBpartner() {
		return this.cmCompanyBpartner;
	}

	public void setCmCompanyBpartner(CmCompanyBpartner cmCompanyBpartner) {
		this.cmCompanyBpartner = cmCompanyBpartner;
	}

	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "cmCompanyBpartner")
	public Set<CmCompanyBpartner> getCmCompanyBpartners() {
		return this.cmCompanyBpartners;
	}

	public void setCmCompanyBpartners(Set<CmCompanyBpartner> cmCompanyBpartners) {
		this.cmCompanyBpartners = cmCompanyBpartners;
	}

	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "cmCompanyBpartner")
	public Set<CmPersonBpartner> getCmPersonBpartners() {
		return this.cmPersonBpartners;
	}

	public void setCmPersonBpartners(Set<CmPersonBpartner> cmPersonBpartners) {
		this.cmPersonBpartners = cmPersonBpartners;
	}


	
	@Column(name = "WEBSITE", unique = false, nullable = false, insertable = true, updatable = true)
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}


	
	@Column(name = "PHONENO", unique = false, nullable = false, insertable = true, updatable = true)
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}


	
	@Temporal(TemporalType.DATE)
	@Column(name = "ESTABLISHED_DATE", unique = false, nullable = false, insertable = true, updatable = true, length = 7)
	public Date getEstablishedDate() {
		return establishedDate;
	}
	public void setEstablishedDate(Date establishedDate) {
		this.establishedDate = establishedDate;
	}


	
	@Column(name = "ESTABLISHED_CODE", unique = false, nullable = false, insertable = true, updatable = true)
	public String getEstablishedCode() {
		return establishedCode;
	}
	public void setEstablishedCode(String establishedCode) {
		this.establishedCode = establishedCode;
	}


	
	@Column(name = "ZIP_CODE", unique = false, nullable = false, insertable = true, updatable = true)
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}


	
	@Column(name = "IRAN_CODE", unique = false, nullable = false, insertable = true, updatable = true)
	public String getIranCode() {
		return iranCode;
	}
	public void setIranCode(String iranCode) {
		this.iranCode = iranCode;
	}


	
	@Temporal(TemporalType.DATE)
	@Column(name = "IRAN_CODE_DATE", unique = false, nullable = false, insertable = true, updatable = true, length = 7)
	public Date getIranCodeDate() {
		return iranCodeDate;
	}
	public void setIranCodeDate(Date iranCodeDate) {
		this.iranCodeDate = iranCodeDate;
	}


	
	@Column(name = "DESCRIPTION", unique = false, nullable = false, insertable = true, updatable = true)
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}