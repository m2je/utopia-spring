package com.utopia.core.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.utopia.common.model.System;

@Entity
@Table(name="CO_SETTINGS")
public class Settings extends AbstractBasicPersistent{

	private String key;
	private String value;
	private String description;
	private System system;
	
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
	public System getSystem() {
		return system;
	}
	public void setSystem(System system) {
		this.system = system;
	}
	
	
}
