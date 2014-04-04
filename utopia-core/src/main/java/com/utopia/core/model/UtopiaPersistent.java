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
	public User getCreatedby() ;
//************************************************************************************************
	public void setCreatedby(User createdby) ;
//***********************************************************************************************
	public Date getUpdated() ;
//************************************************************************************************
	public void setUpdated(Date updated) ;
//************************************************************************************************
	public User getUpdatedby() ;
//************************************************************************************************
	public void setUpdatedby(User updatedby); 
//************************************************************************************************
}