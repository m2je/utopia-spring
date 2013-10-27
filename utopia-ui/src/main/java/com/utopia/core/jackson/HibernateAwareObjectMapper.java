package com.utopia.core.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;

public class HibernateAwareObjectMapper extends ObjectMapper{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1015118750252048290L;

	public HibernateAwareObjectMapper() {
        registerModule(new Hibernate4Module());
    }
}
