package com.utopia.core.user;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jasypt.exceptions.EncryptionOperationNotPossibleException;
import org.jasypt.hibernate4.encryptor.HibernatePBEStringEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/core-test.xml")
@TransactionConfiguration(defaultRollback=false)
public class EncryptPasswords {

	@PersistenceContext
	EntityManager entityManager;
	
	@Resource(name="UtopiaHibernateStringEncryptor")
	HibernatePBEStringEncryptor encryptor;
	@Test
	@Transactional
	public void encryptPasswords(){
		 List<Object[]> idsAndPass= entityManager.createNativeQuery("SELECT id,password FROM CO_USER").getResultList();
		 for (Object o[]:idsAndPass){
			 try {
				encryptor.decrypt((String)o[1]);
			} catch (EncryptionOperationNotPossibleException e) {
				String encryptedPassword= encryptor.encrypt((String)o[1]);
				entityManager.createNativeQuery("UPDATE CO_USER SET password=:password WHERE id=:id").
				setParameter("password", encryptedPassword).setParameter("id", o[0]).executeUpdate();
			}
			 
		 }
		 
	}
}
