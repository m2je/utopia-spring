package com.utopia.core.lookup;

import java.io.Serializable;

import com.utopia.core.model.UtopiaBasicPersistent;

public class DetailPersistentValueInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4776925863055853260L;

	private UtopiaBasicPersistent value;
	private boolean deleted;
	public DetailPersistentValueInfo( UtopiaBasicPersistent value,boolean deleted) {
		this.value=value;
		this.deleted=deleted;
	}

	public UtopiaBasicPersistent getValue() {
		return value;
	}

	public void setValue(UtopiaBasicPersistent value) {
		this.value = value;
	}


	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	
}
