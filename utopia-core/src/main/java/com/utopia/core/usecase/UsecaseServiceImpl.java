package com.utopia.core.usecase;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.utopia.core.model.CoUsecase;
import com.utopia.core.service.AbstractUtopiaService;
@Component
public class UsecaseServiceImpl extends AbstractUtopiaService implements UsecaseService{

	@Resource
	private UsecaseDAO DAO;
	
	public List<CoUsecase> findAllUsecases(){
		return DAO.findUsecases();
	}

	@Override
	public CoUsecase findById(Long id) {
		return DAO.findOne(id);
	}
	
	public CoUsecase findUsecase(String systemName,String subSystemName,String usecaseName){
		return DAO.findUsecase(systemName, subSystemName, usecaseName);
	}

	@Override
	public List<UseCase> getUseCasesConfiguration() {
		
		return null;
	}

	@Override
	public CoUsecase findUsecase(String usecaseName) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
