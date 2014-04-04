package com.utopia.common.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.utopia.core.model.AbstractUtopiaPersistent;

/**
 * 
 * @author Mehdi
 */
@Entity
@Table(name = "CM_COMPANY_BPARTNER",  uniqueConstraints = {})
public  class CompanyBpartner extends AbstractUtopiaPersistent implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 6412122310239904308L;
	private Bpartner bpartner;
	private CompanyBpartner companyBpartner;
	private String website;
	private String phoneNo;
	private Date establishedDate;
	private String establishedCode;
	private String zipCode;
	private String iranCode;
	private Date iranCodeDate;
	private String description;
	
	
	private Set<CompanyBpartner> companyBpartners = new HashSet<CompanyBpartner>(
			0);
	private Set<PersonBpartner> personBpartners = new HashSet<PersonBpartner>(
			0);

	// Constructors

	/** default constructor */
	public CompanyBpartner() {
	}


	
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "CM_BPARTNER_ID", unique = false, nullable = false, insertable = true, updatable = true)
	public Bpartner getBpartner() {
		return this.bpartner;
	}

	public void setBpartner(Bpartner bpartner) {
		this.bpartner = bpartner;
	}

	@ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
	@JoinColumn(name = "PARENT_COMPANY", unique = false, nullable = true, insertable = true, updatable = true)
	public CompanyBpartner getCompanyBpartner() {
		return this.companyBpartner;
	}

	public void setCompanyBpartner(CompanyBpartner companyBpartner) {
		this.companyBpartner = companyBpartner;
	}

	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "companyBpartner")
	public Set<CompanyBpartner> getCompanyBpartners() {
		return this.companyBpartners;
	}

	public void setCompanyBpartners(Set<CompanyBpartner> companyBpartners) {
		this.companyBpartners = companyBpartners;
	}

	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "companyBpartner")
	public Set<PersonBpartner> getPersonBpartners() {
		return this.personBpartners;
	}

	public void setPersonBpartners(Set<PersonBpartner> personBpartners) {
		this.personBpartners = personBpartners;
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