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
import com.ecommerce.model.Supplier;
import com.ecommerce.service.ISupplierService;
import com.ecommerce.service.SupplierService;
import com.ecommerce.util.CommonFun;
import com.ecommerce.util.SearchCriteria;

@RestController
@RequestMapping("/supplier")
public class SupplierController {

	Logger logger=LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	ISupplierService supplierService;
	
	@RequestMapping("/getAllSupplier")
	public List<Supplier> getAllSupplier(){
		logger.info("getAllSupplier");
		return supplierService.getAllSuppliers();				
	}
	
	@RequestMapping(path="/add",method=RequestMethod.POST)
	public  Iterable<Supplier> saveSupplier(@RequestBody List<Supplier> suppliers) {
		logger.info("saveSupplier");
		return supplierService.saveSupplier(suppliers);			
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
	 public List<Supplier> findAll(@RequestParam(value = "search", required = false) String search) {
		 logger.info("findAll");
	        List<SearchCriteria> params = new ArrayList<SearchCriteria>();
	        params=CommonFun.getSearchParams(search);
	        return supplierService.searchSupplier(params);
	    }
	
}
