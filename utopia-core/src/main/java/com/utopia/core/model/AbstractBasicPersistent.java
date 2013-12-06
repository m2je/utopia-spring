package com.utopia.core.model;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlTransient;

import org.apache.commons.beanutils.MethodUtils;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.TypeDef;
import org.jasypt.hibernate4.type.EncryptedStringType;

import com.utopia.core.lookup.DetailPersistentValueInfo;
import com.utopia.core.lookup.LookupInfo;
import com.utopia.core.util.Cache;
import com.utopia.core.util.logic.AnnotationUtil;

@MappedSuperclass
@EntityListeners({AttachmentListener.class,CustomPropertyListener.class})
@TypeDef(
	    name="encryptedString", 
	    typeClass=EncryptedStringType.class, 
	    parameters= {
	        @Parameter(name="encryptorRegisteredName", value="UtopiaHibernateStringEncryptor")
	    }
	)
public abstract class  AbstractBasicPersistent implements UtopiaBasicPersistent{

private static final Logger logger;
	
	static {
		logger = Logger.getLogger(AbstractBasicPersistent.class.getName());
	}
	private static Cache<Class<?>, Method[]>PK_METHOD_CACHE=new Cache<Class<?>, Method[]>();
	private static final Object[] o=new Object[]{};
	private static final Class<?> []c=new Class<?>[]{};
	private List<LookupInfo> infos;
	private List<UtopiaAttachmentInfo> attachInfos;
	private List<List<String>> customProperties;
	private String revisionDescription;
	private HashMap<String,Collection<DetailPersistentValueInfo>>includedPersistentValues;
//************************************************************************************************
	@Transient
	@XmlTransient
	public Long getRecordId() {
		try {
			Method []method= findPrimaryKeyMethods(getClass());
			return (Long) method[0].invoke(this, o);
		} catch (Exception e) {
			logger.log(Level.ALL,"fail to invoke getRecordId",e);
		}
		return null;
	}
//************************************************************************************************
	public void setRecordId(Long recordId) {
		Method method=findSetIdMethod();
		if(method!=null){
			try {
				method.invoke(this, recordId);
			} catch (Exception e) {
				logger.log(Level.ALL,"fail to invoke setRecordId",e);
			}
		}
	}
//************************************************************************************************
	private Method findSetIdMethod(){
		Method []method=null;
		try {
			Class<?>clazz=	getClass();
			method= findPrimaryKeyMethods(clazz);
		} catch (Exception e) {
				logger.log(Level.ALL,"fail to invoke setRecordId", e);
				method=new Method[2];
		}
		return method[1];
	}
//************************************************************************************************
	private static Method[] findPrimaryKeyMethods(Class<?>clazz)throws Exception{
		if(!PK_METHOD_CACHE.containsKey(clazz)){
			Method []result=new Method[2];
			for(Method method: clazz.getMethods()){
				if(method.getAnnotation(Id.class)!=null){
					if(method.getName().startsWith("get")||method.getName().startsWith("is")){
						result[0]= method;	
						result[1]= clazz.getMethod(AnnotationUtil.getSetterMethodName(method.getName()), method.getReturnType()) ;
					}else{
						result[1]= method;	
						result[0]= MethodUtils.getAccessibleMethod(clazz, AnnotationUtil.getGettrFromSetterMethodName(method.getName()), c) ;
					}
					break;
				}
			}
			PK_METHOD_CACHE.put(clazz, result);
		}
		return PK_METHOD_CACHE.get(clazz);
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

}
