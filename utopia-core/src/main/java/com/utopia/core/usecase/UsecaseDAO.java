package com.utopia.core.usecase;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.utopia.common.model.Subsystem;
import com.utopia.core.dao.UtopiaDAO;
import com.utopia.core.model.Usecase;

public interface UsecaseDAO extends UtopiaDAO,JpaRepository<Usecase, Long> {

	@Query("SELECT Usecase FROM Usecase Usecase WHERE Usecase.deleted=FALSE")
	public List<Usecase> findUsecases();
	
	@Query("SELECT Usecase FROM Usecase Usecase WHERE Usecase.deleted=FALSE AND Usecase.name=:usecaseName"
			+" AND (Usecase.subsystem.name=:subSystemName OR Usecase.subsystem.abbreviation=:subSystemName) AND Usecase.subsystem.deleted=FALSE  "
			+" AND (Usecase.subsystem.system.name=:systemName OR Usecase.subsystem.abbreviation=:systemName )AND Usecase.subsystem.system.deleted=FALSE")
	public Usecase findUsecase(@Param("systemName") String systemName,@Param("subSystemName") String subSystemName,@Param("usecaseName") String usecaseName);
	
	@Query("SELECT Usecase FROM Usecase Usecase WHERE Usecase.deleted=FALSE AND Usecase.name=:usecaseName"
			+ " AND Usecase.subsystem IN(:subsystems)"
			+ " ORDER BY Usecase.name")
	public Usecase findUsecase(@Param("usecaseName") String usecaseName,@Param("subsystems") List<Subsystem> subsystems);
}
