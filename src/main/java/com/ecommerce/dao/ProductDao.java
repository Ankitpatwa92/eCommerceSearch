package com.ecommerce.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ecommerce.model.Product;

public interface ProductDao extends CrudRepository<Product,Long> {
	
    List<Product> findProductsGroupByPrice(Integer price);
    
    List<Product> findProductsGroupByBrand(String brand);
    
    List<Product> findProductsGroupByColor(String color);
        
}
