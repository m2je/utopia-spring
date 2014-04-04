package com.utopia.core.security.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.utopia.core.model.CoAppRefreshToken;

public interface CoAppRefreshTokenDAO extends JpaRepository<CoAppRefreshToken, Long>{

	@Query("SELECT CoAppRefreshToken FROM CoAppRefreshToken CoAppRefreshToken WHERE CoAppRefreshToken.refreshToken=:token")
	public CoAppRefreshToken findByToken(@Param("token") String token);
	
	@Query("DELETE FROM CoAppRefreshToken CoAppRefreshToken WHERE CoAppRefreshToken.refreshToken=:token")
	public void deleteByToken(@Param("token")String token);
}
