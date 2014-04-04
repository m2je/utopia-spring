package com.utopia.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.utopia.core.api.AbstractAPIController;
import com.utopia.core.model.User;
import com.utopia.core.model.CollectionResult;

//@Controller
//@RequestMapping("/api")
public class UserController extends AbstractAPIController{
	
//	@RequestMapping(value="/users")
	public CollectionResult<User> getUsers(){
		return null;//	SecurityContextHolder.getContext()
	}
}
