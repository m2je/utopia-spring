package com.utopia.core.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.utopia.core.model.CollectionResult;
import com.utopia.core.security.model.CoUser;

@Controller
public class UserController {
	
	@RequestMapping(value="/users")
	public CollectionResult<CoUser> getUsers(){
		return null;//	SecurityContextHolder.getContext()
	}
}
