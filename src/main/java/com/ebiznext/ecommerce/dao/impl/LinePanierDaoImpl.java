package com.ebiznext.ecommerce.dao.impl;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import com.ebiznext.ecommerce.dao.LinePanierDao;
import com.ebiznext.ecommerce.model.Customer;
import com.ebiznext.ecommerce.model.LinePanier;
import com.ebiznext.ecommerce.model.Panier;

public class LinePanierDaoImpl implements LinePanierDao {

	public static Map<Integer, LinePanier> linePanierHashtable = new Hashtable<Integer, LinePanier>();
	
	public boolean save(LinePanier entity) {
		// TODO Auto-generated method stub
		if (entity != null) {
			linePanierHashtable.put(entity.getId(), entity);
			return true;
		}
		return false;
	}

	@Override
	public boolean update(LinePanier entity) {
		// TODO Auto-generated method stub
		if (entity != null &&  linePanierHashtable.get(entity.getId())!=null) {
			linePanierHashtable.remove(entity.getId());
			linePanierHashtable.put(entity.getId(), entity);
			return true;
		}
		return false;
	}
	
	public LinePanier findById(Integer entityId) {
		// TODO Auto-generated method stub
		if (entityId != null)
			return linePanierHashtable.get(entityId);
		return null;
	}

	public List<LinePanier> findAll() {
		// TODO Auto-generated method stub
		if (linePanierHashtable.size() != 0)
			return (List<LinePanier>) linePanierHashtable.values();
		return null;
	}

	public boolean delete(Integer entityId) {
		// TODO Auto-generated method stub
		if (entityId != null && linePanierHashtable.containsKey(entityId)) {
			linePanierHashtable.remove(entityId);
			return true;
		}
		return false;
	}

	public Panier findPanierByCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

}
