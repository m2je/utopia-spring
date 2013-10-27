package com.utopia.core.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
@MappedSuperclass
public abstract class SoftDeletePersistentSupport extends AbstractBasicPersistent implements SoftDeletePersistent{

	protected boolean deleted;
	
	//************************************************************************************************
	
	@Column(name = "DELETED", unique = false, nullable = false, insertable = true, updatable = true, precision = 1, scale = 0)
	public boolean isDeleted() {
		return this.deleted;
	}
//************************************************************************************************
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
}
