package com.utopia.core.usecase;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.utopia.core.dao.UtopiaDAO;
import com.utopia.core.security.model.CoUsecase;

public interface UsecaseDAO extends UtopiaDAO,JpaRepository<CoUsecase, Long> {

	@Query("SELECT CoUsecase FROM CoUsecase CoUsecase WHERE CoUsecase.deleted=FALSE")
	public List<CoUsecase> findActiveUsecases();
	
	@Query("SELECT CoUsecase FROM CoUsecase CoUsecase WHERE CoUsecase.deleted=FALSE AND CoUsecase.name=:usecaseName"
			+" AND (CoUsecase.cmSubsystem.name=:subSystemName OR CoUsecase.cmSubsystem.abbreviation=:subSystemName) AND CoUsecase.cmSubsystem.deleted=FALSE  "
			+" AND (CoUsecase.cmSubsystem.cmSystem.name=:systemName OR CoUsecase.cmSubsystem.abbreviation=:systemName )AND CoUsecase.cmSubsystem.cmSystem.deleted=FALSE")
	public CoUsecase findActiveUsecase(@Param("systemName") String systemName,@Param("subSystemName") String subSystemName,@Param("usecaseName") String usecaseName);
}
