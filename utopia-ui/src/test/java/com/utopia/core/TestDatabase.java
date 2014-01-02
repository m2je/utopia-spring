package com.utopia.core;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.utopia.core.security.dao.CoUserAppTokenDAO;
import com.utopia.core.security.model.CoUserAppToken;

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
//	@Transactional
	public void testQuery(){
		appTokenDAO.deleteToken("hasan");
//		en.createQuery("SELECT CURRENT_TIMESTAMP()").getSingleResult();
		
	}
}
