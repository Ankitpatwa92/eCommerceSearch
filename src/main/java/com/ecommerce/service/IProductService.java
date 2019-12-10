package com.ecommerce.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ecommerce.model.Product;
import com.ecommerce.util.SearchCriteria;

@Service
public interface IProductService {
	
	public List<Product> searchProduct(List<SearchCriteria> params);

	List<Product> findProductsGroupByBrand(String brand);

	public Iterable<Product> saveProduct(List<Product> products);

	public long getProductCount();

}
