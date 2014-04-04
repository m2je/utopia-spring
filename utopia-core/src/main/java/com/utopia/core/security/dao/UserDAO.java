package com.utopia.core.security.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.utopia.core.model.User;

public interface UserDAO extends JpaRepository<User, Long>{

	@Query("SELECT User FROM User User JOIN FETCH User.portal Portal JOIN FETCH User.userRoleses roles"
			+ " WHERE User.username=:username AND Portal.domainName=:domainName AND Portal.deleted=FALSE AND User.deleted=FALSE ")
	public User findByUsername(@Param("username") String username ,@Param("domainName") String domainName);
}
