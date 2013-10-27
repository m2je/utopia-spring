package com.utopia.core.usecase;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.utopia.core.security.model.CoUsecase;
import com.utopia.core.service.AbstractUtopiaService;
@Component
public class UtopiaServiceImpl extends AbstractUtopiaService implements UsecaseService{

	@Resource
	private UsecaseDAO DAO;
	
	public List<CoUsecase> findAllUsecases(){
		return DAO.findActiveUsecases();
	}
}
