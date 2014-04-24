package com.utopia.core.usecase;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.utopia.common.model.Subsystem;
import com.utopia.core.model.Portal;
import com.utopia.core.model.Usecase;
import com.utopia.core.security.dao.PortalSysAccssDAO;
import com.utopia.core.service.AbstractUtopiaService;
@Component
public class UsecaseServiceImpl extends AbstractUtopiaService implements UsecaseService{

	@Resource
	private UsecaseDAO DAO;
	
	@Resource
	private PortalSysAccssDAO protalAccessDAO;
	
	public List<Usecase> findAllUsecases(){
		return DAO.findUsecases();
	}

	@Override
	public Usecase findById(Long id) {
		return DAO.findOne(id);
	}
	
	public Usecase findUsecase(String systemName,String subSystemName,String usecaseName){
		return DAO.findUsecase(systemName, subSystemName, usecaseName);
	}

	@Override
	public List<UseCase> getUseCasesConfiguration() {
		
		return null;
	}
	
	@Cacheable(value="__usecase_names", key="usecaseName.concat(porta.id)")
	@Override
	public Usecase findUsecase(String usecaseName,Portal portal) {
		List<Subsystem>accessibleSubsystems= protalAccessDAO.getAccessibleSubSystem(portal.getId());
		return DAO.findUsecase(usecaseName,accessibleSubsystems);
	}
	
	
}
