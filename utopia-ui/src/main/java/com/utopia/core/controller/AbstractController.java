package com.utopia.core.controller;

import com.utopia.core.model.CoApplication;
import com.utopia.core.model.CoUser;

public abstract class AbstractController {

	protected CoUser getCurrentUser(){
		return new CoUser();
	}
	
	protected CoApplication getCurrentApplication(){
		return new CoApplication();
	}
	
	
}
