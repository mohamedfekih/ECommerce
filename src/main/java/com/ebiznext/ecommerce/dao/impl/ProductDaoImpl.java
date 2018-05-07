package com.ebiznext.ecommerce.dao.impl;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import com.ebiznext.ecommerce.dao.ProductDao;
import com.ebiznext.ecommerce.model.Product;

public class ProductDaoImpl implements ProductDao {
	
	Map<Integer, Product> prodcutHashtable = new Hashtable<Integer, Product>();
	
	@Override
	public boolean save(Product entity) {
		// TODO Auto-generated method stub
		if (entity != null) {
			prodcutHashtable.put(entity.getId(), entity);
			return true;
		}
		return false;
	}

	@Override
	public boolean update(Product entity) {
		// TODO Auto-generated method stub
		if (entity != null &&  prodcutHashtable.get(entity.getId())!=null) {
			prodcutHashtable.remove(entity.getId());
			prodcutHashtable.put(entity.getId(), entity);
			return true;
		}
		return false;
	}
	
	
	@Override
	public Product findById(Integer entityId) {
		// TODO Auto-generated method stub
		if (entityId != null)
			return prodcutHashtable.get(entityId);
		return null;
	}

	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		if (prodcutHashtable.size() != 0)
			return (List<Product>) prodcutHashtable.values();
		return null;
	}


	@Override
	public boolean delete(Integer entityId) {
		// TODO Auto-generated method stub
		if (entityId != null && prodcutHashtable.containsKey(entityId)) {
			prodcutHashtable.remove(entityId);
			return true;
		}
		return false;
	}

}
