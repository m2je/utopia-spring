package com.utopia.common.basicinformation.bpartner.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.utopia.common.basicinformation.location.model.CmProvince;
import com.utopia.common.basicinformation.location.model.CmState;
import com.utopia.core.constants.Constants;
import com.utopia.core.model.AbstractUtopiaPersistent;

/**
 * AbstractCmPersonBpartner entity provides the base persistence definition of
 * the CmPersonBpartner entity.
 * 
 * @author Mehdi
 */
@MappedSuperclass
public abstract class AbstractCmPersonBpartner extends AbstractUtopiaPersistent implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 8914897790981677748L;
	private Long cmPersonBpartnerId;
	private CmCompanyBpartner cmCompanyBpartner;
	private CmBpartner cmBpartner;
	private Constants.Sex sex;
	private Long phoneNo;
	private Long mobile;
	private Date birthDate;
	private Constants.MaritalStatus maritalStatus;
	private String birthCertificateNumber;
	private String birthCertificateSerial;
	private String fatherName;
	private CmState cmState;
	private CmProvince cmProvince;
	private String lodgingAddress;
	

	// Constructors

	/** default constructor */
	public AbstractCmPersonBpartner() {
	}

	

	// Property accessors
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE,
			generator="CmPersonBpartnerSequenceGenerator")
	@Column(name = "CM_PERSON_BPARTNER_ID", unique = true, nullable = false, insertable = true, updatable = true, precision = 10, scale = 0)
	public Long getCmPersonBpartnerId() {
		return this.cmPersonBpartnerId;
	}

	public void setCmPersonBpartnerId(Long cmPersonBpartnerId) {
		this.cmPersonBpartnerId = cmPersonBpartnerId;
	}

	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@JoinColumn(name = "CM_COMPANY_BPARTNER_ID", unique = false, nullable = true, insertable = true, updatable = true)
	public CmCompanyBpartner getCmCompanyBpartner() {
		return this.cmCompanyBpartner;
	}

	public void setCmCompanyBpartner(CmCompanyBpartner cmCompanyBpartner) {
		this.cmCompanyBpartner = cmCompanyBpartner;
	}

	@OneToOne(cascade = {CascadeType.MERGE,CascadeType.REFRESH,CascadeType.REMOVE,CascadeType.PERSIST})
	@JoinColumn(name = "CM_BPARTNER_ID", unique = true, nullable = false, insertable = true, updatable = false)
	public CmBpartner getCmBpartner() {
		return this.cmBpartner;
	}

	public void setCmBpartner(CmBpartner cmBpartner) {
		this.cmBpartner = cmBpartner;
	}
	@Enumerated(value= EnumType.ORDINAL)
	@Column(name = "SEX", unique = false, nullable = false, insertable = true, updatable = true, precision = 1, scale = 0)
	public Constants.Sex getSex() {
		return this.sex;
	}

	public void setSex(Constants.Sex sex) {
		this.sex = sex;
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
	public CmState getCmState() {
		return cmState;
	}

	public void setCmState(CmState cmState) {
		this.cmState = cmState;
	}

	@ManyToOne
	@JoinColumn(name = "CM_PROVINCE_ID", unique = false, nullable = true, insertable = true, updatable = true)
	public CmProvince getCmProvince() {
		return cmProvince;
	}

	public void setCmProvince(CmProvince cmProvince) {
		this.cmProvince = cmProvince;
	}

	@Column(name = "LODGING_ADDRESS", unique = false, nullable = true, insertable = true, updatable = true, length = 1000)
	public String getLodgingAddress() {
		return lodgingAddress;
	}

	public void setLodgingAddress(String lodgingAddress) {
		this.lodgingAddress = lodgingAddress;
	}
	

}