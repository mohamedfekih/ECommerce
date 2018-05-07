package com.ebiznext.ecommerce.dao.impl;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import com.ebiznext.ecommerce.dao.CategoryDao;
import com.ebiznext.ecommerce.model.Category;

public class CategoryDaoImpl implements CategoryDao {
	
	Map<Integer, Category> categoryHashtable = new Hashtable<Integer, Category>();
	
	@Override
	public boolean save(Category entity) {
		// TODO Auto-generated method stub
		if (entity != null) {
			categoryHashtable.put(entity.getId(), entity);
			return true;
		}
		return false;
	}

	@Override
	public boolean update(Category entity) {
		// TODO Auto-generated method stub
		if (entity != null &&  categoryHashtable.get(entity.getId())!=null) {
			categoryHashtable.remove(entity.getId());
			categoryHashtable.put(entity.getId(), entity);
			return true;
		}
		return false;
	}
	
	@Override
	public Category findById(Integer entityId) {
		// TODO Auto-generated method stub
		if (entityId != null)
			return categoryHashtable.get(entityId);
		return null;
	}

	@Override
	public List<Category> findAll() {
		// TODO Auto-generated method stub
		if (categoryHashtable.size() != 0)
			return (List<Category>) categoryHashtable.values();
		return null;
	}

	@Override
	public boolean delete(Integer entityId) {
		// TODO Auto-generated method stub
		if (entityId != null && categoryHashtable.containsKey(entityId)) {
			categoryHashtable.remove(entityId);
			return true;
		}
		return false;
	}

}
