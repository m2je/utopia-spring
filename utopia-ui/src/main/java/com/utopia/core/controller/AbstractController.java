package com.utopia.core.controller;

import com.utopia.core.model.Application;
import com.utopia.core.model.User;

public abstract class AbstractController {

	protected User getCurrentUser(){
		return new User();
	}
	
	protected Application getCurrentApplication(){
		return new Application();
	}
	
	
}
