package com.utopia.core.util.logic;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.beanutils.MethodUtils;
import org.apache.log4j.Logger;

/**
 * <p>Title: </p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: </p>
 *
 * @author Salarkia
 * @version 1.0
 */
public class LogicParser {
private static final Logger logger;
	
	static {
		logger = Logger.getLogger(LogicParser.class.getName());
	}
	private static final Object []o=new Object[0]; 
    public static final String PARAMETER="([\\p{Alnum}|_]+"+
                                    "[\\w|\\.]*)";
    public static final String PARAMETER_SIGN="@";
    public static final String SPACE="[\\s]";
    public static final String SPACES=SPACE+"*";
    public static final String PARAMETER_TOKEN=PARAMETER_SIGN+SPACES+PARAMETER+SPACES+PARAMETER_SIGN;
    public static final String LOGIC="("+PARAMETER_TOKEN+")";

    public static final String JAVA_PARAMETER="([\\p{Alnum}|_|\\.]+"+
    "\\w*)";
	 public static final String JAVA_PARAMETER_SIGN="$";
	 public static final String JAVA_PARAMETER_TOKEN="\\"+JAVA_PARAMETER_SIGN+JAVA_PARAMETER+"\\"+JAVA_PARAMETER_SIGN;
	 public static final String JAVA_LOGIC="("+JAVA_PARAMETER_TOKEN+")";

	 public static final String REST_PARAMETER_SIGN="{";
	 public static final String REST_PARAMETER_TOKEN="\\"+REST_PARAMETER_SIGN+JAVA_PARAMETER+"\\"+REST_PARAMETER_SIGN;
	 public static final String REST_URI="("+REST_PARAMETER_TOKEN+")";
	 
	 public static final String COMBINATIONAL_LOGIC_SEPARATPR="\\}\\&|\\|\\{";
//  *************************************************************************
    /**
     * returns a logic String free from parameters 
     * gets parameters values from source
     * @param input
     * @param source
     * @author salarkia 
     */
    public static String getFlatExpression(String input, ParameterHandler source){
    	HashMap<String,String> paramMap=new HashMap<String,String>();
        List<String>parameters=getParametersInString(new String(input));
        for(String parameterName:parameters){
        	int dotIndex=parameterName.indexOf(".");
        	if(dotIndex>0&&dotIndex+1<parameterName.length()){
        		String temp=parameterName.substring(0,dotIndex);
        		String propertyNames=parameterName.substring(dotIndex+1);
        		Object currentObject= source.getParameterValue(temp);
        		paramMap.put(parameterName, getObjectInnerValue(currentObject,propertyNames));
        	}
       		initMap(paramMap,parameterName,source);	
            String currentPattern=PARAMETER_SIGN+SPACES+parameterName+SPACES+PARAMETER_SIGN;
            input=replace(input,currentPattern,paramMap.get(parameterName));
             }
        return input;
    }
//  *************************************************************************
    /**
     * 
     * @param input
     * @param paramMap
     * @return
     */
    public static String getFlatExpression(String input, Map<String ,? extends Object> paramMap){
    	return getFlatExpression(input, new MapParameterHandler(paramMap));
    }
//  *************************************************************************
    private static String getObjectInnerValue(Object value,String propertyName){
    	if(value==null)return "";
    	if(propertyName==null||propertyName.trim().length()==0)return value.toString();
    	try {
    		if(value instanceof Collection<?>){
    			StringBuffer result=new StringBuffer();
    			int index=0;
    			for(Object c:(Collection<?>)value){
    				if(c!=null)
    					if(index>0){
    						result.append(",");
    					}
    					result.append(c.toString());
    					
    			}
    			return result.toString();
    		}else if(value.getClass().isArray() ){
    			StringBuffer result=new StringBuffer();
    			int index=0;
    			for(Object c:(Object[])value){
    				if(c!=null)
    					if(index>0){
    						result.append(",");
    					}
    					result.append(c.toString());
    					
    			}
    			return result.toString();
    		}
    		else{
        		String cPropName=propertyName;
        		int dotIndex=propertyName.indexOf(".");
        		String detailProps=null;
        		if(dotIndex>0){
        			cPropName=propertyName.substring(0,dotIndex);
        			if(dotIndex+1<propertyName.length()){
        				detailProps=propertyName.substring(dotIndex+1);
        			}
        		}
    			Object cvalue= MethodUtils.invokeMethod(value, AnnotationUtil.getGetterMethodName(cPropName), o);
    			if(detailProps==null){
    				return cvalue==null?"":cvalue.toString();
    			}
    			return getObjectInnerValue(cvalue, detailProps);

    		}
		} catch (Exception e) {
			logger.warn("fial to get property--->"+propertyName+" form Object "+value);
		}
    	return "";
    }
//  *************************************************************************
   /**
    * parses input and creates a list of parameters
    * @param input
    * @author salarkia
    */
    public static List<String>getParametersInString(String input){
    	ArrayList<String>result=new ArrayList<String>();
    	 Pattern pat = Pattern.compile(LOGIC);
         Matcher m = pat.matcher(input);
             while (m.find()) {
                  String param=m.group(1);
                  String parameterName=getParameterName(param,PARAMETER_SIGN);
                  result.add(parameterName);
                  String currentPattern=PARAMETER_SIGN+SPACES+parameterName+SPACES+PARAMETER_SIGN;
                  input=input.replaceAll(currentPattern,"");
                  m=pat.matcher(input);
                  }
    	return result;
    } 
//  *************************************************************************
    public static List<String> getJavaParameters(String input){
    	ArrayList<String>result=new ArrayList<String>();
      	Pattern pat = Pattern.compile(JAVA_LOGIC);
        Matcher m = pat.matcher(input);
           while (m.find()) {
                String param=m.group(1);
                String parameterName=getParameterName(param,JAVA_PARAMETER_SIGN);
                result.add(parameterName);
                String currentPattern="\\"+JAVA_PARAMETER_SIGN+parameterName+"\\"+JAVA_PARAMETER_SIGN;
                input=input.replaceAll(currentPattern,"");
                m=pat.matcher(input);
                }
           return result;
    }
//  *************************************************************************
    public static List<String> getReSTParameters(String input){
    	ArrayList<String>result=new ArrayList<String>();
      	Pattern pat = Pattern.compile(REST_URI);
        Matcher m = pat.matcher(input);
           while (m.find()) {
                String param=m.group(1);
                String parameterName=getParameterName(param,REST_PARAMETER_SIGN);
                result.add(parameterName);
                String currentPattern="\\"+REST_PARAMETER_SIGN+parameterName+"\\"+REST_PARAMETER_SIGN;
                input=input.replaceAll(currentPattern,"");
                m=pat.matcher(input);
                }
           return result;
    }
//  *************************************************************************
    public static Object getJavaParameterValue(String parameter,Map<String,Object>context){
    	if(parameter==null||parameter.trim().length()==0)
    		return null;
    	Object result=getEnumuratedValue(parameter);
    	//TODO evaluate other type of java functions
    	return result;
    }
//  *************************************************************************
    @SuppressWarnings("unchecked")
	private static Object getEnumuratedValue(String parameter){
    	try {
			int lastDotIndex=parameter.lastIndexOf(".");
			if(lastDotIndex>0){
			 String enumClass=parameter.substring(0, lastDotIndex);
			 Class<?>clazz=findClass(enumClass, null);
			 parameter=parameter.substring(lastDotIndex+1);
			return Enum.valueOf((Class<? extends Enum>)clazz, parameter);
			}
		} catch (Exception e) {
			logger.warn(e);
			
		}
		return null;
    }
//  *************************************************************************
    public static Class<?> findClass(String className,String innerClass){
    	try {
			Class<?>clazz=Class.forName(className);
			if(innerClass!=null){
				return getInnerClass(clazz, innerClass);
			}else{
				return clazz;
			}
		} catch (ClassNotFoundException e) {
			logger.warn("fail to find class -->"+className );
			int lastDotIndex=className.lastIndexOf(".");
			if(lastDotIndex>0){
			 String clazz=className.substring(0, lastDotIndex);
			 String temp=className.substring(lastDotIndex+1);
			 innerClass=innerClass==null?temp:innerClass+"."+temp;
			 return findClass(clazz, innerClass)	;
			 }
			return null;
		}catch (Exception e){
			return null;
		}
    }
//  *************************************************************************
    private static Class<?> getInnerClass(Class<?>clazz,String innerClass){
    	int dotIndex=innerClass.indexOf(".");
    	Class<?>[]classes= clazz.getClasses();
    	if(dotIndex>0){
    		String temp=innerClass.substring(0,dotIndex);
    		Class<?>tempClazz= findInClasses(classes, temp);
    		if(tempClazz!=null){
    			return getInnerClass(tempClazz, innerClass.substring(dotIndex+1));
    		}
    		return null;
    	}else{
    		return findInClasses(classes, innerClass);
    	}
    }
//  *************************************************************************
    private static Class<?> findInClasses(Class<?>[]classes,String innerClass){
    	for(Class<?> c:classes){
    		if(c.getSimpleName().equals(innerClass)){
    			return c;
    		}
    	}
    	return null;
    }
//  *************************************************************************
    private static String getParameterName(String parameterToken,String parameterSign){
        int delStart,delEnd;
        delStart=parameterToken.indexOf(parameterSign);
        delEnd=parameterToken.lastIndexOf(parameterSign);
        if(delStart+1==delEnd|| delStart==-1|| delEnd==-1){
              throw new IllegalArgumentException("the parameter token is not valid");
        }
        return parameterToken.substring(delStart+1,delEnd).trim();
        }
 //*************************************************************************
    private static void initMap(HashMap<String,String> paramMap,String parameter, ParameterHandler source) {
                if(paramMap.containsKey(parameter))return;
                Object value=source.getParameterValue(parameter);
                paramMap.put(parameter,value==null?"":value.toString());

}
//***************************************************************************
    private static String replace(String input,String currentPattern,String value) {
        StringBuffer sb = new StringBuffer();
           Pattern p = Pattern.compile(currentPattern);
            Matcher m2 = p.matcher(input);
            while (m2.find()) {
                m2.appendReplacement(sb, value);
            }
            m2.appendTail(sb);
            return sb.toString();
            }
//*****************************************************************************
    public static String replaceJavaVariable(String input,String javaParameter,String replacement){
    	return input.replaceAll("\\"+JAVA_PARAMETER_SIGN+javaParameter+"\\"+JAVA_PARAMETER_SIGN, replacement);
    }
 //*****************************************************************************
    public static String[] splitCombinationalLogic(String logic){
    	String []result=logic.split(COMBINATIONAL_LOGIC_SEPARATPR);
    	for(int i=0;i<result.length;i++){
    		result[i]=result[i].replace("{", "").replace("}", "");
    	}
    	return result;
    }
 //*****************************************************************************
    /**
     * this class models a default ParameterHandler base on a map
     */
    public static class MapParameterHandler implements ParameterHandler{
    	private Map<String,? extends Object> map;

		public MapParameterHandler(Map<String, ?extends Object> map) {
			super();
			this.map = map;
		}

		public Object getParameterValue(String parameterName) {
			return parameterName==null?"":map.get(parameterName);
		}
    	
    }
}
