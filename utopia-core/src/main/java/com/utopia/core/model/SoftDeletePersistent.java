package com.utopia.core.model;


public interface SoftDeletePersistent extends UtopiaBasicPersistent{
	
	public boolean isDeleted() ;
	//************************************************************************************************
		public void setDeleted(boolean deleted); 
	//************************************************************************************************
}
