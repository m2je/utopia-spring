package com.utopia.core.security.dao;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.utopia.common.model.Subsystem;
import com.utopia.core.model.PortalSysAccss;

public interface PortalSysAccssDAO extends JpaRepository<PortalSysAccss, Long>{
	
	@Cacheable(value="__portal_sys_accss",key="portalId")
	@Query("SELECT Subsystem FROM  Subsystem Subsystem WHERE ( "
			+ " Subsystem.id IN (SELECT PortalSysAccss.subsystem.id FROM  PortalSysAccss PortalSysAccss WHERE (PortalSysAccss.portal.id=:portalId OR :portalId=0) AND PortalSysAccss.subsystem.deleted=FALSE ) "
			+ " OR  Subsystem.id IN (SELECT subsystems.id FROM System System INNER JOIN System.subsystems subsystems INNER JOIN  System.portalAccss portalAccss  WHERE System.deleted=FALSE AND subsystems.deleted=FALSE AND (portalAccss.portal.id=:portalId OR :portalId=0) ) "
			+ " )"
			)
	public List<Subsystem> getAccessibleSubSystem(@Param("portalId") Long portalId);
}
