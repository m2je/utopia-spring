package com.utopia.core.model;


import javax.persistence.PostRemove;

import org.apache.log4j.Logger;

public class CustomPropertyListener {

private static final Logger logger;
	
	static {
		logger = Logger.getLogger(CustomPropertyListener.class);
	}
	@PostRemove
	public void cascadeCustomPropertyDelete(UtopiaBasicPersistent p) {
		//TODO implement this
//		if(p!=null){
//		try {
//			Class<?> remoteClass =BeanUtil.findRemoteClassFromPersistent(p.getClass());
//			UseCase usecase= UsecaseUtil.getUseCase(remoteClass.getName());
//			CoCustomPropertyFacadeRemote attachmentFacase=(CoCustomPropertyFacadeRemote)ServiceFactory.lookupFacade(CoCustomPropertyFacadeRemote.class);
//			attachmentFacase.deleteCustomProperties(usecase.getUsecaseId(), p.getRecordId());
//		} catch (Throwable e) {
//			logger.log(Level.WARNING,"fail to find and delete custom properties of class:"+p.getClass()+" and recordId:"+p.getRecordId(),e);
//		}
//		}
	}
}
