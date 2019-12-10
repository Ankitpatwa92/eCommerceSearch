package com.ecommerce.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.ecommerce.model.Supplier;

public interface SupplierDao extends CrudRepository<Supplier,Long> {
	   
    List<Supplier> findAll();
    
    Optional<Supplier> findById(Long id);
    
    Optional<Supplier> findByName(String name);

}
