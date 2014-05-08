package com.utopia.core.security.dao;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.utopia.core.model.User;

public interface UserDAO extends JpaRepository<User, Long>{

	@Cacheable(value="__username",key="username.concat('@').concat(domainname)")
	@Query("SELECT User FROM User User JOIN User.portal Portal LEFT JOIN FETCH User.userRoles roles"
			+ " WHERE User.username=:username AND Portal.domainName=:domainName AND Portal.deleted=FALSE AND User.deleted=FALSE ")
	public User findByUsername(@Param("username") String username ,@Param("domainName") String domainName);
}
