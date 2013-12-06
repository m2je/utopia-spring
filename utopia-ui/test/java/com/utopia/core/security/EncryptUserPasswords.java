package com.utopia.core.security;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.jasypt.encryption.pbe.PBEStringEncryptor;
import org.jasypt.hibernate4.encryptor.HibernatePBEStringEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/core-test.xml")
public class EncryptUserPasswords {
	private static Logger logger=Logger.getLogger(EncryptUserPasswords.class.getSimpleName()); 
	@Resource
	private HibernatePBEStringEncryptor utopiaHibernateStringEncryptor;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Test
	@Modifying
	@Transactional
	@Rollback(false)
	public void doEncrypt(){
		try {
			List<Object[]>users= entityManager.createNativeQuery("SELECT co_user_Id,username,password FROM CO_USER ").getResultList();
			PBEStringEncryptor encryptor= utopiaHibernateStringEncryptor.getEncryptor();
			Query updateQuery= entityManager.createNativeQuery("UPDATE CO_USER SET password=? WHERE co_user_id=?");
			for(Object [] user:users){
				try {
					updateQuery.setParameter(1, encryptor.encrypt((String)user[2])).setParameter(2, user[0]) ;
					updateQuery.executeUpdate();
				} catch (Exception e) {
						logger.log(Level.INFO,"fail to decrypt password ==> "+(String)user[2],e);
					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
	}
	
}
