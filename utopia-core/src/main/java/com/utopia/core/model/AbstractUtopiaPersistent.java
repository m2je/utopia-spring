package com.utopia.core.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.utopia.core.security.model.CoUser;

@MappedSuperclass
public abstract class AbstractUtopiaPersistent extends SoftDeletePersistentSupport implements UtopiaPersistent,Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5376839244673906173L;
	private Date created;
	private CoUser createdby;
	private Date updated;
	private CoUser updatedby;
	
//************************************************************************************************	
	public AbstractUtopiaPersistent(){
	}
//************************************************************************************************	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED", unique = false, nullable = false, insertable = false, updatable = false )
	public Date getCreated() {
		return this.created;
	}
//************************************************************************************************
	public void setCreated(Date created) {
		this.created = created;
	}
//************************************************************************************************
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "CREATEDBY", unique = false, nullable = false, insertable = true, updatable = true)
	public CoUser getCreatedby() {
		return this.createdby;
	}
//************************************************************************************************
	public void setCreatedby(CoUser createdby) {
		this.createdby = createdby;
	}
//***********************************************************************************************
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UPDATED", unique = false, nullable = false, insertable = false, updatable = true)
	public Date getUpdated() {
		return this.updated;
	}
//************************************************************************************************
	public void setUpdated(Date updated) {
		this.updated = updated;
	}
//************************************************************************************************
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "UPDATEDBY", unique = false, nullable = false, insertable = true, updatable = true)
	public CoUser getUpdatedby() {
		return this.updatedby;
	}
//************************************************************************************************
	public void setUpdatedby(CoUser updatedby) {
		this.updatedby = updatedby;
	}
	
}
