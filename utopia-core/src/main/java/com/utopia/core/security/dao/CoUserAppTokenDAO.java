package com.utopia.core.security.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.utopia.core.model.CoUserAppToken;

public interface CoUserAppTokenDAO extends JpaRepository<CoUserAppToken, Long> {
	
	@Query("SELECT CoUserAppToken FROM CoUserAppToken CoUserAppToken WHERE CoUserAppToken.token=:token ")
	public CoUserAppToken findByToken(@Param("token") String token);
	
	@Query("SELECT CoUserAppToken FROM CoUserAppToken CoUserAppToken WHERE CoUserAppToken.refreshToken=:refreshToken ")
	public CoUserAppToken findByRefreshToken(@Param("refreshToken") String refreshToken); 
	
	@Query("SELECT CoUserAppToken FROM CoUserAppToken CoUserAppToken WHERE CoUserAppToken.coUser.id=:userId "
			+ "AND CoUserAppToken.coApplication.name=:applicationName ")
	public CoUserAppToken findByUserApplication(@Param("userId") Long userId,@Param("applicationName") String applicationName);
	
	@Transactional
	@Modifying
	@Query("DELETE FROM CoUserAppToken CoUserAppToken WHERE CoUserAppToken.token=:token ")
	public void deleteToken(@Param("token") String token);
	
	@Transactional
	@Modifying
	@Query("DELETE FROM CoUserAppToken CoUserAppToken WHERE CoUserAppToken.refreshToken=:refreshToken ")
	public void deleteTokenByRefreshToken(@Param("refreshToken") String refreshToken);
	
	@Query("SELECT CoUserAppToken FROM CoUserAppToken CoUserAppToken WHERE CoUserAppToken.coUser.username=:username AND CoUserAppToken.coUser.coPortal.domainName=:portalDomain ")
	public List<CoUserAppToken> findTokensForUser(@Param("username")String username,@Param("portalDomain") String portalDomain);
	
	@Query("SELECT CoUserAppToken FROM CoUserAppToken CoUserAppToken WHERE CoUserAppToken.coApplication.name=:applicationName")
	public List<CoUserAppToken> findApplicationTokens(@Param("applicationName")String applicationName);
}
