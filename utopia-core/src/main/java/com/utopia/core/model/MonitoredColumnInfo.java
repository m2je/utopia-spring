package com.utopia.core.model;

public class MonitoredColumnInfo {

	public static final String MONITORED_COLUMNS_CONTEXT_KEYS="__COLUMNS_TO_MONITOR";
	String column;
	Object oldValue;
	Object newValue;
	DataUpdateVerifier verifier;
	public MonitoredColumnInfo(){
		
	}
	
	public MonitoredColumnInfo(String column,Object oldValue,Object newValue){
		this.column=column;
		this.oldValue=oldValue;
		this.newValue=newValue;
	}
	
	public String getColumn() {
		return column;
	}
	public void setColumn(String column) {
		this.column = column;
	}
	public Object getOldValue() {
		return oldValue;
	}
	public void setOldValue(Object oldValue) {
		this.oldValue = oldValue;
	}
	public Object getNewValue() {
		return newValue;
	}
	public void setNewValue(Object newValue) {
		this.newValue = newValue;
	}

	public DataUpdateVerifier getVerifier() {
		return verifier;
	}

	public void setVerifier(DataUpdateVerifier verifier) {
		this.verifier = verifier;
	}

	public void verify()throws Exception{
		if(verifier!=null){
			verifier.verify(oldValue, newValue);
		}
	}
}
