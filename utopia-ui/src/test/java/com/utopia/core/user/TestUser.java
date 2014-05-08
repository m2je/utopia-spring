package com.utopia.core.user;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.utopia.core.AbstractUtopiaTestCase;
import com.utopia.core.model.annotations.LookupConfiguration;
import com.utopia.core.security.dao.UserDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/core-test.xml")
public class TestUser extends AbstractUtopiaTestCase{

	@Resource
	private UserDAO userDAO;
	
	@PersistenceContext
	EntityManager entityManager;
	@Test
	@LookupConfiguration
	public void test(){
		try{
			UserCollectionResult result=restTemplate.getForEntity(serverURL+"/users", UserCollectionResult.class).getBody();
			System.out.println(result);
			}catch(Exception e){
				e.printStackTrace();
				throw e;
			}
	}
	
	}
