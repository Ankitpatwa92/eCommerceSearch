package com.ecommerce.dao;

import java.util.List;

import com.ecommerce.util.SearchCriteria;

public interface IGenericDao<T> {

	   public List<T> search(List<SearchCriteria> params,Class<T> className);
	
}
