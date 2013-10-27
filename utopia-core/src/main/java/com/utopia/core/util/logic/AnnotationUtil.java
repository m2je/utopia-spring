package com.utopia.core.util.logic;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.apache.commons.beanutils.MethodUtils;

import com.utopia.core.util.Cache;

public class AnnotationUtil {
	private static Cache<String,Set<Method>>METHOD_ANNOTATION_CACHE=new Cache<String, Set<Method>>();
	private static Cache<String,Set<Field>>FIELD_ANNOTATION_CACHE=new Cache<String, Set<Field>>();
	private static Cache<String,Set<String>>MANY_TO_ONE_ANNOTATION_CACHE=new Cache<String, Set<String>>();
	private static Cache<String, String>CLASS_PRIMARY_KEY_CACHE=new Cache<String, String>();
	private static Cache<String, Method>CLASS_Method_KEY_CACHE=new Cache<String, Method>();
	private static final Logger logger;
	
	static {
		logger = Logger.getLogger(AnnotationUtil.class.getName());
	}
	private static final Class<?>[]c=new Class<?>[0];
//*****************************************************************************	
	public static  String getPropertyName(String getterMethodName){
		String result;
		int index;
		if(getterMethodName.startsWith("get")){
			index=4;
		 }else if(getterMethodName.startsWith("is")){
			 index=3;
		 }else{
			 logger.log(Level.WARNING,"invalid getter method name"+getterMethodName);
			 return null;
		 }
		result =getterMethodName.substring(index);
		char c= Character.toLowerCase(getterMethodName.charAt(index-1));
		return  c+result ;
	}
//*****************************************************************************
	public static String getPropertyNameFromSetterMethod(String setterName){
		String result;
		int index;
		if(setterName.startsWith("set")){
			index=4;
		 }else{
			 throw new IllegalArgumentException("invalid getter method name"+setterName);
		 }
		result =setterName.substring(index);
		char c= Character.toLowerCase(setterName.charAt(index-1));
		return  c+result ;
	}
//*****************************************************************************
/**
 *return equivalent setter method of the input getter method name 
 * @param getterMethod
 * @return
 */	
	public static String getSetterMethodName(String getterMethod){
		if(getterMethod==null||getterMethod.trim().length()==0){
			throw new IllegalArgumentException("invalid getter method "+getterMethod);
		}
		if(getterMethod.startsWith("get")){
			return getterMethod.replaceFirst("[g]","s" );
		}else if(getterMethod.startsWith("is")){
			return "set"+Character.toUpperCase(getterMethod.charAt(2))+getterMethod.substring(3); 
		}
		throw new IllegalArgumentException("invalid getter method "+getterMethod);
		
			
	}
//*****************************************************************************
	/**
	 *return equivalent setter method of the input getter method name 
	 * @param setterMethod
	 * @return
	 */	
		public static String getGettrFromSetterMethodName(String setterMethod){
			if(setterMethod==null||setterMethod.trim().length()==0){
				throw new IllegalArgumentException("invalid setter method "+setterMethod);
			}
			if(setterMethod.startsWith("set")){
				return setterMethod.replaceFirst("[s]","g" );
			}
			throw new IllegalArgumentException("invalid getter method "+setterMethod);
		}
//*****************************************************************************
	public static String getSetterMethodOfField(String fieldName){
		return "set"+Character.toUpperCase(fieldName.charAt(0))+fieldName.substring(1);
	}
//*****************************************************************************
	public static String getFieldName(String className){
		return (className!=null&&className.trim().length()>0)?
				 Character.toLowerCase(className.trim().charAt(0))+className.trim().substring(1):null;
	}
//*****************************************************************************
	/**
	 * 
	 * @param propertyName
	 * @return
	 */
	public static String getGetterMethodName(String propertyName){
		return getGetterMethodName(propertyName,null);
	}
//*****************************************************************************
		/**
		 * 
		 * @param propertyName
		 * @param propertyClass
		 * @return
		 */
		public static String getGetterMethodName(String propertyName,Class<?>propertyClass){
			return (Boolean.class.equals(propertyClass)||boolean.class.equals(propertyClass)?"is":"get")+Character.toUpperCase(propertyName.charAt(0))+propertyName.substring(1);
		}

//*****************************************************************************
	public static Class<?> getGetterMethodReturnType(Class<?>clazz,String propertyName){
		String methodName=AnnotationUtil.getGetterMethodName(propertyName);
		String key=clazz.getName()+"|"+methodName;
		if(!CLASS_Method_KEY_CACHE.containsKey(key)){
			try {
				CLASS_Method_KEY_CACHE.put(key, clazz.getMethod(methodName, c));
			} catch (Exception e) {
				logger.log(Level.WARNING,"", e);
				CLASS_Method_KEY_CACHE.put(key,null);
			}
		}
		Method method= CLASS_Method_KEY_CACHE.get(key);
		return method==null?null:method.getReturnType();
	}
//*****************************************************************************
	/**
	 * 
	 * @param method
	 * @param annotations
	 * @return
	 */
	public static boolean hasAnnotaions(Method method,Class<? extends Annotation>...annotations){
		for(Class<? extends Annotation> clazz:annotations){
			if( method.getAnnotation(clazz)!=null){
				return true;
			}
		}
		return false;
	}
//*****************************************************************************	
	/**
	 * 
	 * @param field
	 * @param annotations
	 * @return
	 */
	public static boolean hasAnnotaions(Field field,Class<? extends Annotation>...annotations){
		
		for(Class<? extends Annotation> clazz:annotations){
			if( field.getAnnotation(clazz)!=null){
				return true;
			}
		}
		return false;
	}
//*****************************************************************************		
	/**
	 * returns field annotations in case of field is null return all fields having 
	 * the annotation
	 * @param clazz
	 * @param property
	 * @param annotaionTypes
	 * @return
	 */
	public static Set<Method> getMethodAnnotations(Class<?>clazz,String property,Class<? extends Annotation> ...annotaionTypes){
		String key=property!=null?clazz.getName()+"|"+property:clazz.getName();
		for(Class<?> annot: annotaionTypes){
			key+="|"+annot.getName();
		}
		Set<Method>linkedFields;
		String getterMethodName=property==null?null:AnnotationUtil.getGetterMethodName(property);
		String setterMethodName=property==null?null:AnnotationUtil.getSetterMethodOfField(property);
		if(!METHOD_ANNOTATION_CACHE.containsKey(key)){
				linkedFields=new HashSet<Method>();
				for(Method method: clazz.getMethods()){
					if(property==null||method.getName().equals(getterMethodName)||method.getName().equals(setterMethodName)){
						for(Class<? extends Annotation> annot: annotaionTypes){
							Annotation o=method.getAnnotation(annot);
							if(o!=null){
								linkedFields.add(method);
							}
						}
					}
				}
				
		}else{
			linkedFields=METHOD_ANNOTATION_CACHE.get(key);
		}
		return linkedFields;
	}
//*****************************************************************************	
	/**
	 * 
	 * @param clazz
	 * @param annotaionTypes
	 * @return
	 */
	public static Set<Method> getMethodAnnotations(Class<?>clazz,Class<? extends Annotation> ...annotaionTypes){
		return getMethodAnnotations(clazz,null, annotaionTypes);
	}
//*****************************************************************************
	public static Set<Field> getFieldAnnotations(Class<?>clazz,String property,Class<? extends Annotation> ...annotaionTypes){
		String key=property!=null?clazz.getName()+"|"+property:clazz.getName();
		for(Class<?> annot: annotaionTypes){
			key+="|"+annot.getName();
		}
		Set<Field>linkedFields;
		if(!FIELD_ANNOTATION_CACHE.containsKey(key)){
			linkedFields=new HashSet<Field>();
			for(Field field:clazz.getFields()){
				if(property==null||field.getName().equals(property)){
					for(Class<? extends Annotation> annot: annotaionTypes){
						Annotation o=field.getAnnotation(annot);
						if(o!=null){
							linkedFields.add(field);
						}
					}
					}
			}
	}else{
		linkedFields=FIELD_ANNOTATION_CACHE.get(key);
	}
		return linkedFields;
	}
//*****************************************************************************	
	/**
	 * 
	 * @param clazz
	 * @param annotaionTypes
	 * @return
	 */
	public static Set<Field> getFieldAnnotations(Class<?>clazz,Class<? extends Annotation> ...annotaionTypes){
		return getFieldAnnotations(clazz,null,annotaionTypes);
	}
//*****************************************************************************	
	/**
	 * return an String list of fields in clazz witch is conneted to parent with ManyToOne annotation 
	 * @param clazz
	 * @param parent
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Set<String> getParentRelations(Class<?>clazz,Class<?>parent){
		String key=clazz.getName()+"|"+parent.getName();
		Set<String>propsArray;
		if(!MANY_TO_ONE_ANNOTATION_CACHE.containsKey(key)){
			Set<Field>fields=AnnotationUtil.getFieldAnnotations(clazz,ManyToOne.class);
			Set<Method>methods=AnnotationUtil.getMethodAnnotations(clazz,ManyToOne.class);
			propsArray=new HashSet<String>();
			for(Method method:methods){
				Class<?>[]params=method.getParameterTypes();
				Class<?>param=null;
				String paramName=null;
				if(params!=null&&params.length>0&&method.getName().startsWith("set")){
					param=params[0];
					paramName=AnnotationUtil.getPropertyNameFromSetterMethod(method.getName());
				}else if(method.getName().startsWith("get")){
					param=method.getReturnType();
					paramName=AnnotationUtil.getPropertyName(method.getName());
				}
				if(param!=null&&paramName!=null&&param.equals(parent)){
					propsArray.add(paramName);
				}
			}
			for(Field field:fields){
				if(field.getClass().equals(parent) ){
					propsArray.add(field.getName());
				}
			}
			MANY_TO_ONE_ANNOTATION_CACHE.put(key, propsArray);
			}else{
				propsArray=MANY_TO_ONE_ANNOTATION_CACHE.get(key);
			}
		return propsArray;
	}
//*****************************************************************************
	/**
	 * 
	 * @param persistent
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static String getPrimaryKeyName(Class<?> persistent){
		String key=persistent.getName();
		if(!CLASS_PRIMARY_KEY_CACHE.containsKey(key)){
			 Set<Field>field= getFieldAnnotations(persistent, Id.class);
			 Set<Method>methods= getMethodAnnotations(persistent, Id.class);
			 if(field!=null&&field.size()>0){
				 return field.iterator().next().getName();
			 }else if(methods!=null&&methods.size()>0){
				 Method method=methods.iterator().next();
				 String result=
				 method.getName().startsWith("get")?
				  AnnotationUtil.getPropertyName(method.getName()): AnnotationUtil.getPropertyNameFromSetterMethod(method.getName());
				  CLASS_PRIMARY_KEY_CACHE.put(key, result);
			 }
		}
		return CLASS_PRIMARY_KEY_CACHE.get(key);
		
	}
//*****************************************************************************
	public static String[] getPersitentColumns(Class<?>clazz){
		Method []methods= clazz.getMethods();
		Set<String>result=new HashSet<String>();
		for(Method method:methods){
			Column col= method.getAnnotation(Column.class);
			JoinColumn col1=method.getAnnotation(JoinColumn.class);
			if(col!=null||col1!=null){
				result.add(AnnotationUtil.getGetterMethodName(method.getName()));
			}
			
		}
		return result.toArray(new String[result.size()]);
	}
//*****************************************************************************
public static Class<?> extractGenericClass(Class<?> ownerClass, String methodName){
	Method method= MethodUtils.getAccessibleMethod(ownerClass, methodName,c);
	if(Collection.class.isAssignableFrom(method.getReturnType())){
		Type returnType =method.getGenericReturnType();
		if(returnType instanceof ParameterizedType){
		    ParameterizedType type = (ParameterizedType) returnType;
		    Type[] typeArguments = type.getActualTypeArguments();
		    for(Type typeArgument : typeArguments){
		    		return (Class<?>)typeArgument;
		    }
		}
	}else{
		return method.getReturnType();
	}
	
	return null;
}
//*****************************************************************************	
	
}
