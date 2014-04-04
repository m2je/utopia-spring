package com.utopia.core;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.utopia.common.model.CmBpartner;
import com.utopia.core.model.CoPortal;
import com.utopia.core.model.CoUser;
import com.utopia.core.security.dao.CoUserAppTokenDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/core-test.xml")
public class TestDatabase {

	@PersistenceContext
	private EntityManager en;
	@Resource
	private CoUserAppTokenDAO dao;
	
	@Resource
	private CoUserAppTokenDAO appTokenDAO;
	@Test
	@Transactional
	@Rollback
	public void testQuery(){
//		appTokenDAO.deleteToken("hasan");
		
		try {
			CoUser creator=new CoUser();
			creator.setId(0l);
			
			CmBpartner bpartner=new CmBpartner();
			bpartner.setName("dsdsd");
			bpartner.setSecondName("sss");
			bpartner.setCreatedby(creator);
			bpartner.setUpdatedby(creator);
			en.persist(bpartner);
			
			
			CoPortal portal=new CoPortal();
			portal.setId(0l);
			
			CoUser user=new CoUser();
			user.setUsername("sddsd");
			user.setPassword("blahblah");
			
			user.setCreatedby(creator);
			user.setUpdatedby(creator);
			user.setCoPortal(portal);
			user.setCmBpartner(bpartner);
			en.persist(user);
			en.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
