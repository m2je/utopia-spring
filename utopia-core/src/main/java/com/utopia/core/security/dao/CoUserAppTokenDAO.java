package com.utopia.core.security.dao;

import javax.ws.rs.QueryParam;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.utopia.core.security.model.CoUserAppToken;

public interface CoUserAppTokenDAO extends JpaRepository<CoUserAppToken, Long> {
	@Query("SELECT CoUserAppToken FROM CoUserAppToken CoUserAppToken WHERE CoUserAppToken.token=:token ")
	public CoUserAppToken findByToken(@QueryParam("token") String token);
	
	@Query("DELETE FROM CoUserAppToken CoUserAppToken WHERE CoUserAppToken.token=:token ")
	public CoUserAppToken deleteToken(@QueryParam("token") String token);
	
}
