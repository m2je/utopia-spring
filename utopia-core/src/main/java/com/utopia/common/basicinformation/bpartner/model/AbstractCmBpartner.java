package com.utopia.common.basicinformation.bpartner.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;

import com.utopia.core.model.AbstractUtopiaPersistent;

/**
 * AbstractCmBpartner entity provides the base persistence definition of the
 * CmBpartner entity.
 * 
 * @author Mehdi
 */
@MappedSuperclass
public abstract class AbstractCmBpartner extends AbstractUtopiaPersistent implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -8751979565898415428L;
	private Long cmBpartnerId;
	private String code;
	private String name;
	private String secoundName;
	private Long adderss;
	private String emailaddress;
//	private Set<CmCompanyBpartner> cmCompanyBpartner ;
	private Set<CmPersonBpartner> cmPersonBpartner ;
	
//	private Set<CmCustomer> cmcustomer;
	// Constructors

	/** default constructor */
	public AbstractCmBpartner() {
	}
	// Property accessors
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE,
			generator="CmBpartnerSequenceGenerator")
	@Column(name = "CM_BPARTNER_ID", unique = true, nullable = false, insertable = true, updatable = true, precision = 10, scale = 0)
	public Long getCmBpartnerId() {
		return this.cmBpartnerId;
	}

	public void setCmBpartnerId(Long cmBpartnerId) {
		this.cmBpartnerId = cmBpartnerId;
	}

	@Column(name = "CODE", unique = false, nullable = false, insertable = true, updatable = true, length = 10)
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "NAME", unique = false, nullable = true, insertable = true, updatable = true, length = 200)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "SECOUND_NAME", unique = false, nullable = false, insertable = true, updatable = true, length = 200)
	public String getSecoundName() {
		return this.secoundName;
	}

	public void setSecoundName(String secoundName) {
		this.secoundName = secoundName;
	}

	@Column(name = "ADDERSS", unique = false, nullable = true, insertable = true, updatable = true, precision = 10, scale = 0)
	public Long getAdderss() {
		return this.adderss;
	}

	public void setAdderss(Long adderss) {
		this.adderss = adderss;
	}

	@Column(name = "EMAILADDRESS", unique = false, nullable = true, insertable = true, updatable = true, length = 4000)
	public String getEmailaddress() {
		return this.emailaddress;
	}

	public void setEmailaddress(String emailaddress) {
		this.emailaddress = emailaddress;
	}
//	@OneToMany(cascade={CascadeType.ALL},mappedBy="cmBpartner")
//	public Set<CmCompanyBpartner> getCmCompanyBpartner() {
//		return cmCompanyBpartner;
//	}
//	public void setCmCompanyBpartner(Set<CmCompanyBpartner> cmCompanyBpartner) {
//		this.cmCompanyBpartner = cmCompanyBpartner;
//	}
	@OneToMany(cascade={CascadeType.ALL},mappedBy="cmBpartner",fetch=FetchType.EAGER)
	public Set<CmPersonBpartner> getCmPersonBpartner() {
		return cmPersonBpartner;
	}
	public void setCmPersonBpartner(Set<CmPersonBpartner> cmPersonBpartner) {
		this.cmPersonBpartner = cmPersonBpartner;
	}
//	@OneToOne(cascade={CascadeType.ALL},mappedBy="cmBpartner",fetch=FetchType.LAZY)
//	public Set<CmCustomer> getCmcustomer() {
//		return cmcustomer;
//	}
//	public void setCmcustomer(Set<CmCustomer> cmcustomer) {
//		this.cmcustomer = cmcustomer;
//	}

}