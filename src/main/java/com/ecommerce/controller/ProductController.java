package com.ecommerce.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.model.Product;
import com.ecommerce.service.IProductService;
import com.ecommerce.util.CommonFun;
import com.ecommerce.util.SearchCriteria;

@RestController
@RequestMapping("/product")

public class ProductController {

	Logger logger=LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	IProductService productService;
	
	@RequestMapping("/add")
	public Iterable<Product> saveProduct(@RequestBody List<Product> products) {
		logger.info("saveProduct");
		return productService.saveProduct(products);				
	}
	
	
	/**
	 * 
	 * @param search
	 * @return
	 * 
	 * while searching condition can be applied
	 * search=name:spark;canvas,price>100
	 */
	 @RequestMapping(method = RequestMethod.GET, value = "/find")	    
	 public List<Product> findAll(@RequestParam(value = "search", required = false) String search) {
		 logger.info("findAll");
	        List<SearchCriteria> params = new ArrayList<SearchCriteria>();
	        params=CommonFun.getSearchParams(search);
	        return productService.searchProduct(params);
	    }
         	
}
