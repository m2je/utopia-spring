package com.utopia.core.security.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.utopia.core.model.UserAppToken;

public interface UserAppTokenDAO extends JpaRepository<UserAppToken, Long> {
	
	@Query("SELECT UserAppToken FROM UserAppToken UserAppToken WHERE UserAppToken.token=:token ")
	public UserAppToken findByToken(@Param("token") String token);
	
	@Query("SELECT UserAppToken FROM UserAppToken UserAppToken WHERE UserAppToken.refreshToken=:refreshToken ")
	public UserAppToken findByRefreshToken(@Param("refreshToken") String refreshToken); 
	
	@Query("SELECT UserAppToken FROM UserAppToken UserAppToken WHERE UserAppToken.user.id=:userId "
			+ "AND UserAppToken.application.name=:applicationName ")
	public UserAppToken findByUserApplication(@Param("userId") Long userId,@Param("applicationName") String applicationName);
	
	@Transactional
	@Modifying
	@Query("DELETE FROM UserAppToken UserAppToken WHERE UserAppToken.token=:token ")
	public void deleteToken(@Param("token") String token);
	
	@Transactional
	@Modifying
	@Query("DELETE FROM UserAppToken UserAppToken WHERE UserAppToken.refreshToken=:refreshToken ")
	public void deleteTokenByRefreshToken(@Param("refreshToken") String refreshToken);
	
	@Query("SELECT UserAppToken FROM UserAppToken UserAppToken WHERE UserAppToken.user.username=:username AND UserAppToken.user.portal.domainName=:portalDomain ")
	public List<UserAppToken> findTokensForUser(@Param("username")String username,@Param("portalDomain") String portalDomain);
	
	@Query("SELECT UserAppToken FROM UserAppToken UserAppToken WHERE UserAppToken.application.name=:applicationName")
	public List<UserAppToken> findApplicationTokens(@Param("applicationName")String applicationName);
}
