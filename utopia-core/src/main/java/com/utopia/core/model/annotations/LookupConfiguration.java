package com.utopia.core.model.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface LookupConfiguration {
	
	   String[] displayColumns() default "name";
	   String primaryKeyColumnName() default "" ;
	   String displayItemSeperator() default "-";
	   Class<?> persistentClass() default Object.class;
	   String condition() default "";
	   @SuppressWarnings("unchecked")
	   Class<? extends Enum> enumuratedClass() default Enum.class;
	   String descriptionColumnName() default "";
	   String []orderby() default {};
}
