package com.utopia.core.usecase;

import java.util.List;

import com.utopia.core.model.CoUsecase;
import com.utopia.core.service.UtopiaService;

public interface UsecaseService extends UtopiaService {
	
	public List<CoUsecase> findAllUsecases();
	
	public CoUsecase findById(Long id);
	/**
	 * finds a usecase with fully qualified name
	 * @param systemName
	 * @param subSystemName
	 * @param usecaseName
	 * @return
	 */
	public CoUsecase findUsecase(String systemName,String subSystemName,String usecaseName);
	/**
	 * find a usecase by name 
	 * if there are more than one usecase with this name (with different subsytems)
	 * this method returns the first usecase that it can find so must be careful for duplicate method names 
	 * @param usecaseName
	 * @return
	 */
	public CoUsecase findUsecase(String usecaseName);
	/**
	 * 
	 * @return
	 */
	public List<UseCase> getUseCasesConfiguration();
}
