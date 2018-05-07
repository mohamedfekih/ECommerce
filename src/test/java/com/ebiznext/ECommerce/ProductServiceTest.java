package com.ebiznext.ECommerce;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.ebiznext.business.service.impl.ProductServiceImpl;
import com.ebiznext.ecommerce.dao.ProductDao;
import com.ebiznext.ecommerce.model.Category;
import com.ebiznext.ecommerce.model.Product;

public class ProductServiceTest {

	@InjectMocks
	ProductServiceImpl productService;

	@Mock
	ProductDao productDao;

	Map<Integer, Product> productHashtable;

	@Before
	public void initTest() throws Exception {

		List<Product> allProducts = this.getProductsMock();
		MockitoAnnotations.initMocks(this);
		when(productDao.findAll()).thenReturn(allProducts);
	}

	@Test
	public void allProductsHaveDesignations() {
		List<Product> products = productService.getAllProducts();
		products.forEach(product -> {
			assertNotNull(product.getDesignation());
		});
	}

	@Test
	public void searchProductByDesignationOk() {
		Category category1= new Category(1,"category1","shampoing");
		Product product= new Product(1,UUID.randomUUID(),"PR653","Gel Douche",false, category1);
		assertNotNull(productService.findProductyByDesignation("PR653"));
		assertEquals(product.getDesignation(), productService.findProductyByDesignation("PR653").getDesignation());
	}

	@Test
	public void deleteProductOk() {
		Product product = productService.findProductyByDesignation("PR653");
		assertNotNull(product.getProductUid());
		productDao.delete(product.getId());
		// assertNull(product.getName());
	}

	@Test
	public void testUpdateProductOK() {
		Category category1= new Category(1,"category1","shampoing");
		Product product= new Product(1,UUID.randomUUID(),"PR653","Gel Douche",false, category1);
		assertTrue(productService.update(product));
	}

	/**
	 * Mock product
	 * 
	 * @return
	 */

	public List<Product> getProductsMock() {

		Category category1= new Category(1,"category1","shampoing");
		Product product1 = new Product(1,UUID.randomUUID(),"PR653","Gel Douche",false, category1);
		Product product2 = new Product(1,UUID.randomUUID(),"PR654","Cyteal",false, category1);
		Product product3 = new Product(1,UUID.randomUUID(),"PR655","L Oreal",false, category1);

		return new ArrayList<Product>(Arrays.asList(product1, product2, product3));
	}

}
