package com.utopia.core.security.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.utopia.core.dao.UtopiaDAO;
import com.utopia.core.model.Application;

public interface ApplicationDAO extends JpaRepository<Application, Long> ,UtopiaDAO{
	
	@Query("SELECT Application FROM Application Application LEFT JOIN FETCH Application.appUscsAccsses WHERE Application.name=:name AND Application.deleted=FALSE")
	public Application findApplicationWithName(@Param("name") String name);
}
