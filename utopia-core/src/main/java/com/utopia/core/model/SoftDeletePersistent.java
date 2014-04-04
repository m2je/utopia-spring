package com.utopia.core.model;


public interface SoftDeletePersistent extends UtopiaBasicPersistent{
	/**
	 * record is deleted
	 * @return
	 */
	public boolean isDeleted() ;
	/**
	 * marks record as deleted
	 * @param deleted
	 */
	public void setDeleted(boolean deleted); 
	
}
