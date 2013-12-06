package com.utopia.core.user;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.utopia.core.AbstractUtopiaTestCase;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/core-test.xml")
public class TestUser extends AbstractUtopiaTestCase{

	
	
	@Test
	public void test(){
		try{
			UserCollectionResult result=restTemplate.getForEntity(serverURL+"/users", UserCollectionResult.class).getBody();
			}catch(Exception e){
				e.printStackTrace();
			}
	}
}
