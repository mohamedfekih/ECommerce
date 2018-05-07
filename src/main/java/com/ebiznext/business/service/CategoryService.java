package com.ebiznext.business.service;

import java.util.List;

import com.ebiznext.ecommerce.model.Category;

public interface CategoryService {
	
	public Category findCategoryByName(String categoryName);

	public void save(Category category);

	public boolean update(Category category);

	public boolean delete(Integer categoryId);

	public List<Category> getAllCategories();
}
