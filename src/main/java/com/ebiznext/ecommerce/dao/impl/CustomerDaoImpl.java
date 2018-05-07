package com.ebiznext.ecommerce.dao.impl;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import com.ebiznext.ecommerce.dao.CustomerDao;
import com.ebiznext.ecommerce.model.Customer;

public class CustomerDaoImpl implements CustomerDao {

	Map<Integer, Customer> customerHashtable = new Hashtable<Integer, Customer>();
	
	@Override
	public boolean save(Customer entity) {
		// TODO Auto-generated method stub
		if (entity != null) {
			customerHashtable.put(entity.getId(), entity);
			return true;
		}
		return false;
	}

	@Override
	public boolean update(Customer entity) {
		// TODO Auto-generated method stub
		if (entity != null &&  customerHashtable.get(entity.getId())!=null) {
			customerHashtable.remove(entity.getId());
			customerHashtable.put(entity.getId(), entity);
			return true;
		}
		return false;
	}
	
	@Override
	public Customer findById(Integer entityId) {
		// TODO Auto-generated method stub
		if (entityId != null)
			return customerHashtable.get(entityId);
		return null;
	}

	@Override
	public List<Customer> findAll() {
		// TODO Auto-generated method stub
		if (customerHashtable.size() != 0)
			return (List<Customer>) customerHashtable.values();
		return null;
	}

	@Override
	public boolean delete(Integer entityId) {
		// TODO Auto-generated method stub
		if (entityId != null && customerHashtable.containsKey(entityId)) {
			customerHashtable.remove(entityId);
			return true;
		}
		return false;
	}

}
