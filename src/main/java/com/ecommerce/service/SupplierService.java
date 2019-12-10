package com.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.dao.GenericDao;
import com.ecommerce.dao.SupplierDao;
import com.ecommerce.model.Supplier;
import com.ecommerce.util.SearchCriteria;

@Service
public class SupplierService implements ISupplierService {
	
	@Autowired
	SupplierDao  supplierRepo;
	
	@Autowired
	GenericDao<Supplier> supplier;
	
	@Override
	public List<Supplier> getAllSuppliers(){				
		return supplierRepo.findAll();
	}
	
	@Override
	public Iterable<Supplier> saveSupplier(List<Supplier> suppliers) {								
		return supplierRepo.saveAll(suppliers);		
	}

	@Override 
	public List<Supplier> searchSupplier(List<SearchCriteria> params) {
		return supplier.search(params,Supplier.class);
	}
	
}