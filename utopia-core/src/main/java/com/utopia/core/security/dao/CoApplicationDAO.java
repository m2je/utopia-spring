package com.utopia.core.security.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.utopia.core.dao.UtopiaDAO;
import com.utopia.core.security.model.CoApplication;

public interface CoApplicationDAO extends JpaRepository<CoApplication, Long> ,UtopiaDAO{
	
	@Query("SELECT CoApplication FROM CoApplication CoApplication LEFT JOIN FETCH CoApplication.coAppUscsAccsses WHERE CoApplication.name=:name AND CoApplication.deleted=FALSE")
	public CoApplication findApplicationWithName(@Param("name") String name);
}
