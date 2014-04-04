package com.utopia.core.model;

import com.utopia.common.model.Organization;


public interface OrganizationData extends UtopiaBasicPersistent {
	/**
	 * 
	 * @param organization
	 */
	public void setOrganization(Organization organization);
	/**
	 * 
	 * @return
	 */
	public Organization getOrganization();
}
