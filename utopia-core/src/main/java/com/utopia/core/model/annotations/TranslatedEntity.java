package com.utopia.core.model.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import com.utopia.core.model.UtopiaBasicPersistent;

@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface TranslatedEntity {
	Class<? extends UtopiaBasicPersistent> translationEntity() default UtopiaBasicPersistent.class;
}
