package com.ebiznext.business.service;

import java.util.List;
import java.util.UUID;

import com.ebiznext.ecommerce.model.Product;

public interface ProductService {
	
	public Product findProductyByCode(UUID productUid);
	
	public Product findProductyByDesignation(String designation);

	public void save(Product product);

	public boolean update(Product product);

	public boolean delete(Integer productId);

	public List<Product> getAllProducts();
}
