package com.utopia.core.util;

public enum DatabseType {
	Oracle("SELECT SYSDATE FROM DUAL"),MS_SQL("SELECT CURRENT_TIMESTAMP"),MySQL("SELECT NOW()");
	String timeQuery;
	DatabseType(String timeQuery){
		this.timeQuery=timeQuery;
				
	}
}
