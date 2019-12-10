package com.ecommerce.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.ecommerce.controller.ProductController;
import com.ecommerce.util.SearchCriteria;
import com.ecommerce.util.SearchQueryCriteriaConsumer;

@Repository
public class GenericDao<T> implements IGenericDao<T> {

	Logger logger=LoggerFactory.getLogger(ProductController.class);
	
	@PersistenceContext
    private EntityManager entityManager;
	
	 
	    public List<T> search(List<SearchCriteria> params,Class<T> className) {
	        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
	        CriteriaQuery<T> query = builder.createQuery(className);
	        
	        
	        
	        Root<T> r=query.from(className);
	        	        
	 
	        Predicate predicate = builder.conjunction();
	 
	        SearchQueryCriteriaConsumer<T> searchConsumer = 
	          new SearchQueryCriteriaConsumer<T>(predicate, builder, r);
	        
	        params.stream().forEach(searchConsumer);
	        
	        predicate = searchConsumer.getPredicate();
	 
	        query.where(predicate);
	        
	        
	 
	        List<T> result = entityManager.createQuery(query).getResultList();
	        return result;
	    }
	
	
}
