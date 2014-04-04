/**
 * 
 */
package com.utopia.core.model;

import java.util.Date;

/**
 * @author salarkia
 *
 */
public interface UtopiaPersistent  extends SoftDeletePersistent{
	public String CODE_FIELD_NAME = "code"; 
	public String NAME_FIELD_NAME = "name"; 
	
	
	
	public Date getCreated() ;
//************************************************************************************************
	public void setCreated(Date created) ;
//************************************************************************************************
	public CoUser getCreatedby() ;
//************************************************************************************************
	public void setCreatedby(CoUser createdby) ;
//***********************************************************************************************
	public Date getUpdated() ;
//************************************************************************************************
	public void setUpdated(Date updated) ;
//************************************************************************************************
	public CoUser getUpdatedby() ;
//************************************************************************************************
	public void setUpdatedby(CoUser updatedby); 
//************************************************************************************************
}