package com.utopia.core.lookup;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.utopia.core.metadata.EntityPair;
import com.utopia.core.model.UtopiaBasicPersistent;
import com.utopia.core.util.logic.AnnotationUtil;


public class LookupConfigurationModel implements Serializable {
	private static final Logger logger;
	
	static {
		logger = Logger.getLogger(LookupConfigurationModel.class.getName());
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
	private static HashMap<String, Object>defaultContext=new HashMap<String, Object>();
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
	public String getJoinclause(){
		List<Class<?>>joinedItems=new ArrayList<Class<?>>();
		joinedItems.add(ownPersitentClass);
		StringBuffer result=new StringBuffer();
		return join(result,joinedItems,joinedItems.size()).toString();
	}
//******************************************************************************	
	/**
	 * 
	 * @param result
	 * @param joinedItems
	 * @param oldSize
	 * @return
	 */
	private StringBuffer join(StringBuffer result,List<Class<?>>joinedItems,int oldSize){
		for(JoinItem item: this.joinItems){
			if(!joinedItems.contains(item.getJointTopersistentClass())&&
				!joinedItems.contains(item.getPersistentClass())	){
				Class<?>clazz=item.getPersistentClass()==null?
						this.getOwnPersitentClass():item.getPersistentClass();
				String propertyName=findPersistentAttributeInClass(clazz , item.getPersistentClass());
				if(propertyName==null||propertyName.trim().length()==0){
						propertyName=findPersistentAttributeInClass(item.getPersistentClass(),clazz );
						boolean hasJoinCondition=item.getJoinCondition()!=null&&item.getJoinCondition().trim().length()>0;
						if(propertyName!=null||hasJoinCondition){
							result.append(" , ").append(clazz.getSimpleName()).
							append(" ").append(clazz.getSimpleName());	
							String condition=hasJoinCondition?item.getJoinCondition():
								clazz.getSimpleName()+"."+propertyName+"="+item.getPersistentClass().getSimpleName()+"."+propertyName;
							addCondition(condition, defaultContext);
							joinedItems.add(item.getPersistentClass());
						}
						else{
							logger.log(Level.WARNING,"fail to find join column for class -->"+clazz.getName() +" in class -->"+
								item.getPersistentClass().getName());
						}
					continue;
				}else{
					result.append(" join ").append(item.getJointTopersistentClass().getSimpleName()).append(".")
					.append(propertyName).append(" ").append(item.getPersistentClass().getSimpleName() );	
					joinedItems.add(item.getPersistentClass());
				}
			}
		}
		if(joinedItems.size()==oldSize){
			if(this.joinItems!=null&&this.joinItems.size()>oldSize){
				logger.log(Level.WARNING,"not all join column join to lookup");	
			}
			return result;
		}
		return join(result,joinedItems,joinedItems.size());
	}
//******************************************************************************
	/**
	 * 
	 * @param sourceClass
	 * @param destination
	 * @return
	 */	
	private String findPersistentAttributeInClass(Class<?> sourceClass,Class<? >destination){
		Method []methods = sourceClass.getMethods();
		for(Method method:methods){
			Class<?>clazz= method.getReturnType();
			if(clazz.equals(destination)){
				return AnnotationUtil.getPropertyName(method.getName());
			}
		}
		return null;
	}
//******************************************************************************	
	/**
	 * 
	 * @param condition
	 * @param context
	 */
	public void addCondition(String condition,Map<String,Object> context) {
		if(condition==null||condition.trim().length()==0)return ;
		addCondition(new Condition(condition,context));
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
	public void setParameterValue(String parameterName,Object parameterValue){
		if(conditions!=null){
			for(Condition cond:conditions){
				cond.setParameterValue(parameterName, parameterValue);
			}
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
