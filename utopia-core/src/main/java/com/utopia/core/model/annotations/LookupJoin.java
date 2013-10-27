package com.utopia.core.model.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import com.utopia.core.model.UtopiaPersistent;

@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface LookupJoin {
	Class<? extends UtopiaPersistent> joinToClass();
	LookupConfiguration lookupConfiguration()  ;
	String condition() default "";
	
}
