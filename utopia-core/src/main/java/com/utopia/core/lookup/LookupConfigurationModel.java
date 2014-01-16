package com.utopia.core.lookup;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.utopia.core.metadata.EntityPair;
import com.utopia.core.model.UtopiaBasicPersistent;


public class LookupConfigurationModel implements Serializable {
	private static final Logger logger;
	
	static {
		logger = Logger.getLogger(LookupConfigurationModel.class);
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = -2229190593276509425L;
	private String seperator="-";
	private List<JoinItem>joinItems=new ArrayList<JoinItem>(); 
	private String primaryKeyColumn;
	private String[] ownDisplayColumns;
	private Class<? extends UtopiaBasicPersistent>ownPersitentClass;
	private Class<? extends UtopiaBasicPersistent>primaryKeyPersistent;
	private List<Condition> conditions=new ArrayList<Condition>();
	private String descriptionColumn;
	private String []orderby;
	public LookupConfigurationModel(Class<? extends UtopiaBasicPersistent> ownPersitentClass){
		this.ownPersitentClass=ownPersitentClass;
	}
//******************************************************************************	
	public String getSeperator() {
		return seperator;
	}
//******************************************************************************
	public void setSeperator(String seperator) {
		this.seperator = seperator;
	}
//******************************************************************************
	public void join(JoinItem item){
		joinItems.add(item);
	}
//******************************************************************************
	public List<JoinItem> getJoinItems(){
		return joinItems;
	}
//******************************************************************************
	public void removeJoin(JoinItem item){
		joinItems.remove(item);
	}
//******************************************************************************
	public String getPrimaryKeyColumn() {
		return primaryKeyColumn;
	}
//******************************************************************************
	public String getLookupPrimaryKeyColumn() {
		if(primaryKeyPersistent==null&&ownPersitentClass==null){
			throw new IllegalArgumentException("owner persistent object of lookup not defind");
		}
		return primaryKeyPersistent==null?ownPersitentClass.getSimpleName():primaryKeyPersistent.getSimpleName();
	}
//******************************************************************************
	public void setPrimaryKeyColumn( String primaryKeyColumn) {
		setPrimaryKeyColumn(null,primaryKeyColumn);
	}
//******************************************************************************
	public void setPrimaryKeyColumn(Class<? extends UtopiaBasicPersistent>persistentClass, String primaryKeyColumn) {
		this.primaryKeyColumn = primaryKeyColumn;
		this.primaryKeyPersistent=persistentClass;
	}
//******************************************************************************
	public List<EntityPair> getDisplayColumns() {
		ArrayList<EntityPair>result=new ArrayList<EntityPair>();
		if(ownDisplayColumns!=null&&ownDisplayColumns.length>0){
			for(int i=0;i<ownDisplayColumns.length;i++){
			result.add(new EntityPair(ownPersitentClass,ownDisplayColumns[i]));
			}
		}
		for(JoinItem item:joinItems){
			List<String> displayItem= item.getDisplayItems();
			if(displayItem!=null){
				for(String current:displayItem){
					if(current!=null)
					result.add(new EntityPair(item.getPersistentClass(),current));
				}
			}
		}
		return result;
	}
//******************************************************************************
	public String getDisplayColumnsCommaSeperated() {
		return 	getFormatedDisplayColumns();
	}
//******************************************************************************	
	private String getFormatedDisplayColumns(){
		StringBuffer result=new StringBuffer();
		
		boolean first=true;
		for(EntityPair item: getDisplayColumns()){
			if(!first){
				result.append(",");
				}
			first=false;
			result.append(item.getEntityClass().getSimpleName()).append(".").append(item.getPropertyName());
		}
		return result.toString();

	}
//******************************************************************************
	public String[] getOwnDisplayColumns() {
		return ownDisplayColumns;
	}
//*****************************************************************************
	public void setOwnDisplayColumns(String ...ownDisplayColumns) {
		this.ownDisplayColumns = ownDisplayColumns;
	}
//******************************************************************************
	public void setDescriptionColumn(String descriptionColumn) {
		this.descriptionColumn=descriptionColumn;
	}
//******************************************************************************
	public String getDescriptionColumn(){
		return descriptionColumn;
	}
//******************************************************************************
	public Class<? extends UtopiaBasicPersistent> getOwnPersitentClass() {
		return ownPersitentClass;
	}
//******************************************************************************
	public void setOwnPersitentClass(
			Class<? extends UtopiaBasicPersistent> ownPersitentClass) {
		this.ownPersitentClass = ownPersitentClass;
	} 
//******************************************************************************
	/**
	 * 
	 * @param condition
	 * @param context
	 */
	public void addCondition(String condition) {
		if(condition==null||condition.trim().length()==0)return ;
		addCondition(new Condition(condition));
	}
//******************************************************************************
	/**
	 * 
	 * @param condition
	 * @param context
	 */
	public void addCondition(Condition condition) {
		this.conditions.add(condition);
	}
//******************************************************************************	
	public List<Condition> getConditions(){
		return conditions;
	}
//******************************************************************************
	public void removeAllConditions(){
		if(conditions!=null){
			conditions.clear();
		}
	}
//******************************************************************************	
	public String[] getOrderby() {
		return orderby;
	}
//******************************************************************************
	public void setOrderby(String[] orderby) {
		this.orderby = orderby;
	}
//******************************************************************************
	public boolean isOrdered(){
		return orderby!=null&&orderby.length>0&&orderby[0].trim().length()>0;
	}
}
