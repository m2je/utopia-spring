package com.utopia.core.util.logic;

import groovy.lang.Binding;
import groovy.lang.GroovyShell;

import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.inject.Singleton;

import com.utopia.core.util.ContextUtil;

@Singleton
public class GroovyLogicEvaluator {
	private static Logger logger =Logger.getLogger(GroovyLogicEvaluator.class.getName());
	@Resource
	private ContextUtil contextUtil;
	public  boolean evaluateLogic(String logic,Map<String,Object>map){
		try {
			Binding binding = new Binding();
			List<String> params=LogicParser.getParametersInString(logic);
			if(params!=null&&params.size()>0){
				for(String param:params){
					binding.setProperty("__"+param+"__", contextUtil.getContextParameter(map,param)) ;
					logic= logic.replaceAll(LogicParser.PARAMETER_SIGN+param+LogicParser.PARAMETER_SIGN, "__"+param+"__");
				}
				
			}
			
			GroovyShell shell = new GroovyShell(binding);
			Object result=shell.evaluate(logic);
			if(Boolean.class.isInstance(result)){
				return ((Boolean)result).booleanValue();
			}
		} catch (Exception e) {
//			if(logger.isLoggable(Level.FINEST)){
				logger.log(Level.WARNING,"fail to evaluate groovy script ",e);
//			}
			e.printStackTrace();	
		}
		return false;
	}
}
