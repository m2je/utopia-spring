package com.utopia.core.model;

import com.utopia.common.basicinformation.organization.model.CmOrganization;


public interface OrganizationData extends UtopiaBasicPersistent {
	/**
	 * 
	 * @param organization
	 */
	public void setCmOrganization(CmOrganization organization);
	/**
	 * 
	 * @return
	 */
	public CmOrganization getCmOrganization();
}
