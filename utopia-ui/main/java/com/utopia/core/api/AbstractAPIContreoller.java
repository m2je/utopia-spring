package com.utopia.core.api;

import java.beans.PropertyEditorSupport;

import javax.annotation.Resource;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import com.utopia.common.systems.CmSubsystem;
import com.utopia.common.systems.CmSystem;
import com.utopia.core.security.model.CoUsecase;
import com.utopia.core.security.model.CoUser;
import com.utopia.core.usecase.UsecaseService;
import com.utopia.security.oauth.UtopiaAuthenticationInfo;

public abstract class AbstractAPIContreoller {
	
	@Resource
	private UsecaseService service;
	@InitBinder 
    protected void initBinder(WebDataBinder binder) throws Exception {
        binder.registerCustomEditor(CoUsecase.class, new PropertyEditorSupport(){
			@Override
			public void setAsText(String text) throws IllegalArgumentException {
				String system=text.substring(0, CmSystem.ABBRIVIATION_LENGHT);
				String subSystem=text.substring(CmSystem.ABBRIVIATION_LENGHT, CmSubsystem.ABBRIVIATION_LENGHT);
				String usecase=text.substring(CmSystem.ABBRIVIATION_LENGHT+CmSubsystem.ABBRIVIATION_LENGHT, CmSystem.ABBRIVIATION_LENGHT);
				super.setValue(service.findUsecase(system, subSystem, usecase));
			}
        	
        });
    }
	
	protected CoUser getCurrentUser(){
		UtopiaAuthenticationInfo info= (UtopiaAuthenticationInfo)SecurityContextHolder.getContext().getAuthentication();
		return info.getUser();
	}
}
