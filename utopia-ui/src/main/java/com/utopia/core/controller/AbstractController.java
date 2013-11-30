package com.utopia.core.controller;

import com.utopia.core.security.model.CoApplication;
import com.utopia.core.security.model.CoUser;

public abstract class AbstractController {

	protected CoUser getCurrentUser(){
		return new CoUser();
	}
	
	protected CoApplication getCurrentApplication(){
		return new CoApplication();
	}
	
	
}
