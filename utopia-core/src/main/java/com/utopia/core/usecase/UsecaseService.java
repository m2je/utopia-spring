package com.utopia.core.usecase;

import java.util.List;

import com.utopia.core.security.model.CoUsecase;
import com.utopia.core.service.UtopiaService;

public interface UsecaseService extends UtopiaService {
	
	public List<CoUsecase> findAllUsecases();
	
	public CoUsecase findById(Long id);
	
	public CoUsecase findUsecase(String systemName,String subSystemName,String usecaseName);
}
