package com.utopia.core;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestOperations;

public abstract class AbstractUtopiaTestCase {

	@Value("${APIserver}")
	protected String serverURL;
	
	@Resource
    protected RestOperations restTemplate;
}
