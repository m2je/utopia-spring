package com.utopia.core.api;

import java.util.List;

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
public class GeneralController {
	
	@Resource
	private UsecaseService usecaseService;
	@RequestMapping(value="/{usecase}",method=RequestMethod.GET)
	@ResponseBody
	public  List<CoUsecase>  usecases(@PathVariable String usecase){
		
		return usecaseService.findAllUsecases();
	}
}
