package com.utopia.core.model;

import com.utopia.common.model.CmOrganization;


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
