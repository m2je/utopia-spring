package com.utopia.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.utopia.core.api.AbstractAPIContreoller;
import com.utopia.core.model.CollectionResult;
import com.utopia.core.security.model.CoUser;

//@Controller
//@RequestMapping("/api")
public class UserController extends AbstractAPIContreoller{
	
//	@RequestMapping(value="/users")
	public CollectionResult<CoUser> getUsers(){
		return null;//	SecurityContextHolder.getContext()
	}
}
