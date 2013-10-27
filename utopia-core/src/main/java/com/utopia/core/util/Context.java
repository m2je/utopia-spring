package com.utopia.core.util;

import java.util.Map;

import com.utopia.core.usecase.UseCase;

public class Context {

	Map<String,Object>context;
	String actionName;
	String methodName;
	UseCase usecase;
	Long actionId;
	
	public Context(Map<String,Object>context){
		this(context,null,null,null,null);
	}
	
	public Context(Map<String, Object> context, UseCase usecase,Long actionId, String actionName,
			String methodName) {
		super();
		this.context = context;
		this.actionName = actionName;
		this.methodName = methodName;
		this.usecase=usecase;
		this.actionId=actionId;
	}

	public Map<String, Object> getContextMap() {
		return context;
	}
	public void setContextMap(Map<String, Object> context) {
		this.context = context;
	}
	public String getActionName() {
		return actionName;
	}
	public void setActionName(String actionName) {
		this.actionName = actionName;
	}
	public String getMethodName() {
		return methodName;
	}
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public UseCase getUsecase() {
		return usecase;
	}

	public void setUsecase(UseCase usecase) {
		this.usecase = usecase;
	}

	public Long getActionId() {
		return actionId;
	}

	public void setActionId(Long actionId) {
		this.actionId = actionId;
	}
	
}
