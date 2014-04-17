package com.utopia.common.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.utopia.core.model.AbstractUtopiaSoftDelete;

/**
 * 
 * @author Mehdi
 */
@Entity
@Table(name = "CM_BPARTNER")
public  class Bpartner extends AbstractUtopiaSoftDelete implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -8751979565898415428L;
	private String code;
	private String name;
	private String secondName;
	private Long adderss;
	private String emailaddress;
//	private Set<CompanyBpartner> companyBpartner ;
	private Set<PersonBpartner> personBpartner ;
	
	// Constructors

	/** default constructor */
	public Bpartner() {
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

	@Column(name = "SECOND_NAME", unique = false, nullable = false, insertable = true, updatable = true, length = 200)
	public String getSecondName() {
		return this.secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
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
	@OneToMany(mappedBy="bpartner",fetch=FetchType.LAZY)
	public Set<PersonBpartner> getPersonBpartner() {
		return personBpartner;
	}
	public void setPersonBpartner(Set<PersonBpartner> personBpartner) {
		this.personBpartner = personBpartner;
	}

}