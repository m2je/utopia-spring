package com.utopia.core.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;

public class UtopiaObjectMapper extends ObjectMapper{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1015118750252048290L;

	public UtopiaObjectMapper() {
        registerModule(new Hibernate4Module());
    }
}
