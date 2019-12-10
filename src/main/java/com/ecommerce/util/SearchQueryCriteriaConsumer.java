package com.ecommerce.util;

import java.util.function.Consumer;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ecommerce.controller.ProductController;

public class SearchQueryCriteriaConsumer<T> implements Consumer<SearchCriteria> {

	Logger logger=LoggerFactory.getLogger(ProductController.class);
	
private Predicate predicate;
private CriteriaBuilder builder;
private Root<T> r;
private Order order;

	public SearchQueryCriteriaConsumer(Predicate predicate, CriteriaBuilder builder, Root<T> r) {
	super();
	this.predicate = predicate;
	this.builder = builder;
	this.r = r;
	
}

	@Override
	public void accept(SearchCriteria param) {

		String paramArr[]=param.getValue().toString().split(";");
		String nestedChildFiled[]=param.getKey().split("\\.");
		
		if (param.getOperation().equalsIgnoreCase(">=")) {
			
			  if(nestedChildFiled.length==2) 
			  {				  				 
				   Join<T,?> join = r.join(nestedChildFiled[0]);				  				  
				   predicate = builder.and(predicate, builder.greaterThanOrEqualTo(join.get(nestedChildFiled[1]),param.getValue().toString()));
			  }else {
				  	predicate = builder.and(predicate,
					builder.greaterThanOrEqualTo(r.get(param.getKey()), param.getValue().toString()));
			  }
		}
		else if (param.getOperation().equalsIgnoreCase(">")) {
			
			  if(nestedChildFiled.length==2) 
			  {				  				 
				   Join<T,?> join = r.join(nestedChildFiled[0]);				  				  
				   predicate = builder.and(predicate, builder.greaterThan(join.get(nestedChildFiled[1]),param.getValue().toString()));
			  }else {
					predicate = builder.and(predicate,
							builder.greaterThan(r.get(param.getKey()), param.getValue().toString()));
			  }
		} else if (param.getOperation().equalsIgnoreCase("<=")) {
			
			if(nestedChildFiled.length==2) 
			  {				  				 
				   Join<T,?> join = r.join(nestedChildFiled[0]);				  				  
				   predicate = builder.and(predicate, builder.lessThanOrEqualTo(join.get(nestedChildFiled[1]),param.getValue().toString()));
			  }else {
				  	predicate = builder.and(predicate,
					builder.lessThanOrEqualTo(r.get(param.getKey()), param.getValue().toString()));
			  }
		}
		else if (param.getOperation().equalsIgnoreCase("<")) {
			
			if(nestedChildFiled.length==2) 
			  {				  				 
				   Join<T,?> join = r.join(nestedChildFiled[0]);				  				  
				   predicate = builder.and(predicate, builder.lessThan(join.get(nestedChildFiled[1]),param.getValue().toString()));
			  }else 
			  {
				 predicate = builder.and(predicate,
							builder.lessThan(r.get(param.getKey()),param.getValue().toString()));
			  }
		} else if (param.getOperation().equalsIgnoreCase(":")) 
		{					
			  
			  if(nestedChildFiled.length==2) 
			  {				  				 
				   Join<T,?> join = r.join(nestedChildFiled[0]);				  				  
				   predicate = builder.and(predicate, builder.and(join.get(nestedChildFiled[1]).in(paramArr)));
				   
			  }else 
			  {				  				  
				  predicate = builder.and(predicate, builder.and(r.get(param.getKey()).in(paramArr)));
			  }			 		    
		}
	}

	public Predicate getPredicate() {
		return predicate;
	}

	public void setPredicate(Predicate predicate) {
		this.predicate = predicate;
	}

	public CriteriaBuilder getBuilder() {
		return builder;
	}

	public void setBuilder(CriteriaBuilder builder) {
		this.builder = builder;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

}