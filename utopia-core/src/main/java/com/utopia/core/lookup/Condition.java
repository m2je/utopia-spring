package com.utopia.core.lookup;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.utopia.core.util.logic.LogicParser;
import com.utopia.core.util.logic.ParameterHandler;

public class Condition implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3978594009261292320L;
	protected String condition;
	private int javaParameterCounter=0;
	protected HashMap<String, Object>parameterMap;
	protected boolean lazyInitiaze=true;
	protected boolean andWithPreviousCondition=true;
	public  Condition(String condition){
		lazyInitiaze=true;
		this.condition=condition;
	}
//********************************************************************************	
	public  Condition(String condition, Map<String,Object>context){
		this(condition,true,context);
	}
//********************************************************************************
	public  Condition(String condition,boolean andWithPreviousCondition, Map<String,Object>context){
		this.condition=condition;
		this.andWithPreviousCondition=andWithPreviousCondition;
		initFromContext(context);
	}
//********************************************************************************	
	public void initFromContext(Map<String,Object>context){
		if(condition==null||condition.trim().length()==0)return;
		initParameters(condition, context);
		initJavaParameters(context);
	}
//********************************************************************************	
	private void initJavaParameters(Map<String,Object>context){
		List<String>javaParameters=LogicParser.getJavaParameters(condition);
		if(javaParameters!=null&&javaParameters.size()>0){
			for(String javaparam:javaParameters){
			  Object value= LogicParser.getJavaParameterValue(javaparam,context);
			  if(value!=null){
				  String key="Java"+javaParameterCounter++;
				  if(parameterMap==null){
					  parameterMap=new HashMap<String, Object>();
				  }
				  parameterMap.put(key, value);
				  condition= LogicParser.replaceJavaVariable(condition, javaparam, ":"+key);
			  }
			}
		}
	} 
//********************************************************************************
	private void initParameters(String condition, Map<String, Object> context) {
		List<String> parameters= LogicParser.getParametersInString(condition);
		if(parameters!=null&&parameters.size()>0){
			parameterMap=parameterMap==null?new HashMap<String, Object>():parameterMap;
			for(String key:parameters){                     
				parameterMap.put(key, context.get(key));
			}
			this.condition=LogicParser.
				getFlatExpression(condition, new ParameterHandler(){
					public Object getParameterValue(String parameterName) {
						return ":"+parameterName;
					}
					
				}) ;
		}else{
			this.condition=condition;
		}
	}
//********************************************************************************	
	public String getCondition(){
		return condition;
	}
//********************************************************************************	
	public String[] getParameters(){
		if(parameterMap!=null){
			return parameterMap.keySet().toArray(new String[parameterMap.size()]);
		}
		return new String[0];
	}
//********************************************************************************	
	public Object getParameterValue(String parameterName){
		if(parameterMap!=null){
			return parameterMap.get(parameterName);
		}
		return null;
	}
//********************************************************************************	
	public String toString(){
		return condition==null?"":condition;
	}
//*******************************************************************************
	public void setParameterValue(String param,Object value){
		if(parameterMap==null){
			parameterMap=new HashMap<String, Object>();
		}
		parameterMap.put(param, value);
	}
//*******************************************************************************
	public void setCondtionString(String condition){
		this.condition=condition;
		if(parameterMap!=null){
			initParameters(condition, parameterMap);
			initJavaParameters(parameterMap);
		}
		
	}
//*******************************************************************************
	public boolean isLazyInitCondition(){
		return lazyInitiaze;
	}
//*******************************************************************************
	public boolean isAndWithPreviousCondition() {
		return andWithPreviousCondition;
	}
//*******************************************************************************
	public void setAndWithPreviousCondition(boolean andWithPreviousCondition) {
		this.andWithPreviousCondition = andWithPreviousCondition;
	}
	
}
