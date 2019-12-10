package com.ecommerce.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.controller.ProductController;
import com.ecommerce.dao.IGenericDao;
import com.ecommerce.dao.ProductDao;
import com.ecommerce.model.Product;
import com.ecommerce.util.SearchCriteria;

@Service
public class ProductService implements IProductService{
	
	Logger logger=LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	ProductDao productDao;
	
	@Autowired
	IGenericDao<Product> genericDao;
		
	@Override
	public List<Product> searchProduct(List<SearchCriteria> params) {		
		logger.info("searchProduct");
		return genericDao.search(params,Product.class);
	}
	
	@Override
	public List<Product> findProductsGroupByBrand(String brand) {		
		return productDao.findProductsGroupByBrand(brand);
	}

	@Override
	public Iterable<Product> saveProduct(List<Product> products) {

		return productDao.saveAll(products);				
	}

	@Override
	public long getProductCount() {

		return productDao.count();				
	}

	
}
