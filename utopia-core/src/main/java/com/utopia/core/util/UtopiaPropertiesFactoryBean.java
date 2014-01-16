package com.utopia.core.util;

import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.config.AbstractFactoryBean;
import org.springframework.stereotype.Service;
@Service
public class UtopiaPropertiesFactoryBean extends  AbstractFactoryBean<Properties>{
	private static Logger logger=Logger.getLogger(UtopiaPropertiesFactoryBean.class);
	private List<String> systemNames;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	private Set<String>extendedProperties=new HashSet<String>();
	
	public UtopiaPropertiesFactoryBean(){
		extendedProperties.add("utopia");
	}
	
	public void setExtendedProperties(List<String> extendedProperties) {
		this.extendedProperties.addAll(extendedProperties);
	}

	public void setEntityManagerFactory(EntityManagerFactory entityManager) {
		this.entityManager = entityManager.createEntityManager();
	}

	public List<String> getSystemNames() {
		return systemNames;
	}

	public void setSystemNames(List<String> systemNames) {
		this.systemNames = systemNames;
	}

	
	@SuppressWarnings({  "unchecked" })
	@Override
	protected Properties createInstance() throws Exception {
		final Properties result=new Properties();
		List<CoSettings>settings= entityManager.createQuery("SELECT CoSettings FROM CoSettings CoSettings WHERE CoSettings.cmSystem.name IN (:systemNames)").
		 setParameter("systemNames", systemNames).getResultList();
		for(CoSettings setting:settings){
			result.put(setting.getKey(), setting.getValue());
		}
		for(String propertyFile:extendedProperties){
			overrideByProperty(propertyFile,result);
			}
		return  result;
	}
	/**
	 * override the properties from 
	 * @param result
	 */
	protected void overrideByProperty(String propertyFile,Properties result){
		try {
			ResourceBundle labels = ResourceBundle.getBundle(propertyFile);
			Enumeration<?> bundleKeys = labels.getKeys();

			while (bundleKeys.hasMoreElements()) {
			    String key = (String)bundleKeys.nextElement();
			    String value = labels.getString(key);
			    result.put(key, value);
			}
		} catch (Exception e) {
			logger.warn(e);
		}
	}
	
	@Override
	public Class<?> getObjectType() {
		
		return Properties.class;
	}

}
