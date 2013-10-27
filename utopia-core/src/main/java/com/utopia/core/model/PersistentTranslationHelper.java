package com.utopia.core.model;

import java.util.Locale;
import java.util.ResourceBundle;

import com.utopia.core.util.Cache;


public abstract class PersistentTranslationHelper {

	public static final Cache<String, Boolean>PERSISTENT_CACHE=new Cache<String, Boolean>();
	public static  String transalateRecord(Class<?> pesistentclass,String fieldname,String value,String language){
		
		if("name".equals(fieldname)){
			try {
				return  ResourceBundle.getBundle(pesistentclass.getName(),new Locale( language)).getString(value);
			} catch (Exception e) {
			}
		}
		try {
			return  ResourceBundle.getBundle(pesistentclass.getClass().getName(),new Locale( language)).getString(fieldname+"_"+value);
		} catch (Exception e) {
			return value;
		}
	}
//*********************************************************************************************************	
	public static boolean isTranslatedTable(Class<?> pesistentclass,String language){
		String name=pesistentclass.getName();
		String key=name+"|"+language;
		if(!PERSISTENT_CACHE.containsKey(key)){//PERSISTENT_CACHE.clear()
			boolean exists=false;
			if("en".equals(language)){
				exists=bundleExists(pesistentclass,pesistentclass.getSimpleName())||bundleExists(pesistentclass,pesistentclass.getSimpleName()+"_en");
			}else{
				exists=bundleExists(pesistentclass, pesistentclass.getSimpleName()+"_"+language);
			}
			PERSISTENT_CACHE.put(key, exists);
			
		}
		return PERSISTENT_CACHE.get(key);
	}
//*********************************************************************************************************
	private static boolean bundleExists(Class <?>clazz,String fileName){
		try {
			ResourceBundle.getBundle(clazz.getPackage().getName()+"."+fileName);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	
}
