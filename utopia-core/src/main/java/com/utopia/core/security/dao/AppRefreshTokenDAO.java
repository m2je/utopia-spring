package com.utopia.core.security.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.utopia.core.model.AppRefreshToken;

public interface AppRefreshTokenDAO extends JpaRepository<AppRefreshToken, Long>{

	@Query("SELECT AppRefreshToken FROM AppRefreshToken AppRefreshToken WHERE AppRefreshToken.refreshToken=:token")
	public AppRefreshToken findByToken(@Param("token") String token);
	
	@Query("DELETE FROM AppRefreshToken AppRefreshToken WHERE AppRefreshToken.refreshToken=:token")
	public void deleteByToken(@Param("token")String token);
}
