package com.utopia.core.util;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.utopia.common.model.CmSystem;
import com.utopia.core.model.AbstractBasicPersistent;

@Entity
@Table(name="CO_SETTINGS")
public class CoSettings extends AbstractBasicPersistent{

	private String key;
	private String value;
	private String description;
	private CmSystem cmSystem;
	
	@Column(name="K")
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	@Column(name="V")
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	@Column(name="DESCRIPTION")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CM_SYSTEM_ID")
	public CmSystem getCmSystem() {
		return cmSystem;
	}
	public void setCmSystem(CmSystem cmSystem) {
		this.cmSystem = cmSystem;
	}
	
	
}
