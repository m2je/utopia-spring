package com.utopia.core.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.utopia.core.lookup.DetailPersistentValueInfo;
import com.utopia.core.lookup.LookupInfo;

public interface UtopiaBasicPersistent extends Serializable{

	/**
	 * 
	 * @return
	 */
	public Long getId();
	/**
	 * 
	 */
	public void setId(Long recordId);
	
	/**
	 * sets lookup information 
	 * @param info
	 */
	public void setLookupInfos(List<LookupInfo> infos);
	/**
	 * 
	 * @return
	 */
	public List<LookupInfo> getLookupInfo();
	/**
	 * 
	 * @param info
	 */
	public void setAttachmentInfos(List<UtopiaAttachmentInfo> infos);
	/**
	 * 
	 */
	public List<UtopiaAttachmentInfo> getAttachmentInfos();
	/**
	 * 
	 * @param customProperties
	 */
	public void setCustomProperties(Map<String,String>customProperties);
	/**
	 * 
	 * @param 
	 */
	public Map<String,String> getCustomProperties();
	public abstract List<List<String>> getCustomPropertyList();
	
	public abstract void setCustomPropertyList(List<List<String>>customProperties);
	
	public void setRevisionDescription(String description);
	
	public String getRevisionDescription();
	
	public void setIncludedPersistentValue(String columnName,Collection<DetailPersistentValueInfo> includedValues );
	
	public Collection<DetailPersistentValueInfo> getIncludedPersistentValue(String columnName);
	
	
}
