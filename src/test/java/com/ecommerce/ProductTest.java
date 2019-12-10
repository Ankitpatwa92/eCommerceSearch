package com.ecommerce;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import com.ecommerce.model.Product;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ProductTest {

	@Autowired
	private MockMvc mvc;

	@Test
	@Order(1)
	public void saveProductTest() throws Exception {
		String jsonString = getProductList();
		mvc.perform(MockMvcRequestBuilders.post("/product/add").content(jsonString).accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.[*].id").exists());
	}

	@Test
	public void searchProductByBrand() throws Exception {

		mvc.perform(MockMvcRequestBuilders.get("/product/find?search=brand:Puma").accept(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.[*].brand").value("Puma"));
	}

	@Test
	public void searchProductBySupplier() {
		assert (true);
	}

	@Test
	public void searchProductBySKU() {
		assert (true);
	}

	@Test
	public void searchProductByPrice() {
		assert (true);
	}

	@Test
	public void searchProductByCategory() {
		assert (true);
	}

	private static String getProductList() throws JsonProcessingException {

		Product product1 = new Product();
		product1.setBrand("Puma");

		Product product2 = new Product();
		product2.setBrand("Spark");

		ArrayList<Product> prodList = new ArrayList<>();
		prodList.add(product1);
		prodList.add(product2);

		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(prodList);
	}
}
