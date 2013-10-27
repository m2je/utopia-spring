package com.utopia.core.usecase;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.utopia.core.dao.UtopiaDAO;
import com.utopia.core.security.model.CoUsecase;

public interface UsecaseDAO extends UtopiaDAO,JpaRepository<CoUsecase, Long> {

	@Query("SELECT CoUsecase FROM CoUsecase CoUsecase WHERE CoUsecase.deleted=FALSE")
	public List<CoUsecase> findActiveUsecases();
}
