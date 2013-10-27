package com.utopia.core.lookup;

import java.io.Serializable;

import com.utopia.core.metadata.EntityPair;

public class NamePair implements Comparable<Object>,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6793191309390702936L;
	String name;
	long key;
	EntityPair[] entityPair;
	String separator="-";
	Object[]values;
	int keyIndex;
	int descriptionColumnIndex;
	String description;
	public NamePair(EntityPair[]entityPair,Object[]values,String separator,int keyIndex){
		this(entityPair,values,separator,keyIndex,-1);
	}
	public NamePair(EntityPair[]entityPair,Object[]values,String separator,int keyIndex,int descriptionIndex){
		this.entityPair=entityPair;
		this.values=values;
		this.separator=separator;
		this.key=(Long)values[keyIndex];
		this.keyIndex=keyIndex;
		this.descriptionColumnIndex=descriptionIndex;
	}
	public NamePair(String name, long key) {
		super();
		this.name = name;
		this.key = key;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getKey() {
		return key;
	}
	public void setKey(long key) {
		this.key = key;
	}
	
	public String toString(){
		return name==null?values==null?"":values.toString():name;
	}
	
	@Override
	public int compareTo(Object o) {
		try{
			int ret = ((Long)this.getKey()).compareTo(((NamePair)o).getKey());
			return ret;
		}catch (Exception e) {
			return 1;
		}
	}
	public EntityPair[] getEntityPair() {
		return entityPair;
	}
	public void setEntityPair(EntityPair[] entityPair) {
		this.entityPair = entityPair;
	}
	public String getSeparator() {
		return separator;
	}
	public void setSeparator(String separator) {
		this.separator = separator;
	}
	public Object[] getValues() {
		return values;
	}
	public void setValues(Object[] values) {
		this.values = values;
	}
	public int getKeyIndex() {
		return keyIndex;
	}
	public void setKeyIndex(int keyIndex) {
		this.keyIndex = keyIndex;
	}
	public int getDescriptionColumnIndex() {
		return descriptionColumnIndex;
	}
	public void setDescriptionColumnIndex(int descriptionColumnIndex) {
		this.descriptionColumnIndex = descriptionColumnIndex;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
