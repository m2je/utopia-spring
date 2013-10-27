package com.utopia.core.security.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.utopia.core.model.annotations.LookupConfiguration;

/**
 * CoUser entity.
 * 
 * @author Mehdi
 */
@Entity
@Table(name = "CO_USER", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "CM_BPARTNER_ID" }),
		@UniqueConstraint(columnNames = { "USERNAME" }) })
@TableGenerator(name = "UserSequenceGenerator", 
		table = "CO_SEQUENCE", pkColumnName = "TABLENAME", valueColumnName = "CURRENTID", pkColumnValue = "CO_USER")
@LookupConfiguration(displayColumns={"username","cmBpartner.name","cmBpartner.secoundName"},displayItemSeperator="-")
@JsonIgnoreProperties({"passowrd","createdby","updatedby"})
public class CoUser extends AbstractCoUser implements java.io.Serializable {

	// Constructors

	/**
	 * 
	 */
	private static final long serialVersionUID = 4888068698179249948L;

	/** default constructor */
	public CoUser() {
	}


}
