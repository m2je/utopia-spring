package com.utopia.core.api;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.utopia.core.security.model.CoUsecase;
import com.utopia.core.usecase.UsecaseService;

@Controller
@RequestMapping("/api")
public class GeneralController extends AbstractAPIContreoller{
	
	@Resource
	private UsecaseService usecaseService;
	@RequestMapping(value="/{usecase}",method=RequestMethod.GET)
	@ResponseBody
	public  CoUsecase  usecases(@PathVariable CoUsecase usecase){
		
		return null;
	}
	
	
}
