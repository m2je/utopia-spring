package com.utopia.core.dao;

import java.lang.reflect.ParameterizedType;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.data.domain.Page;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import com.utopia.core.model.UtopiaBasicPersistent;

public abstract class AbstractBasicDAO<P extends UtopiaBasicPersistent>  implements UtopiaBasicDAO<P>{

	@PersistenceContext
	protected EntityManager entityManager;
	
	protected Class<P> persistentClass;
	

//**************************************************************************************
	@SuppressWarnings("unchecked")
	@PostConstruct
	protected void initPersistentClass(){
		 this.persistentClass =(Class<P>) (((ParameterizedType)getClass().getGenericSuperclass())).getActualTypeArguments()[0];
	}	
//**************************************************************************************
	public Page<P> search(String condition){
		CriteriaBuilder cb= entityManager.getCriteriaBuilder();
		CriteriaQuery<P> cq = cb.createQuery(persistentClass);
		
//		Root<P> base = cq.from(Pet_);
		ExpressionParser parser = new SpelExpressionParser();
//		parser.parseExpression(condition).;
		return null;
	}
}
