package com.utopia.core.dao;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

public class UtopiaRepository<T, ID extends Serializable>
extends SimpleJpaRepository<T, ID>  {

	  private EntityManager entityManager;

	  public UtopiaRepository(Class<T> domainClass, EntityManager entityManager) {
	    super(domainClass, entityManager);

	    this.entityManager = entityManager;
	  }

	  
}
