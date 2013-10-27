package com.utopia.core.lookup;

import java.io.Serializable;

import com.utopia.core.util.logic.AnnotationUtil;


public class LookupInfo implements Cloneable, Serializable{
	private static final long serialVersionUID = 6942802029007615229L;

	private Class<?> lookupClass;
	private Object lookupValue;
	private String columnName;
	
	public String getColumnName() {
		return columnName;
	}
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	public Class<?> getLookupClass() {
		return lookupClass;
	}
	public void setLookupClass(Class<?> lookupClass) {
		this.lookupClass = lookupClass;
	}
	public Object getLookupValue() {
		return lookupValue;
	}
	public void setLookupValue(Object lookupValue) {
		this.lookupValue = lookupValue;
	}
	public LookupInfo(Class<?> lookupClass, Object lookupValue) {
		this(AnnotationUtil.getFieldName(lookupClass.getSimpleName()),
				lookupClass,lookupValue);
		
	}
	public LookupInfo(String columnName, Class<?> lookupClass, Object lookupValue) {
		this.lookupClass = lookupClass;
		this.lookupValue = lookupValue;
		this.columnName=columnName;
	}
	public LookupInfo clone(){
		try {
			return (LookupInfo)super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}
}
