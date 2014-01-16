package com.utopia.core.usecase;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class UseCase {

	Logger logger = Logger.getLogger(UseCase.class.getName());
	
	private String remoteClassName;
	private long usecaseId;
	private long systemId;
	private long subSystemId;
	private String name;
	private String fullName;
	private List<UsecaseAction> useCaseActions=new ArrayList<UsecaseAction>();
	private boolean hasPersistentClass=true;
	Class<?> persistentClass;
	public String getRemoteClassName() {
		return remoteClassName;
	}
//*****************************************************************************************************	
	public  UseCase(long usecaseId,String name,String fullName,String remoteClassName,List<UsecaseAction> useCaseActions) {
		this.useCaseActions=useCaseActions;
		this.remoteClassName = remoteClassName;
		this.usecaseId=usecaseId;
		this.name=name;
		this.fullName=fullName;
	}
//*****************************************************************************************************
	public UseCase(String remoteClassName) {
		this.remoteClassName = remoteClassName;
	}
//*****************************************************************************************************
	public void setRemoteClassName(String remoteClassName) {
		this.remoteClassName = remoteClassName;
	}
//*****************************************************************************************************	
	public List<UsecaseAction> getUseCaseActions() {
		return useCaseActions;
	}
//*****************************************************************************************************
	public void setUseCaseActions(List<UsecaseAction> useCaseActions) {
		this.useCaseActions = useCaseActions;
	}
//*****************************************************************************************************
	public void addAction(UsecaseAction action){
		useCaseActions.add(action);
	}
//*****************************************************************************************************	
	public long getUsecaseId() {
		return usecaseId;
	}
//*****************************************************************************************************
	public void setUsecaseId(long usecaseId) {
		this.usecaseId = usecaseId;
	}
//*****************************************************************************************************	 
	public long getSystemId() {
		return systemId;
	}
//*****************************************************************************************************	
	public void setSystemId(long systemId) {
		this.systemId = systemId;
	}
//*****************************************************************************************************
	public long getSubSystemId() {
		return subSystemId;
	}
//*****************************************************************************************************
	public void setSubSystemId(long subSystemId) {
		this.subSystemId = subSystemId;
	}
//*****************************************************************************************************
	public String getName() {
		return name;
	}
//*****************************************************************************************************
	public void setName(String name) {
		this.name = name;
	}
//*****************************************************************************************************
	public String getFullName() {
		return fullName;
	}
//*****************************************************************************************************
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
//*****************************************************************************************************
	public UsecaseAction  getUsecaseAction(String actionName){
		if(useCaseActions!=null){
			for(UsecaseAction act: useCaseActions){
				if(act.getMethodName().equals(actionName)){
					return act;
				}
			}
		}
		return null;
	}
//*****************************************************************************************************
	public Class<?> getPersistentClass(){
		if(persistentClass!=null)return persistentClass;
//		if(hasPersistentClass){
//			try {
//				persistentClass = ((UtopiaBasicUsecaseBean<?, ?>) ServiceFactory.lookupFacade(getRemoteClassName())).getPersistentClass();
//			} catch (Exception e) {
//				if(logger.isLoggable(Level.FINE)){
//					logger.log(Level.FINE,"",e) ;
//				}
//				hasPersistentClass=false;
//			}
//		}
		return persistentClass;
	}
//*****************************************************************************************************
}
