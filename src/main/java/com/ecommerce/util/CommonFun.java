package com.ecommerce.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ecommerce.controller.ProductController;

public class CommonFun {

	static Logger logger = LoggerFactory.getLogger(ProductController.class);

	public static List<SearchCriteria> getSearchParams(String search) {

		List<SearchCriteria> params = new ArrayList<SearchCriteria>();
		if (search != null) {
			Pattern pattern = Pattern.compile("([\\w\\.]+?)(:|<|>=|>|<=)([\\w\\;\\w]+?),");

			Matcher matcher = pattern.matcher(search + ",");
			while (matcher.find()) {
				params.add(new SearchCriteria(matcher.group(1), matcher.group(2), matcher.group(3)));
				logger.info("search params1:{},param2:{},param3:{}", matcher.group(1), matcher.group(2),
						matcher.group(3));
			}
		}
		return params;
	}

}
