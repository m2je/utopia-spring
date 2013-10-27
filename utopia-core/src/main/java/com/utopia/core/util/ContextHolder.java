package com.utopia.core.util;

import java.util.Map;

public class ContextHolder {
	 private static final ThreadLocal<Context> threadLocal = new ThreadLocal<Context>();
	 
	 public static void setContext(Context context){
		 threadLocal.set(context);
	 }
	 
	 public static Context getContext(){
		 return threadLocal.get();
	 }
	 
	 public static void clean(){
		 threadLocal.remove();
	 }
	 
	 public static Map<String,Object> getContextMap(){
		 return getContext().getContextMap();
	 } 
}
