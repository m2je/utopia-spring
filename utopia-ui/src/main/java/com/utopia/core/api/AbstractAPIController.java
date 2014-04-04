package com.utopia.core.api;

import java.beans.PropertyEditorSupport;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import com.utopia.core.security.model.CoUsecase;
import com.utopia.core.security.model.CoUser;
import com.utopia.core.usecase.UsecaseService;
import com.utopia.security.oauth.UtopiaAuthenticationInfo;

public abstract class AbstractAPIController {
	private static Logger logger=Logger.getLogger(AbstractAPIController.class);
	private static final String FULL_USECASE_NAME_PATTERN="([A-Z][a-z])([A-Z][a-z])([A-Z][a-zA-Z]+)";
	private Pattern usecasePattern=Pattern.compile(FULL_USECASE_NAME_PATTERN);
	@Resource
	private UsecaseService service;
	@InitBinder 
    protected void initBinder(WebDataBinder binder) throws Exception {
        binder.registerCustomEditor(CoUsecase.class, new PropertyEditorSupport(){
			@Override
			public void setAsText(String text) throws IllegalArgumentException {
				if(text!=null&&text.trim().length()>0){
					String []parsedUsecase= parseUsecaseName(text);
					if(parsedUsecase!=null){
						super.setValue(service.findUsecase(parsedUsecase[0], parsedUsecase[1], parsedUsecase[2]));
					}else{
						
					}
				}
				
			}
        	
        });
    }
	
	protected String[] parseUsecaseName(String name){
		if(FULL_USECASE_NAME_PATTERN.matches(name)){
			try {
				Matcher m= usecasePattern.matcher(name);
				if(m.find()){
					return	new String[]{m.group(1),m.group(2),m.group(3)};
				}
			} catch (Exception e) {
				if(logger.isDebugEnabled())
					logger.debug(e);
			}
		}
		return null;
	}
	protected CoUser getCurrentUser(){
		UtopiaAuthenticationInfo info= (UtopiaAuthenticationInfo)SecurityContextHolder.getContext().getAuthentication();
		return info.getUser();
	}
}
