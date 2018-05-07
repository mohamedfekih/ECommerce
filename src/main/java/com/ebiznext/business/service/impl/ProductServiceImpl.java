package com.ebiznext.business.service.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.inject.Inject;

import com.ebiznext.business.service.ProductService;
import com.ebiznext.ecommerce.dao.ProductDao;
import com.ebiznext.ecommerce.model.Product;

public class ProductServiceImpl implements ProductService {

	@Inject
	ProductDao productDao;
	
	@Override
	public Product findProductyByCode(UUID productUid) {
		List<Product> productList = productDao.findAll();
		Product product = productList.stream()
				.filter(accountItem -> productUid.equals(accountItem.getProductUid())).findFirst().orElse(null);

		if (product == null)
			throw new IllegalStateException("No Product found.");

		return product;
	}

	@Override
	public void save(Product product) {
		List<Product> productsList = productDao.findAll();
		List<Product> productExits = productsList.stream()
				.filter(iterator -> product.getProductUid().equals(iterator.getProductUid())).collect(Collectors.toList());
		if (!productExits.isEmpty())
			throw new IllegalStateException("Product already exists.");
		productDao.save(product);
		
	}

	@Override
	public boolean update(Product product) {
		productDao.update(product);
		return true;
	}

	@Override
	public boolean delete(Integer productId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Product> getAllProducts() {
		List<Product> productList = productDao.findAll();
		if (productList == null)
			throw new IllegalStateException("No Product found.");
		return productList;
	}

	@Override
	public Product findProductyByDesignation(String designation) {
		List<Product> productList = productDao.findAll();
		Product product = productList.stream()
				.filter(accountItem -> designation.equals(accountItem.getDesignation())).findFirst().orElse(null);

		if (product == null)
			throw new IllegalStateException("No Product found.");

		return product;
	}

}
