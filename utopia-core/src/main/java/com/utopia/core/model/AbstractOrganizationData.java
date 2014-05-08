package com.utopia.core.model;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import com.utopia.common.model.Organization;

@MappedSuperclass
public abstract class AbstractOrganizationData extends AbstractUtopiaSoftDelete implements OrganizationData {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6381499175807559534L;
	private Organization organization;
	
	@Override
	public void setOrganization(Organization organization) {
		this.organization=organization;
		
	}

	@Override
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "CM_ORGANIZATION_ID", unique = false, nullable = false, insertable = true, updatable = true)
	public Organization getOrganization() {
		return organization;
	}

}
