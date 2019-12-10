package com.ecommerce.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ecommerce.model.Supplier;
import com.ecommerce.util.SearchCriteria;

@Service
public interface ISupplierService {

	public List<Supplier> getAllSuppliers();				
	
	public Iterable<Supplier> saveSupplier(List<Supplier> suppliers);

	public List<Supplier> searchSupplier(List<SearchCriteria> params);	
	
}
