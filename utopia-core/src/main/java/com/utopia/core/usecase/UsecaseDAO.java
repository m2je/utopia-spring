package com.utopia.core.usecase;

import java.util.List;

import javax.ws.rs.QueryParam;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.utopia.core.dao.UtopiaDAO;
import com.utopia.core.security.model.CoUsecase;

public interface UsecaseDAO extends UtopiaDAO,JpaRepository<CoUsecase, Long> {

	@Query("SELECT CoUsecase FROM CoUsecase CoUsecase WHERE CoUsecase.deleted=FALSE")
	public List<CoUsecase> findActiveUsecases();
	
	@Query("SELECT CoUsecase FROM CoUsecase CoUsecase WHERE CoUsecase.deleted=FALSE AND CoUsecase.name=:usecaseName"
			+" AND (CoUsecase.cmSubsystem.name=:subsystemName OR CoUsecase.cmSubsystem.abbreviation=:subsystemName) AND CoUsecase.cmSubsystem.deleted=FALSE  "
			+" AND (CoUsecase.cmSubsystem.cmSystem.name=:systemName OR CoUsecase.cmSubsystem.abbreviation=:systemName )AND CoUsecase.cmSubsystem.cmSystem.deleted=FALSE")
	public CoUsecase findActiveUsecase(@QueryParam("systemName") String systemName,@QueryParam("subSystemName") String subSystemName,@QueryParam("usecaseName") String usecaseName);
}
