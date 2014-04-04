package com.utopia.core.security.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.utopia.core.model.CoUser;

public interface UserDAO extends JpaRepository<CoUser, Long>{

	@Query("SELECT CoUser FROM CoUser CoUser JOIN FETCH CoUser.coPortal CoPortal JOIN FETCH CoUser.coUserRoleses roles"
			+ " WHERE CoUser.username=:username AND CoPortal.domainName=:domainName AND CoPortal.deleted=FALSE AND CoUser.deleted=FALSE ")
	public CoUser findByUsername(@Param("username") String username ,@Param("domainName") String domainName);
}
