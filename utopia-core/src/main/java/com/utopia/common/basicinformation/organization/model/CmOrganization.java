package com.utopia.common.basicinformation.organization.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.utopia.core.model.annotations.LookupConfiguration;


@Entity
@Table(name = "CM_ORGANIZATION",  uniqueConstraints = { /*@UniqueConstraint(columnNames = { "NAME","PARENT_ID" })*/ })
@TableGenerator(name = "OrganizationSequenceGenerator", 
		table = "CO_SEQUENCE", pkColumnName = "TABLENAME", valueColumnName = "CURRENTID", pkColumnValue = "CM_ORGANIZATION")
@LookupConfiguration(displayColumns={"code","name"},displayItemSeperator=" - ",descriptionColumnName="description")

public class CmOrganization extends AbstractCmOrganization implements
		java.io.Serializable {

	// Constructors

	/**
	 * 
	 */
	private static final long serialVersionUID = 8180180758996422538L;

	/** default constructor */
	public CmOrganization() {
	}

	

}
