package com.utopia.core.util;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.utopia.common.systems.CmSystem;
import com.utopia.core.model.AbstractBasicPersistent;

@Entity
@Table(name="CO_SETTINGS")
@TableGenerator(name = "SettingSequenceGenerator", 
table = "CO_SEQUENCE", pkColumnName = "TABLENAME", valueColumnName = "CURRENTID", pkColumnValue = "CO_SETTINGS")
public class CoSettings extends AbstractBasicPersistent{

	private Long coSettingId;
	private String key;
	private String value;
	private String description;
	private CmSystem cmSystem;
	
	@GeneratedValue(strategy=GenerationType.TABLE,
			generator="SettingSequenceGenerator")
	@Id
	@Column(name="CO_SETTING_ID")
	public Long getCoSettingId() {
		return coSettingId;
	}
	public void setCoSettingId(Long coSettingId) {
		this.coSettingId = coSettingId;
	}
	@Column(name="KEY")
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	@Column(name="VALUE")
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
