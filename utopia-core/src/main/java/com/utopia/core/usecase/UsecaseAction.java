package com.utopia.core.usecase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.utopia.core.constants.Constants.predefindedActions;

public class UsecaseAction {
	private long usecaseActionId;
	private long actionId;
	private String methodName;
	private String actionName;
	private List<ActionParameter> parameters=new ArrayList<ActionParameter>();
	public UsecaseAction(long usecaseActionId,long actionId,String actionName,String methodName, List<ActionParameter> parameters) {
		super();
		this.actionName=actionName;
		this.usecaseActionId=usecaseActionId;
		this.actionId=actionId;
		this.methodName = methodName;
		this.parameters = parameters;
	} 
	public UsecaseAction(long actionId,String actionName,String methodName){
		this.actionName=actionName;
		this.methodName=methodName;
		this.actionId=actionId;
	}
	public String getMethodName() {
		return methodName;
	}
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	public List<ActionParameter> getParameters() {
		if(parameters!=null){
			 Collections.sort(parameters, new Comparator<ActionParameter>(){
			public int compare(ActionParameter o1, ActionParameter o2) {
					return 0;
				}}) ;
		 }
		 return parameters;
	}
	public void setParameters(List<ActionParameter> parameters) {
		this.parameters = parameters;
	}
	public void addParameter(ActionParameter param){
		parameters.add(param);
	} 
	public void removeParameter(ActionParameter param){
		parameters.remove(param);
	}
	public long getActionId() {
		return actionId;
	}
	public void setActionId(long actionId) {
		this.actionId = actionId;
	}
	public long getUsecaseActionId() {
		return usecaseActionId;
	}
	public void setUsecaseActionId(long usecaseActionId) {
		this.usecaseActionId = usecaseActionId;
	}
	public String getActionName() {
		return actionName;
	}
	public void setActionName(String actionName) {
		this.actionName = actionName;
	}
	
	public predefindedActions getPredefindAction(){
		return predefindedActions.getAction(actionName);
	}
}
