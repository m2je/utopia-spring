package com.utopia.core.util;

import java.util.List;
import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.config.AbstractFactoryBean;
import org.springframework.stereotype.Service;
@Service
public class UtopiaPropertiesFactoryBean extends  AbstractFactoryBean<Properties>{
	
	private List<String> systemNames;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	
	

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
		return result;
	}

	@Override
	public Class<?> getObjectType() {
		
		return Properties.class;
	}

}
