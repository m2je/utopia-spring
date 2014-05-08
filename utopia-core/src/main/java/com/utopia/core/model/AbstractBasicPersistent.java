package com.utopia.core.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.TableGenerator;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlTransient;

import org.apache.log4j.Logger;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.TypeDef;
import org.hibernate.proxy.HibernateProxy;
import org.jasypt.hibernate4.type.EncryptedStringType;

import com.utopia.core.lookup.DetailPersistentValueInfo;
import com.utopia.core.lookup.LookupInfo;

@MappedSuperclass
@EntityListeners({AttachmentListener.class})
@TypeDef(
	    name="encryptedString", 
	    typeClass=EncryptedStringType.class, 
	    parameters= {
	        @Parameter(name="encryptorRegisteredName", value="UtopiaHibernateStringEncryptor")
	    }
	)
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)

public abstract class  AbstractBasicPersistent implements UtopiaBasicPersistent,Serializable{

	private static final long serialVersionUID = 5758087573780089720L;
	private static final Logger logger;
	
	static {
		logger = Logger.getLogger(AbstractBasicPersistent.class);
	}
	private List<LookupInfo> infos;
	private List<UtopiaAttachmentInfo> attachInfos;
	private List<List<String>> customProperties;
	private String revisionDescription;
	private HashMap<String,Collection<DetailPersistentValueInfo>>includedPersistentValues;
	protected Long id;
//************************************************************************************************
	@Column
	@Id
	@TableGenerator(name = "SequenceGenerator", 
	table = "CO_SEQUENCE", pkColumnName = "TABLE_NAME", valueColumnName = "CURRENT_ID")
	@GeneratedValue(strategy=GenerationType.TABLE,
	generator="SequenceGenerator")
	public Long getId() {
		return id;
	}
//************************************************************************************************
	public void setId(Long id) {
		this.id=id;
	}
//************************************************************************************************
	@XmlTransient
	@Transient
	public List<LookupInfo> getLookupInfo() {
		return infos;
	}
//************************************************************************************************
	public void setLookupInfos(List<LookupInfo> infos) {
		this.infos=infos;
	}
//************************************************************************************************
	@Override
	public void setAttachmentInfos(List<UtopiaAttachmentInfo> infos) {
		this.attachInfos=infos;
	}
//************************************************************************************************
	@Override
	@Transient
	@XmlTransient
	public List<UtopiaAttachmentInfo> getAttachmentInfos() {
		return attachInfos;
	}
//************************************************************************************************
	@Override
	public void setCustomProperties(Map<String, String> customProperties) {
		if(customProperties!=null){
			this.customProperties=new ArrayList<List<String>>();
			for(String key: customProperties.keySet()){
				List<String> row=new ArrayList<String>();
				row.add(key);
				row.add(customProperties.get(key));
				this.customProperties.add(row);
			}
		}else{
			this.customProperties=null;
		}
		
	}
//************************************************************************************************	
	@Override
	@Transient
	@XmlTransient
	public Map<String, String> getCustomProperties() {
		if(customProperties!=null){
			HashMap<String,String>result=new HashMap<String, String>();
			for(List<String>row:customProperties){
				result.put(row.get(0), row.get(1));
			}
			return result;
		}else{
			return null;
		}
		
	}
//************************************************************************************************
	@Override
	public void setCustomPropertyList(List<List<String>>customProperties){
		this.customProperties=customProperties;
	}
//************************************************************************************************
	@Override
	@Transient
	@XmlTransient
	public List<List<String>> getCustomPropertyList(){
		return this.customProperties;
	}
//************************************************************************************************
	@Override
	public void setRevisionDescription(String revisionDescription) {
		this.revisionDescription=revisionDescription;
		
	}
//************************************************************************************************
	@Override
	@XmlTransient
	@Transient
	public String getRevisionDescription() {
		return this.revisionDescription;
	}
//************************************************************************************************
	@Override
	public void setIncludedPersistentValue(String columnName,
			Collection<DetailPersistentValueInfo> includedValues) {
		if(includedValues==null||includedValues.size()==0)return;
		if(this.includedPersistentValues==null){
			this.includedPersistentValues=new HashMap<String, Collection<DetailPersistentValueInfo>>();
		} 
		includedPersistentValues.put(columnName, includedValues);
	}
//************************************************************************************************
	@Override
	public Collection<DetailPersistentValueInfo> getIncludedPersistentValue(
			String columnName) {
		return includedPersistentValues!=null?includedPersistentValues.get(columnName):null;
	}
//************************************************************************************************
	protected boolean isInitialized(Object mappedProperty, String propertyName){
		return mappedProperty!=null&&(
				!HibernateProxy.class.isInstance( mappedProperty)||
				(HibernateProxy.class.isInstance(mappedProperty)&&
				!((HibernateProxy)mappedProperty).getHibernateLazyInitializer().isUninitialized()));
	}
//************************************************************************************************
	

}
