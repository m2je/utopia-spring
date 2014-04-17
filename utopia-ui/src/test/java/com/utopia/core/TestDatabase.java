package com.utopia.core;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jasypt.util.password.StrongPasswordEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.utopia.common.model.Bpartner;
import com.utopia.core.model.Portal;
import com.utopia.core.model.User;
import com.utopia.core.security.dao.UserAppTokenDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/core-test.xml")
public class TestDatabase {

	@PersistenceContext
	private EntityManager en;
	@Resource
	private UserAppTokenDAO dao;
	
	@Resource
	private UserAppTokenDAO appTokenDAO;
	@Test
	@Transactional
	@Rollback
	public void testQuery(){
//		appTokenDAO.deleteToken("hasan");
		
		try {
			User creator=new User();
			creator.setId(0l);
			
			Bpartner bpartner=new Bpartner();
			bpartner.setName("dsdsd");
			bpartner.setSecondName("sss");
			bpartner.setCreatedby(creator);
			bpartner.setUpdatedby(creator);
			en.persist(bpartner);
			
			
			Portal portal=new Portal();
			portal.setId(0l);
			
			User user=new User();
			user.setUsername("sddsd");
			user.setPassword("blahblah");
			
			user.setCreatedby(creator);
			user.setUpdatedby(creator);
			user.setPortal(portal);
			user.setBpartner(bpartner);
			en.persist(user);
			en.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String ...args){
		StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
		String encryptedPassword = passwordEncryptor.encryptPassword("s1st3m");
		System.out.println(encryptedPassword);
	}
}
