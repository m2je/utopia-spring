package com.utopia.core.basicinformation.menu;

import javax.annotation.Resource;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;

import com.utopia.core.basicinformation.menu.model.CoMenu;
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
