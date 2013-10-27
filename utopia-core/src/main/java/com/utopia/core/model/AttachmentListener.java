package com.utopia.core.model;

import java.util.logging.Logger;

import javax.persistence.PostRemove;


public class AttachmentListener {
	private static final Logger logger;
	
	static {
		logger = Logger.getLogger(AttachmentListener.class.getName());
	}
	
	@PostRemove
	public void cascadeAttachmentsDelete(UtopiaBasicPersistent p) {
		//TODO implement this
//		if(p!=null){
//		try {
//			Class<?> remoteClass =BeanUtil.findRemoteClassFromPersistent(p.getClass());
//			UseCase usecase= UsecaseUtil.getUseCase(remoteClass.getName());
//			CoAttachmentFacadeRemote attachmentFacase=(CoAttachmentFacadeRemote)ServiceFactory.lookupFacade(CoAttachmentFacadeRemote.class);
//			attachmentFacase.deleteAttachments(usecase.getUsecaseId(), null, p.getRecordId());
//		} catch (Throwable e) {
//			logger.log(Level.WARNING,"fail to find and delete attachment of class:"+p.getClass()+" and recordId:"+p.getRecordId(),e);
//		}
//		}
	}
//**********************************************************************************************************	
	
}
