package com.utopia.core.user;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestOperations;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/core-test.xml")
public class TestUser {

	@Resource
    protected RestOperations restTemplate;
	
	@Test
	public void test(){
		try{
//			restTemplate.getForEntity(url, responseType)delete();
			}catch(Exception e){
				e.printStackTrace();
			}
	}
}
