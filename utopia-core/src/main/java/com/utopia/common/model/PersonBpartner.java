package com.utopia.common.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.utopia.core.constants.Constants;
import com.utopia.core.model.AbstractUtopiaPersistent;

/**
 * 
 * @author Mehdi
 */
@Entity
@Table(name = "CM_PERSON_BPARTNER",  uniqueConstraints = {})
public class PersonBpartner extends AbstractUtopiaPersistent implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 8914897790981677748L;
	private CompanyBpartner companyBpartner;
	private Bpartner bpartner;
	private Constants.Gender gender;
	private Long phoneNo;
	private Long mobile;
	private Date birthDate;
	private Constants.MaritalStatus maritalStatus;
	private String birthCertificateNumber;
	private String birthCertificateSerial;
	private String fatherName;
	private State state;
	private Province province;
	private String lodgingAddress;
	

	// Constructors

	/** default constructor */
	public PersonBpartner() {
	}
	
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@JoinColumn(name = "CM_COMPANY_BPARTNER_ID", unique = false, nullable = true, insertable = true, updatable = true)
	public CompanyBpartner getCompanyBpartner() {
		return this.companyBpartner;
	}

	public void setCompanyBpartner(CompanyBpartner companyBpartner) {
		this.companyBpartner = companyBpartner;
	}

	@OneToOne
	@JoinColumn(name = "CM_BPARTNER_ID", unique = true, nullable = false, insertable = true, updatable = false)
	public Bpartner getBpartner() {
		return this.bpartner;
	}

	public void setBpartner(Bpartner bpartner) {
		this.bpartner = bpartner;
	}
	@Enumerated(value= EnumType.ORDINAL)
	@Column(name = "GENDER", unique = false, nullable = false, insertable = true, updatable = true, precision = 1, scale = 0)
	public Constants.Gender getGender() {
		return this.gender;
	}

	public void setGender(Constants.Gender gender) {
		this.gender = gender;
	}

	
	@Column(name = "PHONENO", unique = false, nullable = true, insertable = true, updatable = true, precision = 22, scale = 0)
	public Long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(Long phoneNo) {
		this.phoneNo = phoneNo;
	}
	
	
	@Column(name = "MOBILE", unique = false, nullable = true, insertable = true, updatable = true, precision = 22, scale = 0)
	public Long getMobile() {
		return mobile;
	}
	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}
	
	
	@Temporal(TemporalType.DATE)
	@Column(name = "BIRTHDATE", unique = false, nullable = true, insertable = true, updatable = true, length = 7)
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}



	@Enumerated(value= EnumType.ORDINAL)
	@Column(name = "MARITAL_STATUS", unique = false, nullable = false, insertable = true, updatable = true, precision = 1, scale = 0)
	public Constants.MaritalStatus getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(Constants.MaritalStatus maritalStatus) {
		this.maritalStatus = maritalStatus;
	}



	@Column(name = "BIRTHCERTIFICATE_NUMBER", unique = false, nullable = true, insertable = true, updatable = true, precision = 22, scale = 0)
	public String getBirthCertificateNumber() {
		return birthCertificateNumber;
	}
	public void setBirthCertificateNumber(String birthCertificateNumber) {
		this.birthCertificateNumber = birthCertificateNumber;
	}


	@Column(name = "BIRTHCERTIFICATE_SERIAL", unique = false, nullable = true, insertable = true, updatable = true, precision = 22, scale = 0)
	public String getBirthCertificateSerial() {
		return birthCertificateSerial;
	}
	public void setBirthCertificateSerial(String birthCertificateSerial) {
		this.birthCertificateSerial = birthCertificateSerial;
	}


	@Column(name = "FATHER_NAME", unique = false, nullable = true, insertable = true, updatable = true, length = 200)
	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	@ManyToOne
	@JoinColumn(name = "CM_STATE_ID", unique = false, nullable = true, insertable = true, updatable = true)
	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	@ManyToOne
	@JoinColumn(name = "CM_PROVINCE_ID", unique = false, nullable = true, insertable = true, updatable = true)
	public Province getProvince() {
		return province;
	}

	public void setProvince(Province province) {
		this.province = province;
	}

	@Column(name = "LODGING_ADDRESS", unique = false, nullable = true, insertable = true, updatable = true, length = 1000)
	public String getLodgingAddress() {
		return lodgingAddress;
	}

	public void setLodgingAddress(String lodgingAddress) {
		this.lodgingAddress = lodgingAddress;
	}
	

}