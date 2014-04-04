package com.utopia.core.lookup;

import java.io.Serializable;
import java.util.Map;

public class Condition implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3978594009261292320L;
	protected String condition;
	protected boolean andWithPreviousCondition=true;
	public  Condition(String condition){
		this.condition=condition;
	}
//********************************************************************************
	public  Condition(String condition,boolean andWithPreviousCondition, Map<String,Object>context){
		this.condition=condition;
		this.andWithPreviousCondition=andWithPreviousCondition;
	}

//********************************************************************************	
	public String getCondition(){
		return condition;
	}
//********************************************************************************	
	public String toString(){
		return condition==null?"":condition;
	}
//*******************************************************************************
	public void setCondtionString(String condition){
		this.condition=condition;
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
