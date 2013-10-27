/**
 * 
 */
package com.utopia.core.lookup;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Salarkia
 *
 */
public class JoinItem implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3935893243439304139L;
	private List<String> displayItems;
	private Class<? >persistentClass;
	private Class<? > JointTopersistentClass;
	private String joinCondition;
//******************************************************************************
	/**
	 * 
	 * @param displayItems
	 * @param persistentClass
	 * @param JointTopersistentClass
	 */	
	public JoinItem(List<String> displayItems,
			Class<?> persistentClass,
			Class<?> JointTopersistentClass) {
		this.displayItems = displayItems;
		this.persistentClass = persistentClass;
		this.JointTopersistentClass=JointTopersistentClass;
	}
//******************************************************************************
	/**
	 * 
	 * @param displayItems
	 * @param persistentClass
	 */	
	public JoinItem(List<String> displayItems,
			Class<?> persistentClass) {
		this.displayItems = displayItems;
		this.persistentClass = persistentClass;
	}
//******************************************************************************	
	/**
	 * 
	 * @param displayItem
	 * @param persistentClass
	 * @param JointTopersistentClass
	 */
	public JoinItem(String displayItem,
			Class<?> persistentClass,
			Class<?> JointTopersistentClass) {
		this.persistentClass=persistentClass;
		this.displayItems=new ArrayList<String>();
		this.displayItems.add(displayItem);
		this.JointTopersistentClass=JointTopersistentClass;
	}
//******************************************************************************	
/**
 * 
 * @param persistentClass
 */
	public JoinItem(Class<?> persistentClass) {
		this.persistentClass=persistentClass;
		this.displayItems=new ArrayList<String>();

	}
//******************************************************************************
	/**
	 * 
	 * @param displayItem
	 * @param persistentClass
	 */
	public JoinItem(String displayItem,
			Class<?> persistentClass) {
		this.persistentClass=persistentClass;
		this.displayItems=new ArrayList<String>();
		this.displayItems.add(displayItem);
	}
//******************************************************************************
	/**
	 * 
	 */
	public Class<? > getJointTopersistentClass() {
		return JointTopersistentClass;
	}
//******************************************************************************
	public void setJointTopersistentClass(
			Class<?> jointTopersistentClass) {
		JointTopersistentClass = jointTopersistentClass;
	}
//******************************************************************************		
	public List<String> getDisplayItems() {
		return displayItems;
	}
//******************************************************************************
	public void setDisplayItems(List<String> displayItems) {
		this.displayItems = displayItems;
	}
//******************************************************************************
	public Class<? > getPersistentClass() {
		return persistentClass;
	}
//******************************************************************************
	public void setPersistentClass(Class<?> persistentClass) {
		this.persistentClass = persistentClass;
	}
//******************************************************************************
	public String getJoinCondition() {
		return joinCondition;
	}
//******************************************************************************
	public void setJoinCondition(String joinCondition) {
		this.joinCondition = joinCondition;
	}
	
		
		
}
