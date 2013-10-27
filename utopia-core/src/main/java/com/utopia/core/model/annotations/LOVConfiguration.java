package com.utopia.core.model.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface LOVConfiguration {

	Class<?> searchLOVForm(); 
	
	String conditions() default "";
	
	boolean isMultiSelect() default false;
	
	public abstract class DummyLOVFormClass{};
	
	public String[] boxDisplayingColumns() default {"name"};
	
	public String boxDisplaySeperator() default "-";
}
