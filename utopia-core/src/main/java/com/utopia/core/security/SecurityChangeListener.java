package com.utopia.core.security;

import javax.annotation.Resource;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;

import com.utopia.core.model.UtopiaPersistent;

public class SecurityChangeListener {

	@Resource
	SecurityProvider securityProvider;
	
	@PostPersist
	@PostUpdate
	@PostRemove
	public void securityChanged(UtopiaPersistent persistent){
		securityProvider.notifyRoleUpdated(-1l);
		securityProvider.notifyUserUpdated(-1l);
	}
}
