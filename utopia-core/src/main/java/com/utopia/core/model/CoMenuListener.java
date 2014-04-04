package com.utopia.core.model;

import javax.annotation.Resource;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;

import com.utopia.core.security.SecurityProvider;

public class CoMenuListener {

	@Resource
	private SecurityProvider securityProvider;
	@PostUpdate
	@PostRemove
	@PostPersist
	public void cleanMenuCache(CoMenu menu){
		securityProvider.notifyMenuUpdated();
	}
}
