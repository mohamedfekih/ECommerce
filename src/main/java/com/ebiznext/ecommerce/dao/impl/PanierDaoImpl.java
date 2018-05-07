package com.ebiznext.ecommerce.dao.impl;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import com.ebiznext.ecommerce.dao.PanierDao;
import com.ebiznext.ecommerce.model.Customer;
import com.ebiznext.ecommerce.model.Panier;

public class PanierDaoImpl implements PanierDao {
	
	Map<Integer, Panier> panierHashtable = new Hashtable<Integer, Panier>();

	@Override
	public boolean save(Panier entity) {
		// TODO Auto-generated method stub
		if (entity != null) {
			panierHashtable.put(entity.getId(), entity);
			return true;
		}
		return false;
	}

	@Override
	public boolean update(Panier entity) {
		// TODO Auto-generated method stub
		if (entity != null &&  panierHashtable.get(entity.getId())!=null) {
			panierHashtable.remove(entity.getId());
			panierHashtable.put(entity.getId(), entity);
			return true;
		}
		return false;
	}
	
	
	@Override
	public Panier findById(Integer entityId) {
		// TODO Auto-generated method stub
		if (entityId != null)
			return panierHashtable.get(entityId);
		return null;
	}

	@Override
	public List<Panier> findAll() {
		// TODO Auto-generated method stub
		if (panierHashtable.size() != 0)
			return (List<Panier>) panierHashtable.values();
		return null;
	}

	@Override
	public boolean delete(Integer entityId) {
		// TODO Auto-generated method stub
		if (entityId != null && panierHashtable.containsKey(entityId)) {
			panierHashtable.remove(entityId);
			return true;
		}
		return false;
	}

	@Override
	public Panier findPanierByCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

}
