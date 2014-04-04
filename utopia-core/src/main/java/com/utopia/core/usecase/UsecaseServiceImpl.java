package com.utopia.core.usecase;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.utopia.core.model.Usecase;
import com.utopia.core.service.AbstractUtopiaService;
@Component
public class UsecaseServiceImpl extends AbstractUtopiaService implements UsecaseService{

	@Resource
	private UsecaseDAO DAO;
	
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

	@Override
	public Usecase findUsecase(String usecaseName) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
